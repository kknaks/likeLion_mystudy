package com.ll.chatApp.domain.chat.chatRoom.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ll.chatApp.domain.chat.chatMessage.entity.ChatMessage;
import com.ll.chatApp.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@ToString(callSuper = true)
public class ChatRoom  extends BaseEntity {
  private String name;

  public ChatRoom () {
  }

  public ChatRoom(String name) {
    this.name = name;
  }

  @JsonIgnore
  @OneToMany(mappedBy = "chatRoom")
  private List<ChatMessage> chatMessageList;
}
