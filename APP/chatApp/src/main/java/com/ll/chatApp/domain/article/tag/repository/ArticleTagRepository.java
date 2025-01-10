package com.ll.chatApp.domain.article.tag.repository;

import com.ll.chatApp.domain.article.tag.entity.ArticleTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleTagRepository extends JpaRepository<ArticleTag, Long> {
  List<ArticleTag> findByArticle_Author_Id(long id);

  List<ArticleTag> findByArticle_author_username(String username);
}
