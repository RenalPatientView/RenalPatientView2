package com.worthsoln.patientview;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;

public class EmailUtils {

    public static void sendEmail(ServletContext context, String emailText) {
        try {
            String host = context.getInitParameter("smtp.host");
            String from = context.getInitParameter("admin.email.from");
            String to = context.getInitParameter("admin.email.to");
            Properties props = System.getProperties();
            props.put("mail.smtp.host", host);
            Session session = Session.getInstance(props, null);
            MimeMessage email = new MimeMessage(session);
            email.setFrom(new InternetAddress(from));
            email.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            email.setSubject("Intranet Feedback");
            email.setText(emailText);
            Transport.send(email);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
