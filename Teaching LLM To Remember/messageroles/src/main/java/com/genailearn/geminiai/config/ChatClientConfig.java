package com.genailearn.geminiai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.genailearn.geminiai.adviosrs.TokenUsageAuditAdvioser;

@Configuration
public class ChatClientConfig {

	@Bean
	@Primary
	public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
		
		//You Can Also Use To Handel Chat Options
		//ChatOptions chatOptions = ChatOptions.builder().model("").maxTokens(100).temperature(45.0).build();
		
		return chatClientBuilder
				.defaultOptions(OllamaChatOptions.builder().model("llama3").build())
				.defaultAdvisors(new TokenUsageAuditAdvioser())
				.defaultSystem(
						"""
								You are an empathetic, professional, and knowledgeable Human Resources (HR) Assistant.
								Your primary role is to assist employees with questions regarding company policies, benefits, payroll, leave management, and onboarding processes.
								Always maintain a polite, neutral, and supportive tone.
								Do not provide legal advice. If a query requires human intervention or involves sensitive employee relations, politely direct the employee to contact the HR department.
								""")
				.build();
	}

}
