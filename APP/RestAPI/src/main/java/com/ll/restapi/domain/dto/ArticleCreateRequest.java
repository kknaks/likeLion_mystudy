package com.ll.restapi.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ArticleCreateRequest {
  @NotBlank
  private String subject;

  @NotBlank
  private String content;
}
