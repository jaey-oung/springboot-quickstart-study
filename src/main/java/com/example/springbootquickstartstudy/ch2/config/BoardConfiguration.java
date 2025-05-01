package com.example.springbootquickstartstudy.ch2.config;

import com.example.springbootquickstartstudy.ch2.util.JDBCConnectionManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// JDBCConnectionManager 빈이 없을 경우 기본 데이터베이스(H2)를 사용하기 위한 설정 클래스
@Configuration
public class BoardConfiguration {
    // H2 데이터베이스를 사용하여 JDBCConnectionManager 빈을 등록 (application.yml 에 정의된 board.jdbc 설정이 없는 경우)
    @Bean
    @ConditionalOnMissingBean
    public JDBCConnectionManager getJDBCConnectionManager() {
        JDBCConnectionManager manager = new JDBCConnectionManager();
        manager.setDriverClass("org.h2.Driver");
        manager.setUrl("jdbc:h2:tcp:@localhost/~/test");
        manager.setUsername("JY");
        manager.setPassword("4001");
        return manager;
    }
}
