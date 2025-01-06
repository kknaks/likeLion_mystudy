package com.ll.restapi.domain.service;

import com.ll.restapi.domain.dto.ArticleDTO;
import com.ll.restapi.domain.dto.ArticleModifyRequest;
import com.ll.restapi.domain.entity.Article;

import com.ll.restapi.domain.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {

  private final ArticleRepository articleRepository;

  public List<ArticleDTO> getList() {
    List<Article> articleList = articleRepository.findAll();

    List<ArticleDTO> articleDTOList = articleList.stream()
        .map(article -> new ArticleDTO(article))
        .collect(Collectors.toList());

    return articleDTOList;
  }

  public Article getArticle(Long id) {
    Optional<Article> opArticle = articleRepository.findById(id);

    return opArticle.orElse(null);
  }

  public Article write(String subject, String content) {
    Article article = Article.builder()
        .subject(subject)
        .content(content)
        .build();
    return articleRepository.save(article);
  }

  public void modify(Long id, ArticleModifyRequest articleRequest) {
    Optional<Article> opArticle = articleRepository.findById(id);
  }

  public Article update(Article article, String subject, String content) {
    article.setSubject(subject);
    article.setContent(content);
    articleRepository.save(article);

    return article;
  }

  public void delete(Article article) {
    articleRepository.delete(article);
  }
}
