package com.ll.chatApp.domain.article.tag.service;

import com.ll.chatApp.domain.article.tag.entity.ArticleTag;
import com.ll.chatApp.domain.article.tag.repository.ArticleTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleTagService {
  private final ArticleTagRepository articleTagRepository;


  public List<ArticleTag> findByAuthorId(long id) {
    return articleTagRepository.findByArticle_Author_Id(id);
  }

  public List<ArticleTag> findByAuthorUsername(String username) {
    return articleTagRepository.findByArticle_author_username(username);
  }
}
