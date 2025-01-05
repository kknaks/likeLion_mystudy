package com.ll.jump.repository;

import com.ll.jump.entity.Answer;
import com.ll.jump.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
