package joanna.jaromin.requirements.calculator.converters;

import joanna.jaromin.requirements.calculator.dto.SaveMeasurementDto;
import joanna.jaromin.requirements.calculator.entity.Measurement;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class SaveMeasurementConverter extends ConfigurableMapper {

    protected void configure(MapperFactory factory){
        factory.classMap(Measurement.class, SaveMeasurementDto.class)
                .field("user.id", "userId")
                .byDefault().register();
    }
}
