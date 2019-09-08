package joanna.jaromin.requirements.calculator.email;

import lombok.Data;
import org.thymeleaf.context.Context;

@Data
public class EmailData {
    private final String recipient;
    private final String subject;
    private final String templateName;
    private final Context context;
}

