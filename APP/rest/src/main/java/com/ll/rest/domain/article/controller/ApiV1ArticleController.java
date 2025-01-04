package com.ll.rest.domain.article.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/articles")
public class ApiV1ArticleController {
  @GetMapping
  public String getArticles() {
    return "게시글 다건";
  }

  @GetMapping("/{id}")
  public String getArticle() {
    return "게시글 단건";
  }

  @PostMapping
  public String postArticle() {
    return "게시글 등록";
  }

  @PatchMapping("/{id}")
  public String patchArticle() {
    return "게시글 수정";
  }

  @PutMapping("/{id}")
    public String putArticle() {
        return "게시글 수정";
    }

  @DeleteMapping("/{id}")
    public String deleteArticle() {
        return "게시글 삭제";
    }
}
