//package com.example.springbootquickstartstudy;
//
//import com.example.springbootquickstartstudy.ch1.domain.BoardVO;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//
//import java.util.Objects;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//// MockMvc를 이용한 컨트롤러 통합 테스트
//// 테스트 방식
//// 1) @WebMvcTest - 컨트롤러 계층만 테스트
//// 2) @SpringBootTest + @AutoConfigureMockMvc - 전체 애플리케이션 통합 테스트
//
//// @WebMvcTest
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
//public class BoardControllerRestTemplateTest {
//    // TestRestTemplate 주입
//    @Autowired
//    private TestRestTemplate testRestTemplate;
//
//    // [GET] /hello 요청 테스트
//    @Test
//    public void testHello() throws Exception {
//        String result = testRestTemplate.getForObject("/hello?name=JY", String.class); // GET 요청 및 파라미터 설정
//        assertEquals("hello JY", result); // 응답 본문 검증
//    }
//
//    // [GET] /getBoard 요청 테스트
//    @Test
//    public void testGetBoard() throws Exception {
//        BoardVO board = testRestTemplate.getForObject("/getBoard", BoardVO.class); // GET 요청
//        assertEquals("테스터", Objects.requireNonNull(board).getWriter()); // 응답 본문 검증
//    }
//}
