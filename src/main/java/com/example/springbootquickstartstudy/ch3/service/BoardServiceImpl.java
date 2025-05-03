package com.example.springbootquickstartstudy.ch3.service;

import com.example.springbootquickstartstudy.ch1.domain.BoardVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// BoardService 인터페이스를 구현한 서비스 구현체
@Service
public class BoardServiceImpl implements BoardService {
    // 이름을 받아 인사말 문자열을 반환
    @Override
    public String hello(String name) {
        return "hello " + name;
    }

    // 단일 게시글(BoardVO)을 생성하여 반환
    @Override
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

    // 게시글 목록(BoardVO 리스트)을 생성하여 반환
    @Override
    public List<BoardVO> getBoardList() {
        List<BoardVO> boardList = new ArrayList<>();
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
