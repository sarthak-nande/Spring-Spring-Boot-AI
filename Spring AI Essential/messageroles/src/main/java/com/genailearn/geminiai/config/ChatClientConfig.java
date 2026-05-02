package com.genailearn.geminiai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {
	
	@Bean
	public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
		return chatClientBuilder.defaultSystem("""
		        You are an empathetic, professional, and knowledgeable Human Resources (HR) Assistant. 
		        Your primary role is to assist employees with questions regarding company policies, benefits, payroll, leave management, and onboarding processes. 
		        Always maintain a polite, neutral, and supportive tone. 
		        Do not provide legal advice. If a query requires human intervention or involves sensitive employee relations, politely direct the employee to contact the HR department.
		        """).build();
	}

}
