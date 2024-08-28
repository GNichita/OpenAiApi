package com.example.demo.controllers;

import com.azure.ai.openai.models.ChatRequestMessage;
import com.azure.ai.openai.models.ChatRequestSystemMessage;
import com.azure.ai.openai.models.ChatRequestUserMessage;
import com.example.demo.dto.ChatRequestPayload;
import com.example.demo.service.AzureOpenAIService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
@Log4j2
public class ChatController {

    private final AzureOpenAIService azureOpenAIService;

    @PostMapping("/send")
    public String sendMessage(@RequestBody ChatRequestPayload payload) {
        List<ChatRequestMessage> messages = new ArrayList<>();
        messages.add(new ChatRequestSystemMessage(payload.getSystemMessage()));
        messages.add(new ChatRequestUserMessage(payload.getUserMessage()));

        log.info("Sending request to Azure OpenAI: SystemMessage='{}', UserMessage='{}'", payload.getSystemMessage(), payload.getUserMessage());

        String response = azureOpenAIService.getResponse(messages);

        log.info("Received response from Azure OpenAI: '{}'", response);

        return response;
    }
}