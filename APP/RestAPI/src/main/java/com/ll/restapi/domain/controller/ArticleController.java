package com.ll.restapi.domain.controller;

import com.ll.restapi.domain.dto.ArticleDTO;
import com.ll.restapi.domain.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vi/articles")
@RequiredArgsConstructor
public class ArticleController {
  private final ArticleService articleService;

  @GetMapping("")
  public String list(){
    return "목록";
  }

  @PostMapping("/{id}")
  public String getArticle(
      @PathVariable("id") Long id
  ){
    return "단건조회";
  }

  @PostMapping("")
  public String create(ArticleDTO articleDTO){
    return "게시글 등록";
  }

  @PatchMapping("{id}")
  public String modify(){
    return "게시글 수정";
  }

  @DeleteMapping("{id}")
  public String delete(){
    return "게시글 삭제";
  }
}
