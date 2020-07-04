package com.hardcoregeek.demo;

import com.hardcoregeek.demo.entity.Member;
import com.hardcoregeek.demo.service.MemberServiceImpl;
import com.hardcoregeek.demo.service.UtilityServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        // TODO: 2020/07/04  Spring Used when introducing Spring
        //SpringApplication.run(DemoApplication.class, args);

        MemberServiceImpl service = new MemberServiceImpl();
        System.out.println(service.greet(0));

        ArrayList<Member> members = service.getAll();

        members.forEach(object -> System.out.println(object.getId() + ','
				+ object.getName() + ','
				+ object.getEmail())

		);

        UtilityServiceImpl utility = new UtilityServiceImpl();
        System.out.println(utility.sumOf(1,2));
    }
}
