package com.nim.enterprise.knowledge.assistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class EnterpriseKnowledgeAssistantApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnterpriseKnowledgeAssistantApplication.class, args);
	}

}
