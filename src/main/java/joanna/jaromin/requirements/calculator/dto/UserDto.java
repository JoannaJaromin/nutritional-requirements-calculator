package joanna.jaromin.requirements.calculator.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    private int id;

    @NotNull
    private String username;

}
