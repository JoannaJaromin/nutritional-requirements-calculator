package joanna.jaromin.requirements.calculator.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class MeasurementDto {

    private long id;

    private int userId;

    private LocalDate measurementDate;

    @NotNull
    private int height;

    @NotNull
    private int weight;

    private int hips;

    private int belly;

    private int waist;

    @NotNull
    private double pal;

    private boolean pregnant;

    private boolean breastfeeding;
}
