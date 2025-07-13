package com.example.springbootquickstartstudy.ch6.service;

import com.example.springbootquickstartstudy.ch6.domain.Board;
import com.example.springbootquickstartstudy.ch6.persistence.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 게시판(Board) 도메인에 대한 서비스 구현 클래스입니다.
 *
 * BoardService 인터페이스를 구현하며,
 * BoardRepository를 통해 실제 데이터베이스와의 연동 및 비즈니스 로직을 수행합니다.
 */
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    /**
     * 게시글 전체 목록을 조회합니다.
     * 현재는 검색 조건 없이 전체 리스트를 반환합니다.
     *
     * @param board 검색 조건용 객체 (현재 미사용)
     * @return 게시글 목록
     */
    @Override
    public List<Board> getBoardList(Board board) {
        return (List<Board>) boardRepository.findAll();
    }

    /**
     * 새 게시글을 저장합니다.
     *
     * @param board 저장할 게시글 정보
     */
    @Override
    public void insertBoard(Board board) {
        // TODO: 게시글 등록 로직 구현 필요
    }

    /**
     * 게시글 상세 정보를 조회합니다.
     *
     * @param board 조회할 게시글 식별 정보 포함 객체
     * @return 게시글 상세 정보
     */
    @Override
    public Board getBoard(Board board) {
        // TODO: 게시글 단건 조회 로직 구현 필요
        return null;
    }

    /**
     * 기존 게시글을 수정합니다.
     *
     * @param board 수정할 게시글 정보
     */
    @Override
    public void updateBoard(Board board) {
        // TODO: 게시글 수정 로직 구현 필요
    }

    /**
     * 게시글을 삭제합니다.
     *
     * @param board 삭제할 게시글 식별 정보 포함 객체
     */
    @Override
    public void deleteBoard(Board board) {
        // TODO: 게시글 삭제 로직 구현 필요
    }

}
