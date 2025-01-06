package com.ll.restapi.domain.controller;

import com.ll.restapi.domain.dto.*;
import com.ll.restapi.domain.entity.Article;
import com.ll.restapi.domain.repository.ArticleRepository;
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
    List<ArticleDTO> articleList = articleService.getList();

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

    Article article = articleService.getArticle(id);
    ArticleDTO articleDTO = new ArticleDTO(article);

    return RsData.of(
        "200",
        "게시글 조회 성공",
        new ArticleResponse(articleDTO)
    );
  }

  @PostMapping("")
  public RsData create(
      @Valid @RequestBody ArticleCreateRequest articleRequest){
    Article article = articleService.write(articleRequest.getSubject(), articleRequest.getContent());

    return RsData.of(
        "200",
        "게시글 등록",
        new ArticleResponse(new ArticleDTO(article))
    );
  }

  @PatchMapping("{id}")
  public RsData modify(
      @PathVariable("id") Long id,
      @RequestBody ArticleModifyRequest articleRequest
  ){
    Article article = articleService.getArticle(id);

    article = articleService.update(article, articleRequest.getSubject(), articleRequest.getContent());

    return RsData.of(
        "200",
        "게시글 변경 완료",
        new ArticleResponse(new ArticleDTO(article))
    );
  }

  @DeleteMapping("{id}")
  public RsData delete(
      @PathVariable("id") Long id
  ){
    Article article = articleService.getArticle(id);

    if (article == null){
      return RsData.of(
          "500",
          "없는 게시글입니다."
      );
    }

    articleService.delete(article);
    ArticleDTO articleDTO = new ArticleDTO(article);

    return new RsData(
        "200",
        "삭제완료",
        new ArticleResponse(articleDTO)
    );

  }
}
