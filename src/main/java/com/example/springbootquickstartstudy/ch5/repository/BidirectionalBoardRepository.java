package com.example.springbootquickstartstudy.ch5.repository;

import com.example.springbootquickstartstudy.ch5.domain.UnidirectionalBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UnidirectionalBoardRepository extends CrudRepository<UnidirectionalBoard, Long> {
    // === 쿼리 메소드 기반 ===

    // 제목이 정확히 일치하는 게시글 조회
    List<UnidirectionalBoard> findByTitle(String searchKeyword);

    // 내용에 키워드가 포함된 게시글 조회
    List<UnidirectionalBoard> findByContentContaining(String searchKeyword);

    // 제목 또는 내용에 키워드가 포함된 게시글 조회
    List<UnidirectionalBoard> findByTitleContainingOrContentContaining(String title, String content);

    // 제목에 키워드가 포함된 게시글을 번호 내림차순으로 정렬하여 조회
    List<UnidirectionalBoard> findByTitleContainingOrderBySeqDesc(String searchKeyword);

    // 제목에 키워드가 포함된 게시글을 페이징 처리하여 조회
    Page<UnidirectionalBoard> findByTitleContaining(String searchKeyword, Pageable pageable);
}
