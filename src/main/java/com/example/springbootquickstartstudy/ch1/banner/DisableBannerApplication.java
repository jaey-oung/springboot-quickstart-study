package com.example.springbootquickstartstudy.ch1.banner;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;

public class DisableBannerApplication {
    public static void main(String[] args) {
        // 배너를 출력하지 않고 실행
        SpringApplication application = new SpringApplication(DisableBannerApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
