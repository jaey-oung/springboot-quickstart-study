package com.example.springbootquickstartstudy.controller;

import com.example.springbootquickstartstudy.domain.BoardVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class BoardController {

    public BoardController() {
        System.out.println("===> BoardController 생성");
    }

    // [GET] /hello → "hello {name}" 문자열 반환
    // @RequestMapping(value = "/hello", method = RequestMethod.GET)과 동일한 단축 표현
    @GetMapping("/hello")
    public String hello(String name) {
        return "hello " + name;
    }

    // [GET] /getBoard → 단일 BoardVO 객체를 JSON으로 반환
    @GetMapping("/getBoard")
    public BoardVO getBoard() {
        BoardVO board = new BoardVO();
        board.setSeq(1);
        board.setTitle("테스트 제목...");
        board.setWriter("테스터");
        board.setContent("테스트 내용입니다...");
        board.setCreateDate(new Date());
        board.setCnt(0);
        return board;
    }

    // [GET] /getBoardList → BoardVO 객체 리스트를 JSON 배열로 반환
    @GetMapping("/getBoardList")
    public List<BoardVO> getBoardList() {
        List<BoardVO> boardList = new ArrayList<BoardVO>();

        for (int i = 1; i <= 10; i++) {
            BoardVO board = new BoardVO();
            board.setSeq(i);
            board.setTitle("제목" + i);
            board.setWriter("테스터");
            board.setContent(i + "번 내용입니다.");
            board.setCreateDate(new Date());
            board.setCnt(0);
            boardList.add(board);
        }
        return boardList;
    }

}
