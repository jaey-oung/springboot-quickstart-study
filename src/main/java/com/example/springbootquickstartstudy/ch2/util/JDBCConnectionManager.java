package com.example.springbootquickstartstudy.ch2.util;

import lombok.Setter;
import lombok.ToString;

import java.sql.Connection;
import java.sql.DriverManager;

// JDBC 연결을 관리하는 유틸리티 클래스
@Setter
@ToString
public class JDBCConnectionManager {
    // 데이터베이스 접속 정보
    private String driverClass;
    private String url;
    private String username;
    private String password;

    // 데이터베이스 커넥션 반환 메서드
    public Connection getConnection() {
        try {
            Class.forName(driverClass);
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            // 예외 발생 시 스택 트레이스를 출력하고 null 반환
            e.printStackTrace();
        }
        return null;
    }
}
