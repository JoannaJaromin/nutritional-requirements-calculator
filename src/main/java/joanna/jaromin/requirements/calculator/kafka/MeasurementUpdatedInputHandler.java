package joanna.jaromin.requirements.calculator.kafka;

import joanna.jaromin.requirements.calculator.email.EmailData;
import joanna.jaromin.requirements.calculator.email.EmailDataProvider;
import joanna.jaromin.requirements.calculator.dto.MeasurementDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;

@EnableBinding(Channel.class)
@Configuration
@RequiredArgsConstructor
@Slf4j
public class MeasurementUpdatedInputHandler {

    private final EmailDataProvider emailDataProvider;
    private final EmailSender emailSender;

    @StreamListener(Channel.MEASUREMENT_UPDATED_INPUT)
    public void handle(MeasurementDto measurementDto){
        try{
            EmailData emailData = emailDataProvider.mapMeasurementsUpdated(measurementDto);
            emailSender.sendEmail(emailData);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
