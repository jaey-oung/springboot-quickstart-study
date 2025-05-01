package com.example.springbootquickstartstudy.ch1.webapplicationtype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NoneTypeApplication {
    public static void main(String[] args) {
        // 웹 서버 없이 일반 자바 프로그램처럼 실행
        SpringApplication application = new SpringApplication(NoneTypeApplication.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }
}
