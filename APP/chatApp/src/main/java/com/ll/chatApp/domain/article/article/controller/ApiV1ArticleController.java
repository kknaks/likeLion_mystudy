package com.ll.chatApp.domain.article.article.controller;

import com.ll.chatApp.domain.article.article.dto.ArticleDto;
import com.ll.chatApp.domain.article.article.dto.ArticleModifyRequest;
import com.ll.chatApp.domain.article.article.dto.ArticleWriteRequest;
import com.ll.chatApp.domain.article.article.entity.Article;
import com.ll.chatApp.domain.article.article.service.ArticleService;
import com.ll.chatApp.global.rsData.RsData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
@RequiredArgsConstructor
public class ApiV1ArticleController {
  private final ArticleService articleService;
  @GetMapping
  public List<ArticleDto> getArticles() {

    List<Article> articles =  articleService.findAll();

    List<ArticleDto> articleList = articles.stream()
        .map(ArticleDto::new)
        .toList();
    return articleList;
  }

  @GetMapping({"/{id}"})
  private ArticleDto getArticle(@PathVariable("id") Long id) {
    Article article = articleService.findById(id).orElseGet(null);
    return new ArticleDto(article);
  }

  @PostMapping
  public RsData<ArticleDto> writeArticle(@Valid @RequestBody ArticleWriteRequest articleWriteRequest) {
    Article article = articleService.write(articleWriteRequest.getTitle(), articleWriteRequest.getContent());
    return new RsData(
        "200",
        "게시글이 등록되었습니다.",
        new ArticleDto(article)
    );
  }

  @PatchMapping({"/{id}"})
  public RsData<ArticleDto> updateArticle(@PathVariable("id") Long id,@Valid @RequestBody
  ArticleModifyRequest articleModifyRequest) {
    Article article = articleService.findById(id).orElseGet(null);
    Article modifiedArticle =this.articleService.modify(article, articleModifyRequest.getTitle(), articleModifyRequest.getContent());

    return new RsData(
        "200",
        "게시글이 수정되었습니다.",
        new ArticleDto(modifiedArticle)
    );
  }

  @DeleteMapping({"/{id}"})
  public RsData<Void> deleteArticle(@PathVariable("id") Long id) {
    this.articleService.delete(id);

    return new RsData(
        "200",
        "게시글이 삭제되었습니다."
    );
  }
}
