package com.ll.jump.Question.repository;

import com.ll.jump.Answer.entity.Answer;
import com.ll.jump.Question.entity.Question;
import com.ll.jump.user.entity.SiteUser;
import jakarta.persistence.criteria.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
  Question findBySubject(String subject);
  Question findBySubjectAndContent(String subject, String content);
  List<Question> findBySubjectLike(String subject);
  Page<Question> findAll(Pageable pageable);
  Page<Question> findAll(Specification<Question> spec, Pageable pageable);
}
