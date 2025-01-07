package com.ll.chatApp.domain.chat.chatMessage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChatMessageRequest {
  private String writerName;
  private String content;
}
