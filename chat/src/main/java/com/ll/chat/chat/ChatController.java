package com.ll.chat.chat;

import com.ll.chat.ChatMessage;
import com.ll.chat.dto.MessagesRequest;
import com.ll.chat.dto.MessagesResponse;
import com.ll.chat.dto.WriteMessageRequest;
import com.ll.chat.dto.WriteMessageResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Controller
@RequestMapping("chat")
public class ChatController {
  private List<ChatMessage> chatMessages = new ArrayList<>();

  @PostMapping("/writeMessage")
  @ResponseBody
  public RsData<List<ChatMessage>> writeMessage(@RequestBody WriteMessageRequest writeMessageRequest){
    ChatMessage cm = new ChatMessage(writeMessageRequest.getAuthorName(), writeMessageRequest.getContent());
    chatMessages.add(cm);

    return new RsData("200", "메세지가 작성되었습니다.", new WriteMessageResponse(cm));
  }

  @GetMapping("/messages")
  @ResponseBody
  public RsData<List<ChatMessage>> messages(MessagesRequest messagesRequest){

    List<ChatMessage> messages = chatMessages;
    if(messagesRequest.fromId() != null){

    int index = IntStream.range(0,messages.size())
        .filter(i -> messagesRequest.fromId() == chatMessages.get(i).getId())
        .findFirst()
        .orElse(-1);


      if (index != -1){
        messages = messages.subList(index+1,messages.size());
      }
    }
    return new RsData("200","메세지가 작성되었습니다.",new MessagesResponse(messages, chatMessages.size()));
  }

  @GetMapping("/room")
  public String room(){
    return "chat/room";
  }
}
