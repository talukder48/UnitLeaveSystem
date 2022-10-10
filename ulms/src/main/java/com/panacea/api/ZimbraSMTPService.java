package com.panacea.api;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.panacea.info.MailConfiguration;


public class ZimbraSMTPService {
	public String BulkMailService(String MailReceiver, String MailSubject, String MailBody, String AttachemntName,
			byte[] MailAttachment) {
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.host", MailConfiguration.EmailHost);
		mailProperties.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(mailProperties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MailConfiguration.SystemMail, MailConfiguration.SystemPassword);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(MailConfiguration.SystemMail));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(MailReceiver));
			message.setSubject(MailSubject);

			MimeMultipart multipart = new MimeMultipart();
			MimeBodyPart mailBody = new MimeBodyPart();
			mailBody.setText(MailBody);
			MimeBodyPart attachment = new MimeBodyPart();

			attachment.setDataHandler(new DataHandler(new DataSource() {
				public String getContentType() {
					return "application/pdf";
				}

				public InputStream getInputStream() throws IOException {
					return new ByteArrayInputStream(MailAttachment);
				}

				public String getName() {
					return "myfile.pdf";
				}

				public OutputStream getOutputStream() throws IOException {
					return null;
				}
			}));

			attachment.setFileName(AttachemntName);
			attachment.setContentMD5("MD5");
			multipart.addBodyPart(attachment);
			multipart.addBodyPart(mailBody);
			message.setContent(multipart);
			Transport.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
			return "fail";
		}
		return "Sucess";

	}

}
