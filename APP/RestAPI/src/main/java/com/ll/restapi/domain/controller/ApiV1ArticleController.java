package com.ll.restapi.domain.controller;

import com.ll.restapi.domain.dto.*;
import com.ll.restapi.domain.entity.Article;
import com.ll.restapi.domain.service.ArticleService;
import com.ll.restapi.global.rsData.RsData;
import jakarta.validation.Valid;
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
  public RsData<ArticlesResponse> list(){
    List<ArticleDTO> articleList = new ArrayList<>();
    Article article1 = new Article("suject1", "content1");
    articleList.add(new ArticleDTO(article1));

    Article article2 = new Article("suject2", "content2");
    articleList.add(new ArticleDTO(article2));

    Article article3 = new Article("suject3", "content3");
    articleList.add(new ArticleDTO(article3));

    return RsData.of(
        "200",
        "게시글 목록 조회 성공",
        new ArticlesResponse(articleList)
    );
  }

  @GetMapping("/{id}")
  public RsData<ArticleResponse> getArticle(
      @PathVariable("id") Long id
  ){

    ArticleDTO articleDTO = new ArticleDTO(new Article("suject4", "content4"));

    return RsData.of(
        "200",
        "게시글 조회 성공",
        new ArticleResponse(articleDTO)
    );
  }

  @PostMapping("")
  public String create(
      @Valid @RequestBody ArticleCreateRequest articleRequest){
    System.out.println(articleRequest.getSubject());
    System.out.println(articleRequest.getContent());
    return "게시글 등록";
  }

  @PatchMapping("{id}")
  public String modify(
      @PathVariable("id") Long id,
      @RequestBody ArticleModifyRequest articleRequest
  ){
    System.out.println(id);
    System.out.println(articleRequest.getSubject());
    System.out.println(articleRequest.getContent());
    return String.format("%d번 %s: %s 게시글 수정",id,articleRequest.getSubject(),articleRequest.getContent());
  }

  @DeleteMapping("{id}")
  public String delete(
      @PathVariable("id") Long id
  ){
    System.out.println(id);
    return String.format("%d번 게시글 삭제",id);
  }
}
