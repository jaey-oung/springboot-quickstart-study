package com.example.springbootquickstartstudy.ch3.controller;

import com.example.springbootquickstartstudy.ch1.domain.BoardVO;
import com.example.springbootquickstartstudy.ch3.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoardController {
    // BoardSevice 주입
    @Autowired
    private BoardService boardService;

    // [GET] /hello → 서비스의 hello 메서드를 호출
    @GetMapping("/hello")
    public String hello(String name) {
        return boardService.hello(name);
    }

    // [GET] /getBoard → 서비스의 getBoard 메서드를 호출
    @GetMapping("/getBoard")
    public BoardVO getBoard() {
        return boardService.getBoard();
    }

    // [GET] /getBoardList → 서비스의 getBoardList 메서드를 호출
    @GetMapping("/getBoardList")
    public List<BoardVO> getBoardList() {
        return boardService.getBoardList();
    }
}
