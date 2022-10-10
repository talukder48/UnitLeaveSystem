package com.panacea.api;

/************************************************************************************
 * Reference: (https://javapapers.com/core-java/java-email/)
 * Developed By Mosharraf 
 * Need 2 jar files smtp.jar,mailapi.jar
 * Allow less secure apps (ON) ( https://myaccount.google.com/lesssecureapps)  
 ***********************************************************************************/

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.activation.*;

public class GmailSMTPService {
	Properties emailProperties;
	Session mailSession;
	MimeMessage emailMessage;

	public  String SentMail(String mailHeader, String mailBody, String UserMail, String UserPassword,String bulkMail[], byte[] pdfBytes,String Filename) 
	{
		try {
			GmailSMTPService bulkmailService = new GmailSMTPService();
			bulkmailService.setMailServerProperties();
			bulkmailService.createEmailMessage(mailHeader, mailBody, bulkMail, pdfBytes,Filename);
			bulkmailService.post(UserMail, UserPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Sucess";
	}

	private void setMailServerProperties() {
		emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", "587");//587
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");
		emailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");//    smtp.gmail.com smmbox02.bcc.gov.bd
	}

	private void createEmailMessage(String EmailSubject, String EmailBody, String[] bulkMail, byte[] pdfBytes,String Filename)
			throws AddressException, MessagingException {
		mailSession = Session.getDefaultInstance(emailProperties, null);
		emailMessage = new MimeMessage(mailSession);
		for (int i = 0; i < bulkMail.length; i++) {
			emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(bulkMail[i]));
		}
		emailMessage.setSubject(EmailSubject);

		
		MimeMultipart multipart = new MimeMultipart();
		MimeBodyPart mailBody = new MimeBodyPart();
		mailBody.setText(EmailBody);
		MimeBodyPart attachment = new MimeBodyPart();
		
		attachment.setDataHandler(new DataHandler(new DataSource() {
			public String getContentType() {
				return "application/pdf";
			}
			public InputStream getInputStream() throws IOException {
				return new ByteArrayInputStream(pdfBytes);
			}
			public String getName() {
				return "myfile.pdf";
			}
			public OutputStream getOutputStream() throws IOException {
				return null;
			}
		}));
		
		attachment.setFileName(Filename);
		attachment.setContentMD5("MD5");
		multipart.addBodyPart(attachment);
		multipart.addBodyPart(mailBody);		
		emailMessage.setContent(multipart);
		
	}

	private void post(String UserMail, String UserPassword) throws AddressException, MessagingException {
		String emailHost = "smtp.gmail.com";//    smtp.gmail.com
		Transport transport = mailSession.getTransport("smtp");
		transport.connect(emailHost, UserMail, UserPassword);
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
	}
}
