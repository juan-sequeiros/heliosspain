package es.heliosspain.against.covid19.config.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class MailSender  extends JavaMailSenderImpl {

    @Autowired
    private MailConfig mailConfig;

    @Override
    public String getHost(){
        return mailConfig.getHost();
    }

    @Override
    public int getPort(){
        return mailConfig.getPort();
    }

    @Override
    public String getProtocol(){
        return mailConfig.getProtocol();
    }

    @Override
    public String getUsername(){
        return mailConfig.getUsername();
    }

    @Override
    public String getPassword(){
        return mailConfig.getPassword();
    }

    @PostConstruct
    public void postConstruct(){
        this.getJavaMailProperties().setProperty("mail.smtp.auth",getMailConfig().getAuth());
        this.getJavaMailProperties().setProperty("mail.smtp.starttls.enable",getMailConfig().getStarTTLSEnable());
    }

    public MailConfig getMailConfig() {
        return mailConfig;
    }

    public void setMailConfig(MailConfig mailConfig) {
        this.mailConfig = mailConfig;
    }
}
