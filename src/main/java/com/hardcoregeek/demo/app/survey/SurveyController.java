package com.hardcoregeek.demo.app.survey;

import com.hardcoregeek.demo.entity.Survey;
import com.hardcoregeek.demo.service.SurveyService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
  private static final String SURVEY_LIST_KEY = "surveyList";
  private static final String SURVEY_LIST = "Survey List";
  private static final String SURVEY_FORM = "Survey Form";
  private static final String CONFIRM_FORM = "Confirm Form";
  private static final String FORM_PATH = "survey/form";
  private static final String CONFIRM_PATH = "survey/confirm";
  private static final String INDEX_PATH = "survey/index";

  private SurveyService surveyService;

  @Autowired
  public SurveyController(SurveyService surveyService) {
    this.surveyService = surveyService;

  }

  @GetMapping
  public String index(SurveyForm surveyform, Model model) {
    List<Survey> list = surveyService.getAll();
    model.addAttribute(SURVEY_LIST_KEY, list);
    model.addAttribute(TITLE_KEY, SURVEY_LIST);
    return INDEX_PATH;

  }

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

    Survey survey = new Survey();
    survey.setAge(surveyForm.getAge());
    survey.setSatisfaction(surveyForm.getSatisfaction());
    survey.setComments(surveyForm.getComments());
    survey.setCreated(LocalDateTime.now());
    this.surveyService.save(survey);

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