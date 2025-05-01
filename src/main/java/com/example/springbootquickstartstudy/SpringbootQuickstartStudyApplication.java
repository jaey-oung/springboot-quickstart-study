package com.example.springbootquickstartstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// @SpringBootApplication은 내부에 @ComponentScan 포함
@SpringBootApplication
public class SpringbootQuickstartStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootQuickstartStudyApplication.class, args);
	}

}
