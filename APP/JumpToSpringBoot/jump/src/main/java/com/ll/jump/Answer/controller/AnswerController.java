package com.ll.jump.Answer.controller;

import com.ll.jump.Answer.dto.AnswerForm;
import com.ll.jump.Answer.entity.Answer;
import com.ll.jump.Answer.service.AnswerService;
import com.ll.jump.Question.entity.Question;
import com.ll.jump.Question.service.QuestionService;
import com.ll.jump.user.entity.SiteUser;
import com.ll.jump.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor

public class AnswerController {

  private final QuestionService questionService;
  private final AnswerService answerService;
  private final UserService userService;

  @PreAuthorize("isAuthenticated()")
  @PostMapping("/create/{id}")
  public String createAnswer(
      Model model,
      @PathVariable("id") Integer id,
      @Valid AnswerForm answerForm,
      BindingResult bindingResult,
      Principal principal) {

    Question question = questionService.getQuestion(id);
    SiteUser siteUser = userService.getUser(principal.getName());

    if(bindingResult.hasErrors()) {
      model.addAttribute("question", question);
      return "question_detail";
    }

    this.answerService.create(question, answerForm.getContent(), siteUser);

    return String.format("redirect:/question/detail/%d", id);
  }
}
