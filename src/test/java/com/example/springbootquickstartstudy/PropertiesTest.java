package com.example.springbootquickstartstudy;

import com.example.springbootquickstartstudy.ch1.controller.BoardController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

// 테스트용 프로퍼티 값 주입 테스트 클래스
// BoardController를 빈으로 등록한 상태에서 프로퍼티 값을 주입하여 정상 주입 여부 검증
@SpringBootTest(classes = BoardController.class,
        properties = {
            "author.name=JY",
            "author.age=26",
            "author.nation=Korea"
})
public class PropertiesTest {
    // Environment를 통해 프로퍼티 값 주입
    @Autowired
    Environment environment;

    // 주입된 프로퍼티 값 출력
    @Test
    public void testMethod() {
        System.out.println("이름: " + environment.getProperty("author.name"));
        System.out.println("나이: " + environment.getProperty("author.age"));
        System.out.println("국가: " + environment.getProperty("author.nation"));
    }
}
