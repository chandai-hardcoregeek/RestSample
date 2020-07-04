package com.hardcoregeek.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.hardcoregeek.demo.entity.Inquiry;
import com.hardcoregeek.demo.entity.Survey;

@Repository
public interface SurveyDao {

    void insertSurvey(Survey survey);

    List<Survey> getAll();

}