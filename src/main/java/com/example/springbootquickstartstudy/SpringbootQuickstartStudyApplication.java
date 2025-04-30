package com.example.springbootquickstartstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// @SpringBootApplication은 내부에 @ComponentScan 포함
@SpringBootApplication
// 명시적으로 빈 검색 범위 확장 (다른 패키지의 컴포넌트 수동 등록)
@ComponentScan(basePackages = {
		"com.example.springbootquickstartstudy", // 현재 프로젝트 기본 패키지
		"com.example.other"                      // 외부 컨트롤러 포함 패키지
})
public class SpringbootQuickstartStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootQuickstartStudyApplication.class, args);
	}

}
