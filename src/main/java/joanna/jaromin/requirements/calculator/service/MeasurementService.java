package joanna.jaromin.requirements.calculator.service;

import joanna.jaromin.requirements.calculator.dto.MeasurementDto;
import joanna.jaromin.requirements.calculator.dto.SaveMeasurementDto;

import java.util.List;

public interface MeasurementService {

    List<MeasurementDto> findAll();

    MeasurementDto saveMeasurement(SaveMeasurementDto dto);

    MeasurementDto updateMeasurement(MeasurementDto dto);

    void deleteById(long measurementId);
}
