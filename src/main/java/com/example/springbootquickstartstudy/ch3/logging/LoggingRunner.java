package com.example.springbootquickstartstudy.ch3.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

// 애플리케이션 구동 시 로깅 동작을 테스트하는 클래스
@Service
public class LoggingRunner implements ApplicationRunner {
    // SLF4J Logger 인스턴스 생성
    private final Logger logger = LoggerFactory.getLogger(LoggingRunner.class);

    // 애플리케이션 실행 직후 호출되는 메서드
    // 각 로그 레벨별로 로그를 출력하여 로깅 설정과 파일 기록 동작을 확인
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.trace("TRACE 로그 메시지");
        logger.debug("DEBUG 로그 메시지");
        logger.info("INFO 로그 메시지");
        logger.warn("WARN 로그 메시지");
        logger.error("ERROR 로그 메시지");
    }
}
