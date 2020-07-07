package com.hardcoregeek.demo.app.survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/survey")
public class SurveyController {

  private static final String TITLE_KEY = "title";
  private static final String SURVEY_FORM = "Survey Form";
  private static final String CONFIRM_FORM = "Confirm Form";
  private static final String FORM_PATH = "survey/form";
  private static final String CONFIRM_PATH = "survey/confirm";


  @GetMapping("/form")
  public String form(SurveyForm surveyForm, Model model) {
    return this.toForm(model);
  }

  @PostMapping("/form")
  public String formGoBack(SurveyForm surveyForm, Model model) {
    return this.toForm(model);
  }


  @PostMapping("/confirm")
  public String confirm(@Validated SurveyForm surveyForm, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return this.toForm(model);
    }
    return this.toConfirm(model);
  }

  @PostMapping("/complete")
  public String complete(@Validated SurveyForm surveyForm, BindingResult result, Model model,
      RedirectAttributes redirectAttributes) {
    if (result.hasErrors()) {
      return this.toForm(model);
    }

    redirectAttributes.addFlashAttribute("complete", "Complete Survey");
    return "redirect:/survey/form";
  }

  private String toForm(Model model) {
    model.addAttribute(TITLE_KEY, SURVEY_FORM);
    return FORM_PATH;
  }

  private String toConfirm(Model model) {
    model.addAttribute(TITLE_KEY, CONFIRM_FORM);
    return CONFIRM_PATH;
  }
}