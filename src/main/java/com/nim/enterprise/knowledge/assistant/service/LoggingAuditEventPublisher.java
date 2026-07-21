package com.nim.enterprise.knowledge.assistant.service;

import com.nim.enterprise.knowledge.assistant.dto.ChatAuditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingAuditEventPublisher implements AuditEventPublisher{

    private static final Logger log = LoggerFactory.getLogger(LoggingAuditEventPublisher.class);

    @Override
    public void publish(ChatAuditEvent event) {
        log.info("Audit Event: {}", event);
    }
}
