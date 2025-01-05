package com.ll.jump.Question.controller;

import com.ll.jump.Answer.dto.AnswerForm;
import com.ll.jump.Question.dto.QuestionForm;
import com.ll.jump.Question.entity.Question;
import com.ll.jump.Question.repository.QuestionRepository;
import com.ll.jump.Question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
  private final QuestionService questionService;

  @GetMapping("/list")
  public String list(Model model) {
    List<Question> questionList = questionService.findAll();
    model.addAttribute("questionList", questionList);
    return "question_list";
  }

  @GetMapping("/detail/{id}")
  public String detail(
      Model model,
      @PathVariable("id") Integer id,
      AnswerForm answerForm) {
    Question question = this.questionService.getQuestion(id);
    model.addAttribute("question", question);
    return "question_detail";
  }

  @GetMapping("/create")
  public String questionCreate(QuestionForm questionForm) {
    return "question_form";
  }

  @PostMapping("/create")
  public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "question_form";
    }
    this.questionService.create(questionForm.getSubject(), questionForm.getContent());
    return "redirect:/question/list";
  }
}
