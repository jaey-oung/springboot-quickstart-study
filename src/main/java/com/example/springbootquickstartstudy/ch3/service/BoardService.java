package com.example.springbootquickstartstudy.ch3.service;

import com.example.springbootquickstartstudy.ch1.domain.BoardVO;

import java.util.List;

// 게시판 관련 비즈니스 로직을 정의하는 서비스 인터페이스
public interface BoardService {
    // 이름을 받아 인사말 문자열을 반환
    String hello(String name);

    // 단일 게시글(BoardVO) 반환
    BoardVO getBoard();

    // 게시글 목록(BoardVO 리스트)을 반환
    List<BoardVO> getBoardList();
}
