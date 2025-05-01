package com.example.springbootquickstartstudy.ch2.config;

import com.example.springbootquickstartstudy.ch2.util.JDBCConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// JDBCConnectionManager Bean 등록용 설정 클래스
@Configuration
// board.jdbc 프로퍼티를 외부 설정에서 가져와 사용 가능하도록 활성화
@EnableConfigurationProperties(JDBCConnectionManagerProperties.class)
public class BoardAutoConfiguration {
    @Autowired
    private JDBCConnectionManagerProperties properties;

    // application.yml 에 정의된 board.jdbc 프로퍼티 값을 주입받아 빈을 생성
    @Bean
    public JDBCConnectionManager getJDBCConnectionManager() {
        JDBCConnectionManager manager = new JDBCConnectionManager();
        manager.setDriverClass(properties.getDriverClass());
        manager.setUrl(properties.getUrl());
        manager.setUsername(properties.getUsername());
        manager.setPassword(properties.getPassword());
        return manager;
    }
}
