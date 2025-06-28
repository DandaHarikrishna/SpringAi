package com.hari.controller;

import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import reactor.core.publisher.Flux;

@org.springframework.web.bind.annotation.RestController
public class ChatController {
	@Autowired
	VertexAiGeminiChatModel chatModel;
    @CrossOrigin
	@GetMapping("/ai/generate")
	public Flux<String> generate(@RequestParam String prompt) {
		return this.chatModel.stream(prompt);
	}

}