package joanna.jaromin.requirements.calculator.dto;

import joanna.jaromin.requirements.calculator.entity.User;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends ConfigurableMapper {

    protected void configure(MapperFactory factory){
        factory.classMap(User.class, UserDto.class)
                .byDefault().register();
    }
}
