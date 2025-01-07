package com.ll.chatApp.domain.chat.chatMessage.controller;

import com.ll.chatApp.domain.chat.chatMessage.dto.ChatMessageRequest;
import com.ll.chatApp.domain.chat.chatMessage.dto.ChatMessageResponse;
import com.ll.chatApp.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.chatApp.domain.chat.chatMessage.service.ChatMessageService;
import com.ll.chatApp.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chatApp.domain.chat.chatRoom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/chat/rooms/{roomId}/messages")
@CrossOrigin(
    origins = "https://cdpn.io"
)
public class ApiV1ChatMessageController {

  private final ChatMessageService chatMessageService;
  private final ChatRoomRepository chatRoomRepository;

//  @GetMapping("")
//  public List<ChatMessageResponse> showMessages(
//      @PathVariable("roomId") Long roomId,
//      @RequestParam(value = "afterChatMessageId", defaultValue = "-1") long afterChatMessageId
//  ) {
//    return chatMessageService.getList(roomId, afterChatMessageId).stream()
//        .map(ChatMessageResponse::new)
//        .collect(Collectors.toList());
//  }

  @GetMapping("")
  public List<ChatMessageResponse> showMessages(
      @PathVariable("roomId") Long roomId,
      @RequestParam(value = "afterChatMessageId", defaultValue = "-1") long afterChatMessageId
  ) {

    ChatRoom chatRoom = chatRoomRepository.findById(roomId)
        .orElseThrow();

    return chatRoom.getChatMessageList().stream()
        .map(ChatMessageResponse::new)
        .collect(Collectors.toList());
  }

  @PostMapping("")
  public String sendMessage(
      @PathVariable("roomId") Long roomId,
      @RequestBody ChatMessageRequest chatMessageRequest
  ){
    chatMessageService.save(roomId, chatMessageRequest);
    return "채팅방 메시지 생성 완료";
  }
}
