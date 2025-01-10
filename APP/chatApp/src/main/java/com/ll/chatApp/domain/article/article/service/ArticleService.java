package com.ll.chatApp.domain.article.article.service;

import com.ll.chatApp.domain.article.article.dto.ArticleModifyRequest;
import com.ll.chatApp.domain.article.articleComment.entity.ArticleComment;
import com.ll.chatApp.domain.article.articleComment.repository.ArticleCommentRepository;
import com.ll.chatApp.domain.article.article.entity.Article;
import com.ll.chatApp.domain.article.article.repository.ArticleRepository;
import com.ll.chatApp.domain.member.member.entity.Member;
import com.ll.chatApp.global.rsData.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {

  private final ArticleRepository articleRepository;
  private final ArticleCommentRepository articleCommentRepository;

  @Transactional
  public Article write(String title, String content) {
    Article article = Article.builder()
        .author(Member.builder().id(1L).build())
        .title(title)
        .content(content)
        .build();


    return articleRepository.save(article);
  }

  public Optional<Article> findById(long id) {
    return articleRepository.findById(id);
  }

  @Transactional
  public Article modify(Article article, String title, String content) {
    article.setTitle(title);
    article.setContent(content);

    return articleRepository.save(article);
  }

  @Transactional
  public void modifyComment(ArticleComment comment, String body) {
    comment.setBody(body);
  }

  public List<Article> findAll() {
    return articleRepository.findAll();
  }

  @Transactional
  public void delete(Long id) {
    this.articleRepository.deleteById(id);
  }
}
