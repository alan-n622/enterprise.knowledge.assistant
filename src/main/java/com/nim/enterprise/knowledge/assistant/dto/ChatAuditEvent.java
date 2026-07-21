package com.nim.enterprise.knowledge.assistant.dto;


public record ChatAuditEvent(
        String persona,
        String model,
        String prompt,
        String request,
        String response
) {

}
