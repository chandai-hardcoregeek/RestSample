package com.hardcoregeek.demo.app.survey;

public class SurveyForm {

  /*Add parameters(0~150) 引数を追加(0~150)*/
  private int age;

  /*Add parameters(1~5) 引数を追加(1~5)*/
  private int satisfaction;

  /*Add parameters(200 characters or less) 引数を追加(200文字以内)*/
  private String comment;

  public SurveyForm() {
  }

  public SurveyForm(int age, int satisfaction, String comment) {
    this.age = age;
    this.satisfaction = satisfaction;
    this.comment = comment;
  }

  public int getAge() {
    return this.age;
  }

  public int getSatisfaction() {
    return this.satisfaction;
  }

  public String getComment() {
    return this.comment;
  }

}
