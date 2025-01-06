package com.ll.chatApp.domain.chat.chatMessage.service;


import com.ll.chatApp.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.chatApp.domain.chat.chatMessage.repository.ChatMessageRepository;
import com.ll.chatApp.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chatApp.domain.chat.chatRoom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

  private final ChatMessageRepository chatMessageRepository;
  private final ChatRoomRepository chatRoomRepository;

  public void write(ChatRoom chatRoom, String witerName, String content) {
    ChatMessage chatMessage = ChatMessage.builder()
        .chatRoom(chatRoom)
        .writerName(witerName)
        .content(content)
        .build();

    chatMessageRepository.save(chatMessage);
  }

  public void getList(Long roomId, long afterChatMessageId) {

  }
}
