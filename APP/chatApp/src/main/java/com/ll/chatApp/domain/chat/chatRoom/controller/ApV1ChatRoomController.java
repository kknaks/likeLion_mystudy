package com.ll.chatApp.domain.chat.chatRoom.controller;

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


  @GetMapping("")
  public List<ChatRoom> list(){
    List<ChatRoom> chatRoomList = chatRoomService.getList();
    return chatRoomList;
  }

//  @GetMapping("")
//  public RsData list(){
//    List<ChatRoom> chatRoomList = chatRoomService.getList();
//    return RsData.of(
//        "S-1",
//        "채팅방 목록을 찾았습니다.",
//        chatRoomList
//    );
//  }

  @GetMapping("/{id}")
  public RsData getChatRoom(
      @PathVariable("id")Long id){
    ChatRoom chatRoom = chatRoomService.get(id);

    if (chatRoom == null) {
      return RsData.of(
          "F-1",
          "채팅방을 찾을 수 없습니다."
      );
    }

    return RsData.of(
        "S-2",
        "채팅방을 찾았습니다.",
        chatRoom
    );
  }

  @PostMapping("")
  public ChatRoom create(
      @RequestBody ChatRoom chatRoomDTO){
    ChatRoom chatRoom = chatRoomService.make(chatRoomDTO.getName());
    return chatRoom;
  }

//  @PostMapping("")
//  public RsData create(
//      @RequestBody ChatRoom chatRoom){
//    chatRoomService.make(chatRoom.getName());
//    return RsData.of(
//        "S-3",
//        "채팅방을 생성 했습니다."
//    );
//  }
}
