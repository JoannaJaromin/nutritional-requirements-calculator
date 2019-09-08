package joanna.jaromin.requirements.calculator.dto;

import joanna.jaromin.requirements.calculator.entity.UserData;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDataConverter extends ConfigurableMapper {

    protected void configure(MapperFactory factory){
        factory.classMap(UserData.class, UserDataDto.class)
                .field("user.id", "userId")
                .byDefault().register();
    }
}
