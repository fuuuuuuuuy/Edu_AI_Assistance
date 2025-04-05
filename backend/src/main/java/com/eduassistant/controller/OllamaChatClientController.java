package com.eduassistant.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.ai.ollama.api.OllamaOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OllamaChatClientController {

    @Autowired
    private OllamaChatClient ollamaChatClient;

    @GetMapping("/ollama/chat/msg")
    public String sendollaMachat(@RequestParam String msg) {
        return ollamaChatClient.call(msg);
    }

    @GetMapping("/ollama/chat/prompt")
    public Object sendollaMachatV2(@RequestParam String msg) {
        Prompt prompt = new Prompt(msg);
        return ollamaChatClient.call(prompt);
    }

    @GetMapping("/ollama/chat/model")
    public Object sendollaMachatV3(@RequestParam String msg) {
        Prompt prompt = new Prompt(
                msg,
                OllamaOptions.create()
                        .withModel("qwen2:1.5b")
                        .withTemperature(0.4F));
        ChatResponse chatResponse = ollamaChatClient.call(prompt);
        return chatResponse.getResult().getOutput().getContent();
    }
}