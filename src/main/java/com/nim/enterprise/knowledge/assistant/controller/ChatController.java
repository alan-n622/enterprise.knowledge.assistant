package com.nim.enterprise.knowledge.assistant.controller;

import com.nim.enterprise.knowledge.assistant.dto.ChatRequest;
import com.nim.enterprise.knowledge.assistant.service.ChatService;
import org.jspecify.annotations.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }


    @PostMapping("/chat")
    public @Nullable String chat(@RequestBody ChatRequest message) throws IllegalAccessException {
        return chatService.ask(message);
    }
}