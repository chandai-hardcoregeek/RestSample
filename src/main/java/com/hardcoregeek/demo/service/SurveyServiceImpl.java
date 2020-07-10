package com.hardcoregeek.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hardcoregeek.demo.entity.Survey;
import com.hardcoregeek.demo.repository.SurveyDao;

@Service
public class SurveyServiceImpl implements SurveyService {

  private final SurveyDao dao;

  @Autowired
  SurveyServiceImpl(SurveyDao dao) {
    this.dao = dao;
  }

  @Override
  public void save(Survey survey) {
    this.dao.insertSurvey(survey);
  }

  @Override
  public List<Survey> getAll() throws InquiryNotFoundException {
    if (dao.getAll().isEmpty()) {
      throw new InquiryNotFoundException("SQL error");
    }
    return dao.getAll();
  }

}
