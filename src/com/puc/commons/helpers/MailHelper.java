package com.puc.commons.helpers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.puc.commons.exceptions.HelperException;

public class MailHelper {
	
	private String smtpServerAddress;
	private String username;
	private String password;
	private String from;
	private ArrayList<String> to;
	private String subject;
	private String messageBody;
	private String attachment;
	
	public MailHelper(String smtpServerAddress, String username, String password, String from, ArrayList<String> to, String subject, String messageBody, String attachment) {
		super();
		this.smtpServerAddress = smtpServerAddress;
		this.username = username;
		this.password = password;
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.messageBody = messageBody;
		this.attachment = attachment;
	}

	public Boolean sendMail() throws HelperException {
		
		Properties p = new Properties();
		p.put("mail.transport.protocol", "smtp"); 
		p.put("mail.host", this.smtpServerAddress);
		p.put("mail.smtp.auth", true);
		p.put("mail.smtp.ssl.enable", true);
		p.put("mail.mime.charset", "UTF-8");    
		
		try {
			Authenticator auth = new SMTPAuthenticator(this.username, this.password);
			Session mailSession = Session.getDefaultInstance(p, auth);			
			Transport transport = mailSession.getTransport();
	
			MimeMessage msg = new MimeMessage(mailSession);
			
			for (String email : to) {
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));		
			}
			
			msg.setFrom(new InternetAddress(from));
			msg.setSentDate(new Date());
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			
			BodyPart messageBodyPart = new MimeBodyPart(); 
			messageBodyPart.setContent(this.messageBody, "text/html");
			
			MimeMultipart multipart = new MimeMultipart("related");
		    multipart.addBodyPart(messageBodyPart);
		    
			if(!this.attachment.equals("")) {
				DataSource source = new FileDataSource(this.attachment);
				MimeBodyPart messageBodyPart2 = new MimeBodyPart(); 
				messageBodyPart2.setDataHandler(new DataHandler(source));
				messageBodyPart2.setFileName(source.getName());
				multipart.addBodyPart(messageBodyPart2);
			}
			
			msg.setContent(multipart);
			
			transport.connect();
		    transport.sendMessage(msg, msg.getRecipients(Message.RecipientType.TO));
		    transport.close();
			return true;
		} catch (AddressException e) {
			e.printStackTrace();
		    throw new HelperException(e.getMessage());
		}  
		catch (Exception e) {  
			e.printStackTrace();
			throw new HelperException(e.getMessage());
		}
	}
	
	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	private class SMTPAuthenticator extends javax.mail.Authenticator {
		
		private String username;
		private String password;
		
		public SMTPAuthenticator(String username, String password) {
			this.username = username;
			this.password = password;
		}
		
        public PasswordAuthentication getPasswordAuthentication() {
           return new PasswordAuthentication(username, password);
        }
    }
}


