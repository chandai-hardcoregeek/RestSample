package com.hardcoregeek.demo.service;

import java.util.List;

import com.hardcoregeek.demo.entity.Inquiry;

public interface InquiryService {

  void save(Inquiry inquiry);

  void update(Inquiry inquiry);

  List<Inquiry> getAll();

}
