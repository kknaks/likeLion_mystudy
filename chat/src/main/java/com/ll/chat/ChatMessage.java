package com.ll.chat;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ChatMessage {
  private long id;
  private String authorName;
  private String content;
  private LocalDateTime createDate;

  public ChatMessage(String authorName, String content) {
    this.id = ChatMessageIdGenerator.generateId();
    this.createDate = LocalDateTime.now();
    this.authorName = authorName;
    this.content = content;
  }

  static class ChatMessageIdGenerator {
    private static long id = 0;
    public static long generateId() {
      return ++id;
    }
  }

}
