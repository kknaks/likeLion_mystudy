package com.ll.restapi.domain.repository;

import com.ll.restapi.domain.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AticleRepository extends JpaRepository<Article, Long> {
}
