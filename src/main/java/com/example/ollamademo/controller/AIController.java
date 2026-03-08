package com.example.ollamademo.controller;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaApi.ChatResponse;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AIController {
    
    private final ChatModel chatModel;
    
    public AIController(ChatModel chatModel) {
        this.chatModel = chatModel;
    }
    
    @GetMapping("/ask-ai")
    public String askAI(@RequestParam String prompt) {
        
        OllamaChatOptions options = OllamaChatOptions.builder()
                .temperature(0.4)
                .build();
        
        Prompt aiPrompt = new Prompt(prompt, options);
        org.springframework.ai.chat.model.ChatResponse response = chatModel.call(aiPrompt);
        
        return response.getResult().getOutput().getText();
    }
}