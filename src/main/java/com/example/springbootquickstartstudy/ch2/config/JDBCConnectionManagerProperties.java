package com.example.springbootquickstartstudy.ch2.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

// application.yml 의 board.jdbc.* 값을 자동으로 바인딩하는 프로퍼티 클래스
@Getter
@Setter
@ConfigurationProperties("board.jdbc")
public class JDBCConnectionManagerProperties {
    private String driverClass;
    private String url;
    private String username;
    private String password;
}
