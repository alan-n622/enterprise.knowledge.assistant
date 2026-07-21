//package com.nim.enterprise.knowledge.assistant.service;
//
//import com.nim.enterprise.knowledge.assistant.dto.ChatAuditEvent;
//import org.springframework.kafka.core.KafkaTemplate;
//
//public class KafkaAuditEventPublisher implements AuditEventPublisher{
//
//
//    private final KafkaTemplate<String, ChatAuditEvent> kafkaTemplate;
//
//    public KafkaAuditEventPublisher (
//            KafkaTemplate<String, ChatAuditEvent> kafkaTemplate
//    ) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//    @Override
//    public void publish(ChatAuditEvent event) {
//        kafkaTemplate.send("chat-audit-events", event.requestId(), event);
//    }
//}
