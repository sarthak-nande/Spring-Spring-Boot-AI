package com.springmcp.learnmcp.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

public class ChatHistoryModel {
	
	@Id
	String id;
	
	String coversationId;
	
	String content;
	
	String messageType;
	
	LocalDateTime timestamp;
	
	public ChatHistoryModel() {
		
	}

	public ChatHistoryModel(String coversationId, String content, String messageType, LocalDateTime timestamp) {
		super();
		this.coversationId = coversationId;
		this.content = content;
		this.messageType = messageType;
		this.timestamp = timestamp;
	}

	public String getCoversationId() {
		return coversationId;
	}

	public void setCoversationId(String coversationId) {
		this.coversationId = coversationId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
