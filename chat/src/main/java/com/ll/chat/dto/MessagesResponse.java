package com.ll.chat.dto;


import com.ll.chat.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class MessagesResponse {
  private List<ChatMessage> chatMessages;
  private int totalCount;
}
