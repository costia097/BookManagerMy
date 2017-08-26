package net.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class MailMail {

    private MailSender mailSender;
    private SimpleMailMessage simpleMailMessage;

    @Autowired
    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
        this.simpleMailMessage = simpleMailMessage;
    }

    @Autowired
    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(String dear, String content) {

        SimpleMailMessage message = new SimpleMailMessage(simpleMailMessage);

        message.setText(String.format(
                simpleMailMessage.getText(), dear, content));

        mailSender.send(message);

    }
}
