package com.example.springbootquickstartstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication은 내부에 @ComponentScan 포함
// ch3 패키지 및 하위 패키지만 스캔하여 해당 클래스들만 빈으로 등록
@SpringBootApplication(scanBasePackages = "com.example.springbootquickstartstudy.ch3")
public class SpringbootQuickstartStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootQuickstartStudyApplication.class, args);
	}

}
