package com.nim.enterprise.knowledge.assistant.service;

import com.nim.enterprise.knowledge.assistant.dto.ChatAuditEvent;

public interface AuditEventPublisher {
    void publish(ChatAuditEvent event);
}
