package com.genailearn.geminiai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.client.util.Value;

@RestController
@RequestMapping("/api")
public class PromtTemplateController {

	private final ChatClient chatClient;

	public PromtTemplateController(ChatClient chatClient) {
		this.chatClient = chatClient;
	}

	@Value("classpath:/promptTemplets/userPromtTemplate")
	Resource promtTemplate;

	@GetMapping("/email")
	public String promtTemplateForEmail(@RequestParam("customerName") String customerName,
			@RequestParam("customerMessage") String customerMessage) {
		return chatClient
				.prompt().system(promtTemplate).user(promtTemplateSpec -> promtTemplateSpec
						.param("customerName", customerName)
						.param("customerMessage", customerMessage))
				.call().content();
	}

}
