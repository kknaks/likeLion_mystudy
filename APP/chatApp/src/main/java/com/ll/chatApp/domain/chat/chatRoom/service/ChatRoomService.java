package com.ll.chatApp.domain.chat.chatRoom.service;

import com.ll.chatApp.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chatApp.domain.chat.chatRoom.repository.ChatRoomRepository;
import com.ll.chatApp.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
  private final ChatRoomRepository chatRoomRepository;

  public ChatRoom create(String name) {
    ChatRoom chatRoom = ChatRoom.builder()
        .name(name)
        .build();

    chatRoomRepository.save(chatRoom);

    return chatRoom;
  }

  public  List<ChatRoom>  getAll() {
    return chatRoomRepository.findAll();
  }
  public ChatRoom getChatRoom(Long roomId) {
    return chatRoomRepository.findById(roomId).get();
  }
}
