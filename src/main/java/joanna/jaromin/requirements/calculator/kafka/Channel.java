package joanna.jaromin.requirements.calculator.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Channel {

    String MEASUREMENT_UPDATED_OUTPUT = "measurementUpdatedOutput";
    String MEASUREMENT_UPDATED_INPUT = "measurementUpdatedInput";

    @Input(Channel.MEASUREMENT_UPDATED_INPUT)
    SubscribableChannel sendEmailAboutUpdatedMeasurement();

    @Output(Channel.MEASUREMENT_UPDATED_OUTPUT)
    MessageChannel notifyAboutUpdatedMeasurement();
}
