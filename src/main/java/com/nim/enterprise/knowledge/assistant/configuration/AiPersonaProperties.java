package com.nim.enterprise.knowledge.assistant.configuration;

import com.nim.enterprise.knowledge.assistant.dto.Persona;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties(prefix = "app.ai")
public record AiPersonaProperties(
        Map<Persona, String> personas
) {

}
