package com.hardcoregeek.demo.repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hardcoregeek.demo.entity.Survey;

@Repository
public class SurveyDaoImpl implements SurveyDao {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public SurveyDaoImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void insertSurvey(Survey survey) {
    jdbcTemplate
        .update("INSERT INTO survey(age, satisfaction, comments, created) VALUES(?, ?, ?, ?)",
            survey.getAge(), survey.getSatisfaction(), survey.getComments(), survey.getCreated());

  }

  @Override
  public List<Survey> getAll() {
    List<Survey> list = new ArrayList<>();
    String sql = "Select id, age, satisfaction, comments, created From Survey";

    List<Map<String, Object>> results = jdbcTemplate.queryForList(sql);
    results.forEach(result -> {
      Survey survey = new Survey();
      survey.setId((int) result.get("id"));
      survey.setAge((int) result.get("age"));
      survey.setSatisfaction((int) result.get("satisfaction"));
      survey.setComments((String) result.get("comments"));
      survey.setCreated(((Timestamp) result.get("created")).toLocalDateTime());
      list.add(survey);
    });
    return list;
  }


}
