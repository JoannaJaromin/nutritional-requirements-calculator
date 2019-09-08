package joanna.jaromin.requirements.calculator.email;

import joanna.jaromin.requirements.calculator.dto.MeasurementDto;
import joanna.jaromin.requirements.calculator.dto.UserDataDto;
import joanna.jaromin.requirements.calculator.dto.UserDto;
import joanna.jaromin.requirements.calculator.entity.Requirements;
import joanna.jaromin.requirements.calculator.service.RequirementsService;
import joanna.jaromin.requirements.calculator.service.UserDataService;
import joanna.jaromin.requirements.calculator.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;

@Component
@RequiredArgsConstructor
public class EmailDataProvider {

    private final UserService userService;
    private final UserDataService userDataService;
    private final RequirementsService requirementsService;
    private final RequirementsIdProvider requirementsIdProvider;
    private final String SUBJECT = "Zaktualizowano pomiar";
    private final String TEMPLATE = "measurement-updated";

    public EmailData mapMeasurementsUpdated(MeasurementDto measurementDto) {
        UserDto userDto = userService.findById(measurementDto.getUserId());
        UserDataDto userDataDto = userDataService.findById(userDto.getId());
        int requirementsId = requirementsIdProvider.getRequirementsId(measurementDto, userDataDto);
        Requirements requirements = requirementsService.findById(requirementsId);
        Context context = createContext(userDto, requirements, measurementDto);
        return new EmailData(userDataDto.getEmail(), SUBJECT, TEMPLATE, context);
    }

    private Context createContext(UserDto userDto, Requirements requirements, MeasurementDto measurementDto) {
        Context context = new Context();
        context.setVariable("username", userDto.getUsername());
        context.setVariable("requirements", requirements);
        context.setVariable("measurement", measurementDto);
        return context;
    }
}
