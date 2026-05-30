package com.springmcp.learnmcp.config;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.springmcp.learnmcp.model.ChatHistoryModel;
import com.springmcp.learnmcp.repository.ChatHistoryRepository;

@Service
public class ChatMemoeryConfig implements ChatMemory{
	
	private final ChatHistoryRepository chatHistoryRepository;
	
	public ChatMemoeryConfig(ChatHistoryRepository chatHistoryRepository) {
		this.chatHistoryRepository = chatHistoryRepository;
	}
	

	@Override
	public void add(String conversationId, List<Message> messages) {
		for(Message message : messages) {
			ChatHistoryModel chat = new ChatHistoryModel(
					conversationId,
					message.getText(),
					message.getMessageType().name(),
					LocalDateTime.now()
					);
			
			chatHistoryRepository.save(chat);
		}
	}

	@Override
	public List<Message> get(String conversationId) {
		
		return chatHistoryRepository.findTopNByConversationIdOrderByTimestampAsc(conversationId, PageRequest.of(0, 10))
				.stream()
				.map(doc -> "USER".equals(doc.getMessageType())
							? new UserMessage(doc.getContent())
							: new AssistantMessage(doc.getContent()))
				.collect(Collectors.toList())
				;
	}

	@Override
	public void clear(String conversationId) {
		chatHistoryRepository.deleteByConversationId(conversationId);
	}

}
