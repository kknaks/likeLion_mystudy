package com.ll.chatApp.domain.article.article.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

@Data
public class ArticleWriteRequest {
  @NotBlank
  private String title;

  @NotBlank
  private String content;
}
