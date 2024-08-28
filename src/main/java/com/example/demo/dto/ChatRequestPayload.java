package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ChatRequestPayload {
    private String systemMessage;
    private String userMessage;
}
