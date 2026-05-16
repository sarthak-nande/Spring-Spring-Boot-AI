package com.ragimplementation.implementrag.controller;

import java.lang.annotation.Documented;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.ai.chat.memory.ChatMemory.CONVERSATION_ID;

@RestController
@RequestMapping("/api")
public class RagChatController {

	private final ChatClient chatClient;
	private final VectorStore vectorStore;
	
	@Autowired
	public RagChatController(ChatClient chatClient, VectorStore vectorStore) {
		this.chatClient = chatClient;
		this.vectorStore = vectorStore;
	}
	
	@Value("classpath:/promtTemplate/systemPromtTemplate.st")
	Resource systemPromtTemplate;
	
	@GetMapping("/chat")
	public String chat(@RequestParam String message, @RequestHeader String username) {
		SearchRequest searchRequest = SearchRequest.builder().query(message).topK(3).build();
		
		List<Document> similarDocs = vectorStore.similaritySearch(searchRequest);
		
		String similarContext = similarDocs.stream()
				.map(Document::getText)
				.collect(Collectors.joining(System.lineSeparator()));
		
		return chatClient
				.prompt()
				.system(systemSpec -> systemSpec.text(systemPromtTemplate).param("documents", similarContext))
				.advisors(t-> t.param(CONVERSATION_ID, username))
				.user(message)
				.call().content();
	}
	
}
