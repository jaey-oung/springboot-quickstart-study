package com.example.springbootquickstartstudy.ch6.controller;

import com.example.springbootquickstartstudy.ch6.domain.Board;
import com.example.springbootquickstartstudy.ch6.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 게시판(Board) 관련 요청을 처리하는 Spring MVC 컨트롤러입니다.
 *
 * 클라이언트로부터의 요청을 받아 Service를 통해 비즈니스 로직을 처리하고,
 * 결과 데이터를 View에 전달합니다.
 */
@Controller
public class BoardController {

    // 게시글 관련 비즈니스 로직을 처리하는 서비스 객체
    @Autowired
    private BoardService boardService;

    /**
     * 게시글 목록 페이지를 요청받아 처리합니다.
     *
     * @param model View에 데이터를 전달하기 위한 객체
     * @param board 요청 시 전달된 검색 조건 또는 기본 파라미터 (현재는 사용되지 않을 수 있음)
     * @return 뷰 이름(getBoardList.jsp 또는 getBoardList.html 등)
     */
    @RequestMapping("/getBoardList")
    public String getBoardList(Model model, Board board) {
        List<Board> boardList = boardService.getBoardList(board); // 게시글 목록 조회

        model.addAttribute("boardList", boardList); // 모델에 데이터 등록
        return "getBoardList"; // View 이름 반환
    }

}
