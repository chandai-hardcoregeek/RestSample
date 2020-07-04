package com.hardcoregeek.demo.service;

import com.hardcoregeek.demo.entity.Member;

import java.util.ArrayList;
import java.util.Arrays;

public class MemberServiceImpl implements MemberService {
    private static final MemberServiceImpl singleton = new MemberServiceImpl();

    private MemberServiceImpl(){}

    public static MemberServiceImpl getInstance() {
        return singleton;
    }
    @Override
    public String greet(int i) {
        String[] greetings = {"Good Morning", "Hello", "Good evening"};
        return greetings[i];
    }

    @Override
    public ArrayList<Member> getAll() {
        return new ArrayList<>(Arrays.asList(new Member(1, "Linda", "linda@example.com"),
                new Member(2, "James", "james@example.com")));
    }
}
