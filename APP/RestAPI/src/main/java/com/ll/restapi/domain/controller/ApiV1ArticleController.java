package com.ll.restapi.domain.controller;

import com.ll.restapi.domain.dto.*;
import com.ll.restapi.domain.entity.Article;
import com.ll.restapi.domain.repository.ArticleRepository;
import com.ll.restapi.domain.service.ArticleService;
import com.ll.restapi.global.rsData.RsData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/articles", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "ApiV1ArticleController", description = "게시글 CRUD API")
public class ApiV1ArticleController {
  private final ArticleService articleService;

  @GetMapping("")
  @Operation(summary = "게시글 다건 조회")
  public RsData<ArticlesResponse> list(){
    List<ArticleDTO> articleList = articleService.getList();

    return RsData.of(
        "200",
        "게시글 목록 조회 성공",
        new ArticlesResponse(articleList)
    );
  }

  @GetMapping("/{id}")
  @Operation(summary = "게시글 단건 조회")
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
  @Operation(summary = "게시글 등록")
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
  @Operation(summary = "게시글 수정")
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
  @Operation(summary = "게시글 삭제")
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
