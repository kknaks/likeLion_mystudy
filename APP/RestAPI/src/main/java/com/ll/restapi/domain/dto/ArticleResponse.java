package com.ll.restapi.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ArticleResponse {
  private final ArticleDTO articleDTO;
}