package com.ll.mutiChat.domain.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WriteMessageRequest {
  private Long chatRoomId;
  private String writerName;
  private String content;
}
