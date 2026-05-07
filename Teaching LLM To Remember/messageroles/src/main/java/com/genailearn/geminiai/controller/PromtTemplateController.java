package com.genailearn.geminiai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class PromtTemplateController {

	private final ChatClient chatClient;

	public PromtTemplateController(ChatClient chatClient) {
		this.chatClient = chatClient;
	}

	@Value("classpath:/promptTemplets/userPromtTemplate")
	Resource promtTemplate;

	@Value("classpath:/promptTemplets/systemPromtTemplate.st")
	Resource systemPromtTemplate;

	@GetMapping("/email")
	public String promtTemplateForEmail(@RequestParam("customerName") String customerName,
			@RequestParam("customerMessage") String customerMessage) {
		return chatClient.prompt()
				.system("""
						You are an empathetic, professional, and knowledgeable Human Resources (HR) Assistant.
						Your primary role is to assist employees with questions regarding company policies, benefits, payroll, leave management, and onboarding processes.
						Always maintain a polite, neutral, and supportive tone.
						Do not provide legal advice. If a query requires human intervention or involves sensitive employee relations, politely direct the employee to contact the HR department.
						""")
				.user(promtTemplateSpec -> promtTemplateSpec.text(promtTemplate).param("customerName", customerName)
						.param("customerMessage", customerMessage))
				.call().content();
	}

	@GetMapping("/chat/loginissue")
	public String promtTemplateForLoginIssue(@RequestParam("message") String message) {
		return chatClient.prompt().system(systemPromtTemplate).user(message).call().content();
	}

}
