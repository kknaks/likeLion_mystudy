package com.ll.aichatbot;


import lombok.RequiredArgsConstructor;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/v1/chat")
@RestController
public class ChatController {

  private final OpenAiChatModel openAiChatModel;

  public ChatController(OpenAiChatModel openAiChatModel){
    this.openAiChatModel = openAiChatModel;
  }

  @GetMapping
  public Map<String, String>  chate(@RequestBody String message){
    Map<String, String> response = new HashMap<>();

    String openAiResponse = openAiChatModel.call(message);
    response.put("AI response: ", openAiResponse);
    return response;
  }
}
