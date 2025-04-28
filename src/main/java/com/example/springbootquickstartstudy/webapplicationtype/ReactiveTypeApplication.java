package com.example.springbootquickstartstudy.webapplicationtype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveTypeApplication {
    public static void main(String[] args) {
        // 스프링 WebFlux 기반 비동기/논블로킹 리액티브 웹 서버로 실행
        SpringApplication application = new SpringApplication(ReactiveTypeApplication.class);
        application.setWebApplicationType(WebApplicationType.REACTIVE);
        application.run(args);
    }
}
