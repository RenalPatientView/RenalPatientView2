package com.worthsoln.patientview;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AWSJavaMailTransport;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import java.util.Properties;

public class EmailUtils {

    public static void sendEmail(ServletContext context, String emailText) {
        sendEmail(context, "Intranet Feedback", emailText);
    }

    public static void sendEmail(ServletContext context, String subject, String emailText) {
        String to = context.getInitParameter("admin.email.to");
        sendEmail(context, to, subject, emailText);
    }

    public static void sendEmail(ServletContext context, String toAddress, String subject, String emailText) {
        String from = context.getInitParameter("noreply.email");
        sendEmail(context, from, toAddress, subject, emailText);
    }

    public static void sendEmail(ServletContext context, String fromAddress, String toAddress, String subject, String emailText) {
        sendEmail(context, fromAddress, toAddress, "", subject, emailText);
    }

    public static void sendEmail(ServletContext context, String fromAddress, String toAddress, String ccAddress, String subject, String emailText) {
        /* try {
           String host = context.getInitParameter("smtp.host");
           Properties props = System.getProperties();
           props.put("mail.smtp.host", host);
           Session session = Session.getInstance(props, null);
           MimeMessage email = new MimeMessage(session);
           email.setFrom(new InternetAddress(fromAddress));
           email.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
           if (null != ccAddress && !"".equals(ccAddress)) {
               email.addRecipient(Message.RecipientType.CC, new InternetAddress(ccAddress));
           }
           email.setSubject(subject);
           email.setText(emailText);
           Transport.send(email);
       } catch (MessagingException e) {
           System.err.println("EmailUtils: Failed to send email - " + e.getMessage());
           e.printStackTrace();
       } */

        BasicAWSCredentials credentials = new BasicAWSCredentials(context.getInitParameter("aws.accesskeyid"), context.getInitParameter("aws.secretkey"));

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "aws");
        props.setProperty("mail.aws.user", credentials.getAWSAccessKeyId());
        props.setProperty("mail.aws.password", credentials.getAWSSecretKey());

        javax.mail.Session session = javax.mail.Session.getInstance(props);

        try {
            // Create a new Message
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromAddress));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
            msg.setSubject(subject);
            msg.setText(emailText);
            msg.saveChanges();

            // Reuse one Transport object for sending all your messages
            // for better performance
            Transport t = new AWSJavaMailTransport(session, null);
            t.connect();
            t.sendMessage(msg, null);

            // Close your transport when you're completely done sending
            // all your messages
            t.close();
        } catch (AddressException e) {
            e.printStackTrace();
            System.out.println("Caught an AddressException, which means one or more of your "
                    + "addresses are improperly formatted.");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Caught a MessagingException, which means that there was a "
                    + "problem sending your message to Amazon's E-mail Service check the "
                    + "stack trace for more information.");
        }
    }
}
