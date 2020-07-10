package com.hardcoregeek.demo.repository;

import java.util.List;

import com.hardcoregeek.demo.entity.Inquiry;

public interface InquiryDao {

  void insertInquiry(Inquiry inquiry);

  int updateInquiry(Inquiry inquiry);

  List<Inquiry> getAll();
}
