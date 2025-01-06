package com.ll.chatApp.domain.chat.chatMessage.controller;

import com.ll.chatApp.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.chatApp.domain.chat.chatMessage.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chat/rooms/{roomId}/messages")
public class ApiV1ChatMessageController {

  private final ChatMessageService chatMessageService;

  @GetMapping("")
  public String showMessage(
      @PathVariable("roomId") Long roomId,
      @RequestParam(value = "afterChatMessageId", defaultValue = "-1") long afterChatMessageId
  ){
    List<ChatMessage> cm = new ArrayList<>();

    chatMessageService.getList(roomId, afterChatMessageId);

    return String.format("%d번 채팅방 메시지 조회 완료 id : %d",roomId,afterChatMessageId);
  }

  @PostMapping("")
  public String sendMessage(
      @PathVariable("roomId") Long roomId
  ){
    return "채팅방 메시지 생성 완료";
  }
}
