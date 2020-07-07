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
    return this.toForm(model);

  }

  @PostMapping("/form")
  public String formGoBack(InquiryForm inquiryForm, Model model) {
    return this.toForm(model);
  }


  @PostMapping("/confirm")
  public String confirm(@Validated InquiryForm inquiryForm,
      BindingResult result, Model model) {
    if (result.hasErrors()) {
      this.toForm(model);
    }
    return this.toConfirm(model);
  }

  @PostMapping("/complete")
  public String complete(/*Add parameters. */) {

    //hands-on

    //redirect

    return "";
  }

  /**
   * to Inquiry form html file path.
   *
   * @param model Model
   * @return inquiry/form :String
   */
  private String toForm(Model model) {
    model.addAttribute(TITLE_KEY, INQUIRY_FORM);
    return FORM_PATH;
  }

  /**
   * to Confirm form html file path.
   *
   * @param model Model
   * @return inquiry/confirm :String
   */
  private String toConfirm(Model model) {
    model.addAttribute(TITLE_KEY, CONFIRM_FORM);
    return CONFIRM_PATH;
  }

}