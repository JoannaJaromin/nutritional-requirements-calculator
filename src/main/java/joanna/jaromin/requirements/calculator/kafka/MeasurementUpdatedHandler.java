package joanna.jaromin.requirements.calculator.kafka;

import joanna.jaromin.requirements.calculator.dto.MeasurementDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;

@EnableBinding(Channel.class)
@Configuration
@RequiredArgsConstructor
public class MeasurementUpdatedHandler {

    @StreamListener(Channel.MEASUREMENTS_UPDATED)
    public void handle(MeasurementDto measurementDto){
        
    }
}
