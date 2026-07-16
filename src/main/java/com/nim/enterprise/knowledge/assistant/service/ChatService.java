package com.nim.enterprise.knowledge.assistant.service;

import com.nim.enterprise.knowledge.assistant.configuration.AiPersonaProperties;
import com.nim.enterprise.knowledge.assistant.dto.ChatRequest;
import com.nim.enterprise.knowledge.assistant.dto.ChatResponse;
import com.nim.enterprise.knowledge.assistant.dto.Persona;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;
    private final AiPersonaProperties properties;

    public ChatService(ChatClient.Builder builder,
                       AiPersonaProperties properties) {
        this.chatClient = builder.build();
        this.properties = properties;
    }

    public ChatResponse ask(ChatRequest request) {
        Persona persona = request.persona() != null
                ? request.persona() : Persona.ARCHITECT;

        String systemPrompt = properties.personas().get(persona);

        return new ChatResponse(chatClient.prompt()
                .system(systemPrompt)
                .user(request.message())
                .call()
                .content());
    }
}
