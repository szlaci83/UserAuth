package me.laszloszoboszlai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service("emailService")
public class MailServiceImpl {
    private String DEFAULT_FROM = "validation@serice.com";
    private String DEFAULT_SUBJECT = "Login activation link inside!";

    @Autowired
    private MailSender mailSender;


    private String subject = DEFAULT_SUBJECT;
    private String fromMail = DEFAULT_FROM;

    public String MailBodyBuilder(String name, String uri){
        StringBuilder body = new StringBuilder();

        body.append("Dear " + name + ",\n");
        body.append("\n");
        body.append("Thanks for registering, your validation URI is:\n");
        body.append(uri + "\n");
        body.append("copy and paste it to your browser to validate your account! :D ");

        return body.toString();
    }

    public void sendEmail(String to, String from, String sub, String msgBody){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(sub);
        message.setText(msgBody);
        mailSender.send(message);
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public String getFromMail() {
        return fromMail;
    }

    public void setFromMail(String fromMail) {
        this.fromMail = fromMail;
    }

}