package com.hardcoregeek.demo.app.inquiry;

import com.hardcoregeek.demo.entity.Inquiry;
import com.hardcoregeek.demo.service.InquiryNotFoundException;
import com.hardcoregeek.demo.service.InquiryService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/inquiry")
public class InquiryController {

  private static final String TITLE_KEY = "title";
  private static final String INQUIRY_LIST_KEY = "inquiryList";
  private static final String INQUIRY_FORM = "Inquiry Form";
  private static final String CONFIRM_FORM = "Confirm Form";
  private static final String INQUIRY_INDEX = "Inquiry Index";
  private static final String FORM_PATH = "inquiry/form";
  private static final String CONFIRM_PATH = "inquiry/confirm";
  private static final String INDEX_PATH = "inquiry/index";
  private final InquiryService inquiryService;

  @Autowired
  public InquiryController(InquiryService inquiryService) {
    this.inquiryService = inquiryService;

  }

  @GetMapping
  public String index(Model model) {
    List<Inquiry> list = inquiryService.getAll();
    model.addAttribute(INQUIRY_LIST_KEY, list);
    model.addAttribute(TITLE_KEY, INQUIRY_INDEX);
    return INDEX_PATH;
  }

  @GetMapping("/form")
  public String form(InquiryForm inquiryForm, Model model,
      @ModelAttribute("complete") String complete) {
    return this.toForm(model);

  }

  @PostMapping("/form")
  public String formGoBack(InquiryForm inquiryForm, Model model) {
    return this.toForm(model);
  }


  @PostMapping("/confirm")
  public String confirm(@Validated InquiryForm inquiryForm, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return this.toForm(model);
    }
    return this.toConfirm(model);
  }

  @PostMapping("/complete")
  public String complete(@Validated InquiryForm inquiryForm, BindingResult result, Model model,
      RedirectAttributes redirectAttributes) {
    if (result.hasErrors()) {
      return this.toForm(model);
    }

    // save inquiry form data
    Inquiry inquiry = new Inquiry();
    inquiry.setName(inquiryForm.getName());
    inquiry.setEmail(inquiryForm.getEmail());
    inquiry.setContents(inquiryForm.getContents());
    inquiry.setCreated(LocalDateTime.now());
    this.inquiryService.save(inquiry);

    redirectAttributes.addFlashAttribute("complete", "Registered");
    return "redirect:/inquiry/form";
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