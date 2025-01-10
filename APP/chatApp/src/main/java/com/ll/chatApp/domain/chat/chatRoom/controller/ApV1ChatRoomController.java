package com.ll.chatApp.domain.chat.chatRoom.controller;

import com.ll.chatApp.domain.chat.chatRoom.dto.RequestCreateRoom;
import com.ll.chatApp.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chatApp.domain.chat.chatRoom.service.ChatRoomService;
import com.ll.chatApp.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chat/rooms")
@RequiredArgsConstructor
@CrossOrigin(
    origins = "https://cdpn.io"
)
public class ApV1ChatRoomController {

  private final ChatRoomService chatRoomService;

  @GetMapping("/api/v1/chat/rooms/{roomId}")
  public ChatRoom getChatRoom(@PathVariable("roomId") Long roomId) {
    ChatRoom chatRoom = chatRoomService.getChatRoom(roomId);
    return chatRoom;
  }

  @PostMapping
  public ChatRoom createChatRoom(@RequestBody RequestCreateRoom requestCreateRoom) {
    ChatRoom chatRoom = chatRoomService.create(requestCreateRoom.getName());
    return chatRoom;
  }
}
