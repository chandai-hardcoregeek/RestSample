package com.hardcoregeek.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hardcoregeek.demo.entity.Inquiry;
import com.hardcoregeek.demo.repository.InquiryDao;

@Service
public class InquiryServiceImpl implements InquiryService {

  private final InquiryDao dao;

  @Autowired
  public InquiryServiceImpl(InquiryDao dao) {
    this.dao = dao;
  }

  @Override
  public void save(Inquiry inquiry) {
    dao.insertInquiry(inquiry);
  }

  @Override
  public void update(Inquiry inquiry) {
    if (dao.updateInquiry(inquiry) == 0) {
      throw new InquiryNotFoundException("can't found the same ID");
    }

  }

  @Override
  public List<Inquiry> getAll() {
    return dao.getAll();

  }
}
