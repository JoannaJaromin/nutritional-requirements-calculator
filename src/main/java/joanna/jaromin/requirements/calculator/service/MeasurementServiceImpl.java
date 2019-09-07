package joanna.jaromin.requirements.calculator.service;

import joanna.jaromin.requirements.calculator.converters.MeasurementConverter;
import joanna.jaromin.requirements.calculator.converters.SaveMeasurementConverter;
import joanna.jaromin.requirements.calculator.dto.MeasurementDto;
import joanna.jaromin.requirements.calculator.dto.SaveMeasurementDto;
import joanna.jaromin.requirements.calculator.entity.Measurement;
import joanna.jaromin.requirements.calculator.exception.RecordNotFoundException;
import joanna.jaromin.requirements.calculator.kafka.Channel;
import joanna.jaromin.requirements.calculator.repository.MeasurementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MeasurementServiceImpl implements MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final MeasurementConverter measurementConverter;
    private final SaveMeasurementConverter saveMeasurementConverter;

    @Qualifier(Channel.MEASUREMENTS_UPDATED)
    private final MessageChannel messageChannel;


    @Override
    @Transactional(readOnly = true)
    public List<MeasurementDto> findAll() {
        return Optional.of(measurementRepository.findAll())
                .map(measurementsList -> measurementConverter.mapAsList(measurementsList, MeasurementDto.class))
                .orElseThrow(() -> new RecordNotFoundException("Brak pomiarów do wyświetlenia"));
    }

    @Override
    public MeasurementDto findById(long id) {
        return Optional.ofNullable(measurementRepository.findByIdCustom(id))
                .map(measurement -> measurementConverter.map(measurement, MeasurementDto.class))
                .orElseThrow(() -> new RecordNotFoundException("Nie znaleziono pomiaru o id: " + id));
    }

    @Override
    @Transactional
    public MeasurementDto saveMeasurement(SaveMeasurementDto dto) {
        Measurement measurement = saveMeasurementConverter.map(dto, Measurement.class);
        Measurement savedMeasurement = measurementRepository.save(measurement);
        MeasurementDto savedDto = measurementConverter.map(savedMeasurement, MeasurementDto.class);
        messageChannel.send(new GenericMessage<>(savedDto));
        return savedDto;
    }

    @Override
    @Transactional
    public MeasurementDto updateMeasurement(MeasurementDto dto) {
        Measurement measurement = measurementConverter.map(dto, Measurement.class);
        Measurement savedMeasurement = measurementRepository.save(measurement);
        MeasurementDto updatedDto = measurementConverter.map(savedMeasurement, MeasurementDto.class);
        messageChannel.send(new GenericMessage<>(updatedDto));
        return updatedDto;
    }

    @Override
    @Transactional
    public void deleteById(long measurementId) {
        measurementRepository.deleteById(measurementId);
    }
}
