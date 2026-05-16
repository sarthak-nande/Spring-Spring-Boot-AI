package com.springchatmemory.springbootchatmemory.config;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.springchatmemory.springbootchatmemory.model.ChatHistory;
import com.springchatmemory.springbootchatmemory.repository.ChatHistoryRepository;

@Service
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
					message.getText(),
					message.getMessageType().name(),
					LocalDateTime.now()
			);
			
			chatHistoryRepository.save(chatHistory);
		}
		
	}

	@Override
	public List<Message> get(String conversationId) {
		return chatHistoryRepository
				.findTopNByConversationIdOrderByTimestampDesc(conversationId, PageRequest.of(0, 10))
				.stream()
				.map(doc -> "USER".equals(doc.getMessageType()) 
						? new UserMessage(doc.getContent())
						: new SystemMessage(doc.getContent()))
				.collect(Collectors.toList());
	}

	@Override
	public void clear(String conversationId) {
	     chatHistoryRepository.deleteByConversationId(conversationId);
		
	}

}
