package com.ll.jump.Answer.controller;

import com.ll.jump.Answer.dto.AnswerForm;
import com.ll.jump.Answer.entity.Answer;
import com.ll.jump.Answer.service.AnswerService;
import com.ll.jump.Question.entity.Question;
import com.ll.jump.Question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor

public class AnswerController {

  private final QuestionService questionService;
  private final AnswerService answerService;

  @PostMapping("/create/{id}")
  public String createAnser(
      Model model,
      @PathVariable("id") Integer id,
      @Valid AnswerForm answerForm,
      BindingResult bindingResult) {

    Question question = questionService.getQuestion(id);

    if(bindingResult.hasErrors()) {
      model.addAttribute("question", question);
      return "question_detail";
    }

    this.answerService.create(question, answerForm.getContent());

    return String.format("redirect:/question/detail/%d", id);
  }
}
