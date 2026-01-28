package com.back.global.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AiConfig {

    @Bean
    @Profile("default") // 기본 프로필에서는 OpenAI 사용
    public ChatClient openaiChatClient(ChatModel openAiChatModel) {
        return ChatClient.builder(openAiChatModel)
                .build();
    }

    @Bean
    @Profile("test")    // 테스트 프로필에서는 Ollama 사용 (API 비용 절감)
    public ChatClient ollamaChatClient(ChatModel ollamaChatModel) {
        return ChatClient.builder(ollamaChatModel)
                .build();
    }
}
