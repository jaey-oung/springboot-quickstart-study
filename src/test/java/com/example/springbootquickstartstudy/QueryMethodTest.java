package com.example.springbootquickstartstudy;

import com.example.springbootquickstartstudy.ch5.domain.Board;
import com.example.springbootquickstartstudy.ch5.repository.BoardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

// BoardRepository의 쿼리 메소드와 쿼리 어노테이션 기능을 테스트하는 클래스
@SpringBootTest
public class QueryMethodTest {
    // BoardRepository 주입
    @Autowired
    private BoardRepository boardRepo;

    // 테스트 실행 전 데이터 초기화
    @BeforeEach
    public void dataPrepare() {
        // 기존 게시글 제거
        boardRepo.deleteAll();

        // 테스트 게시글 200건 등록
        for (int i = 1; i <= 200; i++) {
            Board board = new Board();
            board.setTitle("테스트 제목 " + i);
            board.setWriter("테스터");
            board.setContent("테스트 내용 " + i);
            board.setCreateDate(new Date());
            board.setCnt(0L);
            boardRepo.save(board);
        }
    }

    // 제목이 정확히 일치하는 게시글 검색
    @Test
    public void testFindByTitle() {
        List<Board> boardList = boardRepo.findByTitle("테스트 제목 10");

        System.out.println("검색 결과");
        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }

    // 내용에 키워드가 포함된 게시글 검색
    @Test
    public void testByContentContaining() {
        List<Board> boardList = boardRepo.findByContentContaining("17");

        System.out.println("검색 결과");
        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }

    // 제목 또는 내용에 키워드가 포함된 게시글 검색
    @Test
    public void testFindByTitleContainingOrContentContaining() {
        List<Board> boardList = boardRepo.findByTitleContainingOrContentContaining("17", "17");

        System.out.println("검색 결과");
        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }

    // 제목에 키워드가 포함된 게시글을 번호 내림차순으로 검색
    @Test
    public void testFindByTitleContainingOrderBySeqDesc() {
        List<Board> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("17");

        System.out.println("검색 결과");
        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }

    // 제목에 키워드가 포함된 게시글을 페이징 처리하여 검색
    @Test
    public void testFindByTitleContaining() {
        // 페이지 요청: 0번째 페이지, 5개씩, 번호 내림차순 정렬
        Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");
        Page<Board> pageInfo = boardRepo.findByTitleContaining("제목", paging);

        System.out.println("PAGE SIZE: " + pageInfo.getSize());
        System.out.println("TOTAL PAGES: " + pageInfo.getTotalPages());
        System.out.println("TOTAL COUNT: " + pageInfo.getTotalElements());
        System.out.println("NEXT: " + pageInfo.nextPageable());

        List<Board> boardList = pageInfo.getContent();

        System.out.println("검색 결과");
        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }

    // 위치 기반 파라미터 검색
    @Test
    public void testQueryAnnotationTest1() {
        List<Board> boardList = boardRepo.queryAnnotationTest1("테스트 제목 10");

        System.out.println("검색 결과");
        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }

    // 이름 기반 파라미터 검색
    @Test
    public void testQueryAnnotationTest2() {
        List<Board> boardList = boardRepo.queryAnnotationTest2("테스트 제목 10");

        System.out.println("검색 결과");
        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }

    // 특정 컬럼만 선택하여 검색
    @Test
    public void testQueryAnnotationTest3() {
        List<Object[]> boardList = boardRepo.queryAnnotationTest3("테스트 제목 10");

        System.out.println("검색 결과");
        for (Object[] row : boardList) {
            System.out.println("---> " + Arrays.toString(row));
        }
    }

    // 전체 게시글을 페이징 처리하여 검색
    @Test
    public void testQueryAnnotationTest4() {
        Pageable paging = PageRequest.of(0, 3, Sort.Direction.DESC, "seq");
        List<Board> boardList = boardRepo.queryAnnotationTest4(paging);

        System.out.println("검색 결과");
        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }

    // 특정 컬럼만 검색
    @Test
    public void testQueryAnnotationTest5() {
        List<Object[]> boardList = boardRepo.queryAnnotationTest5("테스트 제목 10");

        System.out.println("검색 결과");
        for (Object[] row : boardList) {
            System.out.println("---> " + Arrays.toString(row));
        }
    }
}
