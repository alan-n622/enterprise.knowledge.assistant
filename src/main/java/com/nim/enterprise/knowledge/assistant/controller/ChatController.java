package com.nim.enterprise.knowledge.assistant.controller;

import com.nim.enterprise.knowledge.assistant.dto.ChatRequest;
import com.nim.enterprise.knowledge.assistant.dto.ChatResponse;
import com.nim.enterprise.knowledge.assistant.service.ChatService;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }


    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest message) {
        return chatService.ask(message);
    }
}