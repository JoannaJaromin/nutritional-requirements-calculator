package joanna.jaromin.requirements.calculator.controller;

import joanna.jaromin.requirements.calculator.dto.MeasurementDto;
import joanna.jaromin.requirements.calculator.dto.SaveMeasurementDto;
import joanna.jaromin.requirements.calculator.service.MeasurementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MeasurementController {

    private final MeasurementService measurementService;

    @GetMapping("/measurements")
    private List<MeasurementDto> findAll() {
        return measurementService.findAll();
    }

    @PostMapping("/measurements")
    private MeasurementDto saveMeasurement(@Valid @RequestBody SaveMeasurementDto dto){
        return measurementService.saveMeasurement(dto);
    }

    @PutMapping("/measurements")
    private MeasurementDto updateMeasurement(@Valid @RequestBody MeasurementDto dto){
        return measurementService.updateMeasurement(dto);
    }

    @DeleteMapping("/measurements/{measurementId")
    private void deleteMeasurement (@PathVariable long measurementId){
        measurementService.deleteById(measurementId);
    }
}
