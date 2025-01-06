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

  private final ChatRoomRepository charRoomRepository;

  public ChatRoom make(String name) {
    ChatRoom chatRoom = ChatRoom.builder()
            .name(name)
            . build();

    charRoomRepository.save(chatRoom);
    return chatRoom;
  }

  public List<ChatRoom> getList() {
    return charRoomRepository.findAll();
  }

  public ChatRoom get(Long id) {
    Optional<ChatRoom> chatRoom = charRoomRepository.findById(id);

    if (chatRoom.isPresent()){
      return chatRoom.get();
    }
    return null;
  }
}
