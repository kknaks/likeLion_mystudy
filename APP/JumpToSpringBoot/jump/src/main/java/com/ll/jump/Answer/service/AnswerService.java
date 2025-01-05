package com.ll.jump.Answer.service;

import com.ll.jump.Answer.entity.Answer;
import com.ll.jump.Answer.repository.AnswerRepository;
import com.ll.jump.DataNotFoundException;
import com.ll.jump.Question.entity.Question;
import com.ll.jump.user.entity.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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

  public Answer getAnswer(Integer id) {
    Optional<Answer> answer = this.answerRepository.findById(id);
    if (answer.isPresent()) {
      return answer.get();
    } else {
      throw new DataNotFoundException("answer not found");
    }
  }

  public void modify(Answer answer, String content) {
    answer.setContent(content);
    answer.setModifyDate(LocalDateTime.now());
    this.answerRepository.save(answer);
  }

  public void delete(Answer answer) {
    this.answerRepository.delete(answer);
  }

  public void vote(Answer answer, SiteUser siteUser) {
    answer.getVoter().add(siteUser);
    this.answerRepository.save(answer);
  }
}
