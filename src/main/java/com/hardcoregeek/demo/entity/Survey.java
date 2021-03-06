package com.hardcoregeek.demo.entity;

import java.time.LocalDateTime;

public class Survey {

  private int id;
  private int age;
  private int satisfaction;
  private String comments;
  private LocalDateTime created;

  public Survey() {
  }

  public Survey(int id, int age, int satisfaction, String comments, LocalDateTime created) {
    super();
    this.id = id;
    this.age = age;
    this.satisfaction = satisfaction;
    this.comments = comments;
    this.created = created;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getSatisfaction() {
    return satisfaction;
  }

  public void setSatisfaction(int satisfaction) {
    this.satisfaction = satisfaction;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(String comments) {
    this.comments = comments;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }


}
