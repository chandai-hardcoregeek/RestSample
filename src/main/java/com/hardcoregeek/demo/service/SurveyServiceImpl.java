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
        //hands-on
    }

    @Override
    public List<Survey> getAll() {
        if (dao.getAll().isEmpty()) {
            throw new InquiryNotFoundException("SQL error");
        }
        return dao.getAll();
    }

}
