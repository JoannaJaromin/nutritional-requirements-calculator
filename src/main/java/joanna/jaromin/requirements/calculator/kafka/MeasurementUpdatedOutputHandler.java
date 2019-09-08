package joanna.jaromin.requirements.calculator.kafka;

import joanna.jaromin.requirements.calculator.dto.MeasurementDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

@EnableBinding(Channel.class)
@Configuration
@RequiredArgsConstructor
@Slf4j
public class MeasurementUpdatedOutputHandler {

    private final Channel channel;

    public void handleMeasurementUpdated(final MeasurementDto measurementDto){
        MessageChannel messageChannel = channel.notifyAboutUpdatedMeasurement();
        messageChannel.send(MessageBuilder
        .withPayload(measurementDto)
        .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
        .build());
    }
}
