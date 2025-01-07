package com.ll.chatApp.global.initData;

import com.ll.chatApp.domain.chat.chatMessage.dto.ChatMessageRequest;
import com.ll.chatApp.domain.chat.chatMessage.service.ChatMessageService;
import com.ll.chatApp.domain.chat.chatRoom.entity.ChatRoom;
import com.ll.chatApp.domain.chat.chatRoom.service.ChatRoomService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.stream.IntStream;

@Configuration
@Profile("!prod")
public class NotProd {

  @Bean
  public ApplicationRunner initNotProd(ChatRoomService chatRoomService,
      ChatMessageService chatMessageService){
    return args -> {
      ChatRoom chatRoom1 = chatRoomService.make("공부");
      ChatRoom chatRoom2 = chatRoomService.make("음식");
      ChatRoom chatRoom3 = chatRoomService.make("여가");

      IntStream.rangeClosed(1,100).forEach(num->{
        ChatMessageRequest chatMessageRequest = new ChatMessageRequest("kknaks","message"+num);
        chatMessageService.save(chatRoom1.getId(),chatMessageRequest);
      });
    };
  }
}
