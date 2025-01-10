package com.ll.chatApp.domain.article.tag.entity;

import com.ll.chatApp.domain.article.article.entity.Article;
import com.ll.chatApp.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class ArticleTag extends BaseEntity {
  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  private Article article;
}
