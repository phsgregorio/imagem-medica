package com.puc.commons.message;


public class Message {
	private String text;
	private TypeMessage type;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public TypeMessage getType() {
		return type;
	}

	public void setType(TypeMessage type) {
		this.type = type;
	}

	public Message(String text, TypeMessage type) {
		super();
		this.text = text;
		this.type = type;
	}
}
