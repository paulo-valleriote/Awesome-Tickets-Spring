package valleriote.paulo.awesometickets.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class SpringMailConfig {
    @Value("${spring.mail.username}")
    private final String smtpUsername = "john@doe.com";
    @Value("${spring.mail.placeholder}")
    private final String smtpPassword = "johndoe";
    @Value("${spring.mail.host}")
    private final String smtpHost = "smtp.example.com";
    @Value("${spring.mail.port}")
    private final Integer smtpPort = 0;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(smtpHost);
        mailSender.setPort(smtpPort);

        mailSender.setUsername(smtpUsername);
        mailSender.setPassword(smtpPassword);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
