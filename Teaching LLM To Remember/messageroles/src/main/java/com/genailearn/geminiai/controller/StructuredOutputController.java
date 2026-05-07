package com.genailearn.geminiai.controller;

import java.util.List;
import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.ai.converter.MapOutputConverter;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.ai.ollama.api.OllamaModel;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.genailearn.geminiai.model.OutputResponseRecord;

@RestController
@RequestMapping("/api")
public class StructuredOutputController {

	private final ChatClient chatClient;

	public StructuredOutputController(ChatClient.Builder chatClient) {
		this.chatClient = chatClient.build();
	}

	@GetMapping("/cities")
	public ResponseEntity<OutputResponseRecord> listOfCities(@RequestParam String message) {
		OutputResponseRecord outputResponseRecord = chatClient.prompt()
				.options(OllamaChatOptions.builder().model(OllamaModel.LLAMA3).build()).user(message).call()
				.entity(OutputResponseRecord.class);
		return ResponseEntity.ok(outputResponseRecord);
	}

	@GetMapping("/cities-list")
	public ResponseEntity<List<String>> listOfCitiesList(@RequestParam String message) {
		List<String> countryList = chatClient.prompt()
				.options(OllamaChatOptions.builder().model(OllamaModel.LLAMA3).build()).user(message).call()
				.entity(new ListOutputConverter());
		return ResponseEntity.ok(countryList);
	}

	@GetMapping("/cities-map")
	public ResponseEntity<Map<String, Object>> listOfCitiesMap(@RequestParam String message) {
		Map<String, Object> countryList = chatClient.prompt()
				.options(OllamaChatOptions.builder().model(OllamaModel.LLAMA3).build()).user(message).call()
				.entity(new MapOutputConverter());
		return ResponseEntity.ok(countryList);
	}

	@GetMapping("/cities-parameterized")
	public ResponseEntity<List<OutputResponseRecord>> listOfCitiesParameterized(@RequestParam String message) {
		List<OutputResponseRecord> countryList = chatClient
				.prompt()
				.options(OllamaChatOptions.builder().model(OllamaModel.LLAMA3).build())
				.user(message)
				.call()
				.entity(new ParameterizedTypeReference<List<OutputResponseRecord>>() {
				});
		return ResponseEntity.ok(countryList);
	}
}
