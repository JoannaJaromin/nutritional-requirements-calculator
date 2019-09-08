package joanna.jaromin.requirements.calculator.kafka;

import joanna.jaromin.requirements.calculator.email.EmailData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmailSender {

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    protected void sendEmail(EmailData emailData) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, "UTF-8");
            messageHelper.setSubject(emailData.getSubject());
            messageHelper.setTo(emailData.getRecipient());
            String htmlContent = templateEngine.process(emailData.getTemplateName(), emailData.getContext());
            messageHelper.setText(htmlContent, true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error(e.getMessage());
        }
    }
}
