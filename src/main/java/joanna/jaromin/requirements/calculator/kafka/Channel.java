package joanna.jaromin.requirements.calculator.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface Channel {

    String MEASUREMENTS_UPDATED = "MeasurementSavedOrUpdated";

    @Input(Channel.MEASUREMENTS_UPDATED)
    SubscribableChannel measurementUpdated();

    @Output(Channel.MEASUREMENTS_UPDATED)
    SubscribableChannel sendMeasurementUpdated();
}
