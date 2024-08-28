package com.example.demo.service;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.*;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.util.IterableStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
@Log4j2
@Service
@RequiredArgsConstructor
public class AzureOpenAIService {

    @Value("${azure.openai.api.key}")
    private String apiKey;

    @Value("${azure.openai.endpoint}")
    private String endpoint;

    @Value("${azure.openai.model.deployment.id}")
    private String deploymentName;

    @Value("${azure.openai.max.output.tokens}")
    private int maxOutputTokens;

    @Value("${azure.openai.temperature}")
    private double temperature;

    private OpenAIClient createClient() {
        return new OpenAIClientBuilder()
                .credential(new AzureKeyCredential(apiKey))
                .endpoint(endpoint)
                .buildClient();
    }

    public IterableStream<ChatCompletions> createChatCompletion(final List<ChatRequestMessage> messages) {
        ChatCompletionsOptions options = new ChatCompletionsOptions(messages)
                .setMaxTokens(maxOutputTokens)
                .setTemperature(temperature);
        return createClient().getChatCompletionsStream(deploymentName, options);
    }

    public String getResponse(final List<ChatRequestMessage> messages) {
        StringBuilder response = new StringBuilder();
        IterableStream<ChatCompletions> chatCompletionsStream = createChatCompletion(messages);
        for (ChatCompletions chatCompletions : chatCompletionsStream) {
            List<ChatChoice> choices = chatCompletions.getChoices();
            if (choices != null && !choices.isEmpty()) {
                String completionResult = choices.get(0).getDelta().getContent();
                if (completionResult != null && !completionResult.isEmpty()) {
                    response.append(completionResult);
                }
            } else {
                log.info("Waiting for choices....");
            }
        }

        return response.toString();
    }
}
