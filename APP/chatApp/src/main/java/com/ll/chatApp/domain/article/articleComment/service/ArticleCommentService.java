package com.ll.chatApp.domain.article.articleComment.service;

import com.ll.chatApp.domain.article.article.repository.ArticleRepository;
import com.ll.chatApp.domain.article.articleComment.entity.ArticleComment;
import com.ll.chatApp.domain.article.articleComment.repository.ArticleCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleCommentService {
  private final ArticleRepository articleRepositry;
  private final ArticleCommentRepository articleCommentRepository;


  public List<ArticleComment> findByAuthorId(long id) {
    return articleCommentRepository.findByAuthorId(id);
  }
}
