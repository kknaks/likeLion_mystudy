package com.ll.jump.Question.repository;

import com.ll.jump.Question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
