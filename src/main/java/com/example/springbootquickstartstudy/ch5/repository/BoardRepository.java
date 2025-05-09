package com.example.springbootquickstartstudy.ch5.repository;

import com.example.springbootquickstartstudy.ch5.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// Board 엔티티를 위한 리포지토리 인터페이스
// CrudRepository 상속으로 기본 CRUD 메서드 자동 제공
public interface BoardRepository extends CrudRepository<Board, Long> {
    // === 쿼리 메소드 기반 ===

    // 제목이 정확히 일치하는 게시글 조회
    List<Board> findByTitle(String searchKeyword);

    // 내용에 키워드가 포함된 게시글 조회
    List<Board> findByContentContaining(String searchKeyword);

    // 제목 또는 내용에 키워드가 포함된 게시글 조회
    List<Board> findByTitleContainingOrContentContaining(String title, String content);

    // 제목에 키워드가 포함된 게시글을 번호 내림차순으로 정렬하여 조회
    List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);

    // 제목에 키워드가 포함된 게시글을 페이징 처리하여 조회
    Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);

    // === JPQL 기반 ===

    // 위치 기반 파라미터 사용
    @Query("SELECT b FROM Board b WHERE b.title like %?1% ORDER BY b.seq DESC ")
    List<Board> queryAnnotationTest1(String searchKeyword);

    // 이름 기반 파라미터 사용
    @Query("SELECT b FROM Board b "
            + "WHERE b.title like %:searchKeyword% "
            + "ORDER BY b.seq DESC")
    List<Board> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);

    // 특정 컬럼만 선택하여 조회
    @Query("SELECT b.seq, b.title, b.writer, b.createDate "
            + "FROM Board b "
            + "WHERE b.title like %?1% "
            + "ORDER BY b.seq DESC")
    List<Object[]> queryAnnotationTest3(@Param("searchKeyword") String searchKeyword);

    // 전체 게시글을 페이징 처리하여 조회
    @Query("SELECT b FROM Board b ORDER BY b.seq DESC")
    List<Board> queryAnnotationTest4(Pageable paging);

    // === 네이티브 쿼리 기반 ===

    // 특정 컬럼만 조회
    @Query(value = "select seq, title, writer, create_date "
            + "from board where title like '%'||?1||'%' "
            + "order by seq desc", nativeQuery = true)
    List<Object[]> queryAnnotationTest5(String searchKeyword);
}
