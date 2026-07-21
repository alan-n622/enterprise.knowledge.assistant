package com.nim.enterprise.knowledge.assistant.service;

import com.nim.enterprise.knowledge.assistant.configuration.AiPersonaProperties;
import com.nim.enterprise.knowledge.assistant.dto.ChatAuditEvent;
import com.nim.enterprise.knowledge.assistant.dto.ChatRequest;
import com.nim.enterprise.knowledge.assistant.dto.Persona;
import org.jspecify.annotations.Nullable;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class ChatService {

    private final ChatClient chatClient;
    private final AiPersonaProperties properties;
    private final LoggingAuditEventPublisher logger;

    @Value("${spring.ai.ollama.chat.options.model}")
    private String aiModel;

    public ChatService(ChatClient.Builder builder,
                       AiPersonaProperties properties, LoggingAuditEventPublisher logger) {
        this.chatClient = builder.build();
        this.properties = properties;
        this.logger = logger;
    }

    public @Nullable String ask(ChatRequest request) throws IllegalAccessException {
        Persona persona = request.persona() != null
                ? request.persona() : Persona.ARCHITECT;

        String systemPrompt = resolveSystemPrompt(persona);


        String response = ExecutionTimer.measure(
                "AI Chat",
                () -> chatClient
                        .prompt(systemPrompt)
                        .call()
                        .content());


        if (response==null) response="No response";
        final String finalResponse=response;

        ExecutionTimer.measure(
                "audit-publish",
                () -> logger.publish(
                        new ChatAuditEvent(persona.name(), aiModel, systemPrompt, request.message(),
                                finalResponse.length() > 10 ? finalResponse.substring(0, 10) : finalResponse)
                )
        );



        return response;
    }

    private String resolveSystemPrompt(Persona persona) throws IllegalAccessException {
        String systemPrompt = properties.personas().get(persona);
        if (systemPrompt==null || systemPrompt.isBlank()) {
            throw new IllegalAccessException("No system prompt configured for persona"+persona);
        }
        return systemPrompt;
    }
}
