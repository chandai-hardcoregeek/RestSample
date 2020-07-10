package com.hardcoregeek.demo.repository;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.hardcoregeek.demo.entity.Inquiry;
import org.springframework.stereotype.Repository;


@Repository
public class InquiryDaoImpl implements InquiryDao {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public InquiryDaoImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public void insertInquiry(Inquiry inquiry) {
    jdbcTemplate.update("INSERT INTO inquiry(name, email, contents, created) VALUES(?, ?, ?, ?)",
        inquiry.getName(), inquiry.getEmail(), inquiry.getContents(), inquiry.getCreated());
  }

  @Override
  public int updateInquiry(Inquiry inquiry) {
    return jdbcTemplate.update("Update inquiry SET name = ?, email = ?, contents = ? Where id = ?",
        inquiry.getName(), inquiry.getEmail(), inquiry.getContents(), inquiry.getId());
  }

  @Override
  public List<Inquiry> getAll() {

    String sql = "Select id ,name, contents, created FROM inquiry";
    List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);

    List<Inquiry> list = new ArrayList<>();

    resultList.forEach(result -> {
      Inquiry inquiry = new Inquiry();
      inquiry.setId((int) result.get("id"));
      inquiry.setName((String) result.get("name"));
      inquiry.setEmail((String) result.get("email"));
      inquiry.setContents((String) result.get("contents"));
      inquiry.setCreated(((Timestamp) result.get("created")).toLocalDateTime());
      list.add(inquiry);
    });

    return list;
  }

}
