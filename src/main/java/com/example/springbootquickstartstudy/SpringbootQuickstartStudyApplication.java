package com.example.springbootquickstartstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// 애플리케이션의 시작점 클래스
// @SpringBootApplication은 내부에 @ComponentScan을 포함하여 지정한 패키지 이하의 클래스를 자동으로 스캔하고 빈으로 등록함
// ch3 패키지 사용 시 → @SpringBootApplication(scanBasePackages = "com.example.springbootquickstartstudy.ch3")
// ch5 패키지 사용 시
//@SpringBootApplication(scanBasePackages = "com.example.springbootquickstartstudy.ch5")
//public class SpringbootQuickstartStudyApplication {
//	public static void main(String[] args) {
//		// SpringApplication 객체 생성
//		SpringApplication application = new SpringApplication(SpringbootQuickstartStudyApplication.class);
//
//		// 웹 서버를 실행하지 않고 일반 자바 애플리케이션 모드로 설정
//		application.setWebApplicationType(WebApplicationType.NONE);
//
//		// 애플리케이션 실행
//		application.run(args);
//	}
//}

@SpringBootApplication(scanBasePackages = "com.example.springbootquickstartstudy.ch6")
@EntityScan("com.example.springbootquickstartstudy.ch6.domain")
@EnableJpaRepositories("com.example.springbootquickstartstudy.ch6.persistence")
public class SpringbootQuickstartStudyApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootQuickstartStudyApplication.class, args);
	}
}
