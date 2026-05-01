package com.genailearn.geminiai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultiModelChatConfig {
	
	@Bean("googleGeminiAiChatClient")
	public ChatClient googleGeminiAiChatClient(GoogleGenAiChatModel googleGenAiChatModel) {
		ChatClient.Builder chBuilder = ChatClient.builder(googleGenAiChatModel);
		return chBuilder.build();
	}
	
	@Bean("openAiChatClient")
	public ChatClient openAiChatClient(OpenAiChatModel openAiChatModel) {
		return ChatClient.builder(openAiChatModel).defaultSystem("You are using openAi chat model!").build();
	}

}
