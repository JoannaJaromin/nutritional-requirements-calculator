package joanna.jaromin.requirements.calculator.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MeasurementDto {

    private boolean pregnant;
    private boolean breastfeeding;
    private long id;
    private int userId;
    private LocalDate measurementDate;
    private int height;
    private int weight;
    private int hips;
    private int belly;
    private int waist;
    private double pal;
}
