package joanna.jaromin.requirements.calculator.service;

import joanna.jaromin.requirements.calculator.converters.MeasurementConverter;
import joanna.jaromin.requirements.calculator.converters.SaveMeasurementConverter;
import joanna.jaromin.requirements.calculator.dto.MeasurementDto;
import joanna.jaromin.requirements.calculator.dto.SaveMeasurementDto;
import joanna.jaromin.requirements.calculator.entity.Measurement;
import joanna.jaromin.requirements.calculator.exception.RecordNotFoundException;
import joanna.jaromin.requirements.calculator.repository.MeasurementRepository;
import lombok.RequiredArgsConstructor;
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

    @Override
    @Transactional(readOnly = true)
    public List<MeasurementDto> findAll() {
        return Optional.of(measurementRepository.findAll())
                .map(measurementsList -> measurementConverter.mapAsList(measurementsList, MeasurementDto.class))
                .orElseThrow(() -> new RecordNotFoundException("Brak pomiarów do wyświetlenia"));
    }

    @Override
    @Transactional
    public MeasurementDto saveMeasurement(SaveMeasurementDto dto) {
        Measurement measurement = saveMeasurementConverter.map(dto, Measurement.class);
        Measurement savedMeasurement = measurementRepository.save(measurement);
        return measurementConverter.map(savedMeasurement, MeasurementDto.class);
    }

    @Override
    @Transactional
    public MeasurementDto updateMeasurement(MeasurementDto dto) {
        Measurement measurement = measurementConverter.map(dto, Measurement.class);
        Measurement savedMeasurement = measurementRepository.save(measurement);
        return measurementConverter.map(savedMeasurement, MeasurementDto.class);
    }

    @Override
    public void deleteById(long measurementId) {
        measurementRepository.deleteById(measurementId);
    }
}
