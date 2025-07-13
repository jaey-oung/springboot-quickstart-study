package com.example.springbootquickstartstudy.ch6.service;

import com.example.springbootquickstartstudy.ch6.domain.Board;

import java.util.List;

/**
 * 게시판(Board) 도메인에 대한 서비스 인터페이스입니다.
 *
 * 게시글 등록, 조회, 수정, 삭제 등의 핵심 비즈니스 로직을 정의하며,
 * 실제 구현은 BoardServiceImpl 클래스에서 처리합니다.
 */
public interface BoardService {

    /**
     * 게시글 목록을 조회합니다.
     * @param board 검색 조건 등이 포함된 Board 객체 (현재는 미사용 가능성 높음)
     * @return 게시글 목록
     */
    List<Board> getBoardList(Board board);

    /**
     * 새 게시글을 등록합니다.
     * @param board 등록할 게시글 정보
     */
    void insertBoard(Board board);

    /**
     * 게시글 상세 정보를 조회합니다.
     * @param board 조회할 게시글의 식별 정보 (예: seq)
     * @return 게시글 상세 정보
     */
    Board getBoard(Board board);

    /**
     * 기존 게시글을 수정합니다.
     * @param board 수정할 게시글 정보
     */
    void updateBoard(Board board);

    /**
     * 게시글을 삭제합니다.
     * @param board 삭제할 게시글의 식별 정보
     */
    void deleteBoard(Board board);

}
