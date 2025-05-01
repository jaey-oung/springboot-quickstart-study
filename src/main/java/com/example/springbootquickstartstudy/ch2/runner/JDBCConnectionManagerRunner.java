package com.example.springbootquickstartstudy.ch2.runner;

import com.example.springbootquickstartstudy.ch2.util.JDBCConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

// 애플리케이션 시작 시 JDBCConnectionManager 정보를 출력하는 ApplicationRunner 구현 클래스
@Service
public class JDBCConnectionManagerRunner implements ApplicationRunner {
    @Autowired
    private JDBCConnectionManager connectionManager;

    // 애플리케이션 실행 완료 후 자동으로 실행되는 메서드
    // 현재 설정된 데이터베이스 연결 정보를 콘솔에 출력
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("커넥션 매니저: " + connectionManager.toString());
    }
}
