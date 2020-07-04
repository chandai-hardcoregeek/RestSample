package com.hardcoregeek.demo.service;

import com.hardcoregeek.demo.entity.Member;

import java.util.ArrayList;

public interface MemberService {
    String greet(int i);
    ArrayList<Member> getAll();
}