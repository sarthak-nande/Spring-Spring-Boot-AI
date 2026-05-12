package com.springchatmemory.springbootchatmemory.config;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.springchatmemory.springbootchatmemory.model.ChatHistory;
import com.springchatmemory.springbootchatmemory.repository.ChatHistoryRepository;

@Configuration
public class ChatMemoryConfig implements ChatMemory{
	
	private final ChatHistoryRepository chatHistoryRepository;
	
	@Autowired
	public ChatMemoryConfig(ChatHistoryRepository chatHistoryRepository) {
		this.chatHistoryRepository = chatHistoryRepository;
	}

	@Override
	public void add(String conversationId, List<Message> messages) {
		for(Message message: messages) {
			ChatHistory chatHistory = new ChatHistory(
					conversationId,
					message.getMessageType().name(),
					message.getText(),
					LocalDateTime.now()
			);
			
			chatHistoryRepository.save(chatHistory);
		}
		
	}

	@Override
	public List<Message> get(String conversationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear(String conversationId) {
		// TODO Auto-generated method stub
		
	}

}
