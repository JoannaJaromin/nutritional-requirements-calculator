package joanna.jaromin.requirements.calculator.kafka;

import joanna.jaromin.requirements.calculator.dto.MeasurementDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(Channel.class)
@Configuration
@RequiredArgsConstructor
@Slf4j
public class MeasurementUpdatedOutputHandler {

    @SendTo(Channel.MEASUREMENT_UPDATED_OUTPUT)
    public void handleMeasurementUpdated(@Payload MeasurementDto measurementDto){
    }
}
