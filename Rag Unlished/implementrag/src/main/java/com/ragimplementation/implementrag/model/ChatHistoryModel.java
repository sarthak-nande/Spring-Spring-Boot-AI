package com.ragimplementation.implementrag.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ChatHistory")
public class ChatHistoryModel {

	@Id
	String id;
	
	String conversationId;
	
	String content;
	
	String messageType;
	
	LocalDateTime timestamp;

	public ChatHistoryModel(String conversationId, String content, String messageType, LocalDateTime timestamp) {
		super();
		this.conversationId = conversationId;
		this.content = content;
		this.messageType = messageType;
		this.timestamp = timestamp;
	}
	
	public ChatHistoryModel() {
		
	}

	public String getConversationId() {
		return conversationId;
	}

	public void setConversationId(String conversationId) {
		this.conversationId = conversationId;
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
