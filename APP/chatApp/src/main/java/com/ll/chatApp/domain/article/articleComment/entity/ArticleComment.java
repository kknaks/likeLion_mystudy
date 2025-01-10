package com.ll.chatApp.domain.article.articleComment.entity;

import com.ll.chatApp.domain.article.article.entity.Article;
import com.ll.chatApp.domain.member.member.entity.Member;
import com.ll.chatApp.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class ArticleComment extends BaseEntity {
  @ManyToOne(fetch = FetchType.LAZY)
  private Member author;

  private String body;

  @ManyToOne(fetch = FetchType.LAZY)
  private Article article;
}
