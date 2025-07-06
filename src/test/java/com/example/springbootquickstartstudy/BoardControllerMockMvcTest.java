//package com.example.springbootquickstartstudy;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//// MockMvc를 이용한 컨트롤러 통합 테스트
//// 테스트 방식
//// 1) @WebMvcTest - 컨트롤러 계층만 테스트
//// 2) @SpringBootTest + @AutoConfigureMockMvc - 전체 애플리케이션 통합 테스트
//
//@WebMvcTest
//// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//// @AutoConfigureMockMvc
//public class BoardControllerMockMvcTest {
//    // MockMvc 주입
//    @Autowired
//    private MockMvc mockMvc;
//
//    // [GET] /hello 요청 테스트
//    @Test
//    public void testHello() throws Exception {
//        mockMvc.perform(get("/hello").param("name", "JY")) // GET 요청 및 파라미터 설정
//                .andExpect(status().isOk()) // HTTP 상태 코드 검증 (200 OK)
//                .andExpect(content().string("hello JY")) // 응답 본문 검증
//                .andDo(print()); // 요청 및 응답 로그 출력
//    }
//}
