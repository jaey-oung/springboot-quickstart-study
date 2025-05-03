package com.example.springbootquickstartstudy;

import com.example.springbootquickstartstudy.ch3.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// 컨트롤러 - 서비스 계층 연동 테스트
// 서비스(BoardService)를 모킹하여 컨트롤러 동작만 검증
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class BoardControllerMockServiceTest {
    // MockMvc 주입
    @Autowired
    private MockMvc mockMvc;

    // BoardService를 모킹
    @MockitoBean
    private BoardService boardService;

    // [GET] /hello 요청 테스트
    @Test
    public void testHello() throws Exception {
        // 모킹된 BoardService의 hello 메서드 동작 지정
        when(boardService.hello("JY")).thenReturn("Hello JY");

        mockMvc.perform(get("/hello").param("name", "JY")) // GET 요청 및 파라미터 설정
                .andExpect(status().isOk()) // HTTP 상태 코드 검증 (200 OK)
                .andExpect(content().string("hello JY")) // 응답 본문 검증
                .andDo(print()); // 요청 및 응답 로그 출력
    }
}
