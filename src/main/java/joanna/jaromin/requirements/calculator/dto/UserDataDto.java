package joanna.jaromin.requirements.calculator.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class UserDataDto {

    private int id;

    @NotNull
    private String sex;

    @NotNull
    private LocalDate dateOfBirth;

    @NotNull
    private String email;

    @NotNull
    private int userId;
}
