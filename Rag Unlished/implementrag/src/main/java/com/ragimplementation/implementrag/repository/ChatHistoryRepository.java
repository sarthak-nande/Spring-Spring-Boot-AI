package com.ragimplementation.implementrag.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ragimplementation.implementrag.model.ChatHistoryModel;

@Repository
public interface ChatHistoryRepository extends MongoRepository<ChatHistoryModel, String>{

	List<ChatHistoryModel> findTopNByConversationIdOrderByTimestampDesc(String coversationId, Pageable pageable);
	
	void deleteByConversationId(String conversationId);
}
