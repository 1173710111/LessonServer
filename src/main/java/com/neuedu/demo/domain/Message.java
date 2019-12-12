package com.neuedu.demo.domain;

public class Message {
	public Message(String sender) {
		super();
		this.sender = sender;
	}
	
	protected String sender;
	protected String content;
	
	public String getSender() {
		return sender;
	}
	public String getContent() {
		return content;
	}
	
}
