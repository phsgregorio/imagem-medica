package com.puc.commons.helpers;

import java.util.ArrayList;

import com.puc.commons.exceptions.HelperException;

public abstract class Email extends Thread {
	private MailHelper mail;
	private String smtpServerAddress = "smtp.gmail.com";
	private String username = "portalconsigplus@consigplusbr.com";
	private String password = "admville@@00";
	private String from = "portalconsigplus@consigplusbr.com";
	private ArrayList<String> to = new ArrayList<String>();
	private String attachment = "";
	
	public Email() {	
	}
	
	public void send() {
		this.start();
	}

	public ArrayList<String> getTo() {
		return to;
	}

	public void setTo(ArrayList<String> to) {
		this.to = to;
	}

	public void addTo(String email) {
		
		this.to.add(email);
	}
	public abstract String getSubject();

	public abstract String getMessageBody();

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Override
	public void run() {
		try {
			this.mail = new MailHelper(smtpServerAddress, username, password, from, to, getSubject(), getMessageBody(), attachment);
			this.mail.sendMail();
		} catch (HelperException e) {
			e.printStackTrace();
		}
	}
}
