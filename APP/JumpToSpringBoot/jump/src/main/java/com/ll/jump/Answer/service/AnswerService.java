package com.ll.jump.Answer.service;

import com.ll.jump.Answer.entity.Answer;
import com.ll.jump.Answer.repository.AnswerRepository;
import com.ll.jump.Question.entity.Question;
import com.ll.jump.user.entity.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnswerService {

  private final AnswerRepository answerRepository;

  public Answer create(Question question, String content, SiteUser author) {
    Answer answer = new Answer();
    answer.setContent(content);
    answer.setQuestion(question);
    answer.setCreateDate(LocalDateTime.now());
    answer.setAuthor(author);

    answerRepository.save(answer);
    return answer;

  }
}
