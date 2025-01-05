package com.ll.jump.Answer.entity;

import com.ll.jump.Question.entity.Question;
import com.ll.jump.user.entity.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
public class Answer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(columnDefinition = "TEXT")
  private String content;

  private LocalDateTime createDate;

  @ManyToOne
  private Question question;

  @ManyToOne
  private SiteUser author;

  private LocalDateTime modifyDate;

  @ManyToMany
  Set<SiteUser> voter;
}
