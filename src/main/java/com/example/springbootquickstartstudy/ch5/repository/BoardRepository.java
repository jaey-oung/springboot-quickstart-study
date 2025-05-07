package com.example.springbootquickstartstudy.ch5.repository;

import com.example.springbootquickstartstudy.ch5.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// Board 엔티티를 위한 리포지토리 인터페이스
// CrudRepository 상속으로 기본 CRUD 메서드 자동 제공
public interface BoardRepository extends CrudRepository<Board, Long> {
    // 제목이 일치하는 게시글 조회
    List<Board> findByTitle(String searchKeyword);

    // 내용에 특정 키워드가 포함된 게시글 조회
    List<Board> findByContentContaining(String searchKeyword);

    // 제목 또는 내용에 특정 키워드가 포함된 게시글 조회
    List<Board> findByTitleContainingOrContentContaining(String title, String content);

    // 제목에 키워드가 포함된 게시글을 번호 내림차순으로 정렬하여 조회
    List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);

    // 제목에 키워드가 포함된 게시글을 페이징 처리하여 조회
    Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);
}
