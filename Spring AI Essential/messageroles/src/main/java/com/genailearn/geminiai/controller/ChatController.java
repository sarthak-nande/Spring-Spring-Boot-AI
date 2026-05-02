package com.genailearn.geminiai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatController {
	
	private final ChatClient chatClient;
	
	public ChatController(ChatClient chatClient) {
		this.chatClient = chatClient;
	}
	
	@GetMapping("/chat")
	public String chat(@RequestParam("message") String message) {
		return chatClient.prompt().system("""
		        You are an empathetic, professional, and knowledgeable Human Resources (HR) Assistant. 
		        Your primary role is to assist employees with questions regarding company policies, benefits, payroll, leave management, and onboarding processes. 
		        Always maintain a polite, neutral, and supportive tone. 
		        Do not provide legal advice. If a query requires human intervention or involves sensitive employee relations, politely direct the employee to contact the HR department.
		        """).user(message).call().content();
	}

}
