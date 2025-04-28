package com.example.springbootquickstartstudy.webapplicationtype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServletTypeApplication {
    public static void main(String[] args) {
        // 스프링 MVC 기반 웹 서버(Tomcat)로 실행
        SpringApplication application = new SpringApplication(ServletTypeApplication.class);
        application.setWebApplicationType(WebApplicationType.SERVLET);
        application.run(args);
    }
}
