package com.ll.jump;

import com.ll.jump.entity.Question;
import com.ll.jump.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class SbbApplicationTests {

  @Autowired
  private QuestionRepository questionRepository;

  @Test
  void testJpa() {
    Question q1 = new Question();
    q1.setSubject("What is your name?");
    q1.setContent("My name is John.");
    q1.setCreateDate(LocalDateTime.now());
    this.questionRepository.save(q1);
  }
}
