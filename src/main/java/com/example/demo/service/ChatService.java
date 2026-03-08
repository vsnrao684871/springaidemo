package com.example.demo.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatModel chatModel;

    // Spring will inject the ChatModel bean here
    public ChatService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String askAI0(String prompt) {
        ChatResponse response = chatModel.call(
            new Prompt(prompt,
                OpenAiChatOptions.builder()
                    .model("gpt-4o")
                    .maxTokens(150)
                    .build()
            )
        );

        System.out.println(response);
        return response.getResult().getOutput().getText();
    }
}
