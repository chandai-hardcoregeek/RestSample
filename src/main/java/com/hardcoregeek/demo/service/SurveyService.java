package com.hardcoregeek.demo.service;

import java.util.List;
import com.hardcoregeek.demo.app.survey.SurveyForm;
import com.hardcoregeek.demo.entity.Survey;

public interface SurveyService {

    void save(Survey survey);

    List<Survey> getAll();

}
