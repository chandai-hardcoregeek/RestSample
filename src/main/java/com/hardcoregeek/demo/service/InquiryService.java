package com.hardcoregeek.demo.service;

import java.util.List;

import com.hardcoregeek.demo.app.inquiry.InquiryForm;
import com.hardcoregeek.demo.entity.Inquiry;

public interface InquiryService {

    void save(Inquiry inquiry);

//  This is used in the latter chapter
//  こちらは後で使用
//	void update(Inquiry inquiry);

    List<Inquiry> getAll();

}
