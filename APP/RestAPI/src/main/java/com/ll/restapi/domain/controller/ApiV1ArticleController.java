package com.ll.restapi.domain.controller;

import com.ll.restapi.domain.dto.ArticleDTO;
import com.ll.restapi.domain.entity.Article;
import com.ll.restapi.domain.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ApiV1ArticleController {
  private final ArticleService articleService;

  @GetMapping("")
  public List<ArticleDTO> list(){
    List<ArticleDTO> articleList = new ArrayList<>();
    Article article1 = new Article("suject1", "content1");
    articleList.add(new ArticleDTO(article1));

    Article article2 = new Article("suject2", "content2");
    articleList.add(new ArticleDTO(article2));

    Article article3 = new Article("suject3", "content3");
    articleList.add(new ArticleDTO(article3));

    return articleList;
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
