package com.ll.chatApp.domain.chat.chatMessage.service;


import com.ll.chatApp.domain.chat.chatMessage.dto.ChatMessageRequest;
import com.ll.chatApp.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.chatApp.domain.chat.chatMessage.repository.ChatMessageRepository;
import com.ll.chatApp.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chatApp.domain.chat.chatRoom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
  private final ChatMessageRepository chatMessageRepository;

  public void create(ChatRoom chatRoom, String writerName, String content) {
    ChatMessage chatMessage = ChatMessage.builder()
        .chatRoom(chatRoom)
        .writerName(writerName)
        .content(content)
        .build();

    chatMessageRepository.save(chatMessage);
  }
}
