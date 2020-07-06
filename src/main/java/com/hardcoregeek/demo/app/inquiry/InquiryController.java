package com.hardcoregeek.demo.app.inquiry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/inquiry")
public class InquiryController {

  private static final String TITLE_KEY = "title";
  private static final String INQUIRY_FORM = "Inquiry Form";
  private static final String CONFIRM_FORM = "Confirm Form";
  private static final String FORM_PATH = "inquiry/form";
  private static final String CONFIRM_PATH = "inquiry/confirm";

  @GetMapping("/form")
  public String form(InquiryForm inquiryForm, Model model) {
    model.addAttribute(TITLE_KEY, INQUIRY_FORM);
    return FORM_PATH;
  }

  @PostMapping("/form")
  public String formGoBack(InquiryForm inquiryForm, Model model) {
    model.addAttribute(TITLE_KEY, INQUIRY_FORM);
    return FORM_PATH;
  }


  @PostMapping("/confirm")
  public String confirm(@Validated InquiryForm inquiryForm,
      BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute(TITLE_KEY, INQUIRY_FORM);
      return FORM_PATH;
    }
    model.addAttribute(TITLE_KEY, CONFIRM_FORM);
    return CONFIRM_PATH;
  }

  @PostMapping("/complete")
  public String complete(/*Add parameters. */) {

    //hands-on

    //redirect

    return "";
  }

}