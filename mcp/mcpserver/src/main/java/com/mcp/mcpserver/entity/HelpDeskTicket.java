package com.mcp.mcpserver.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "helpdeskticket")
public class HelpDeskTicket {
	
	@Id
	private String id;
	
	private String username;
	
	private String issue;
	
	private String status;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime eta;
	
	public HelpDeskTicket() {
		
	}

	public HelpDeskTicket(String username, String issue, String status, LocalDateTime createdAt, LocalDateTime eta) {
		super();
		this.username = username;
		this.issue = issue;
		this.status = status;
		this.createdAt = createdAt;
		this.eta = eta;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getEta() {
		return eta;
	}

	public void setEta(LocalDateTime eta) {
		this.eta = eta;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
