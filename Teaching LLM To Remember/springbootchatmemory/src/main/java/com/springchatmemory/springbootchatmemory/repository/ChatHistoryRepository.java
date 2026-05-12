package com.springchatmemory.springbootchatmemory.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import com.springchatmemory.springbootchatmemory.model.ChatHistory;

@Repository
public interface ChatHistoryRepository extends MongoRepository<String, ChatHistory>{

	List<ChatHistory> findTopNByConversationIdOrderByTimestampDesc(String conversationId, Pageable pageable);
    
    void deleteByConversationId(String conversationId);
    
    void save(ChatHistory chatHistory);
	
}
