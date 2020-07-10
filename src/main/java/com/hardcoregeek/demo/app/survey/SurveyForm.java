package com.hardcoregeek.demo.app.survey;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SurveyForm {

  @Min(value = 0, message = "Please input a value greater than 0")
  @Max(value = 150, message = "Please input a value less than 150")
  @NotNull
  private int age;

  @Min(value = 1, message = "Please input a value greater than 1")
  @Max(value = 5, message = "Please input a value less than 5")
  @NotNull
  private int satisfaction;

  @Size(min = 1, max = 200, message = "Please input 200 characters or less")
  @NotNull
  private String comments;

  public int getAge() {
    return this.age;
  }

  public int getSatisfaction() {
    return this.satisfaction;
  }

  public String getComments() {
    return this.comments;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setSatisfaction(int satisfaction) {
    this.satisfaction = satisfaction;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }
}
