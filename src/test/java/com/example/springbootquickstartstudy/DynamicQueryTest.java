//package com.example.springbootquickstartstudy;
//
//import com.example.springbootquickstartstudy.ch5.domain.Board;
//import com.example.springbootquickstartstudy.ch5.domain.QBoard;
//import com.example.springbootquickstartstudy.ch5.repository.DynamicBoardRepository;
//import com.querydsl.core.BooleanBuilder;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//
//// QueryDSL을 활용한 동적 쿼리 기능을 테스트하는 클래스
//@SpringBootTest
//public class DynamicQueryTest {
//    // DynamicBoardRepository 주입
//    @Autowired
//    private DynamicBoardRepository dynamicBoardRepo;
//
//    // 제목에 키워드가 포함된 게시글 검색
//    @Test
//    public void testDynamicQuery() {
//        String searchCondition = "TITLE";
//        String searchKeyword = "테스트 제목 10";
//
//        // 동적 조건 생성
//        BooleanBuilder builder = new BooleanBuilder();
//
//        QBoard qBoard = QBoard.board;
//
//        if (searchCondition.equals("TITLE")) {
//            builder.and(qBoard.title.like("%" + searchKeyword + "%")); // 제목 검색 조건
//        } else if(searchCondition.equals("CONTENT")) {
//            builder.and(qBoard.content.like("%" + searchKeyword + "%")); // 내용 검색 조건
//        }
//
//        // 페이지 요청: 0번째 페이지, 5개씩
//        Pageable paging = PageRequest.of(0, 5);
//
//        // 동적 조건 + 페이징으로 게시글 검색
//        Page<Board> boardList = dynamicBoardRepo.findAll(builder, paging);
//
//        // 결과 출력
//        System.out.println("검색 결과");
//        for (Board board : boardList) {
//            System.out.println("---> " + board.toString());
//        }
//    }
//
//    // 내용에 키워드가 포함된 게시글 검색
//    @Test
//    public void testDynamicQuery2() {
//        String searchCondition = "CONTENT";
//        String searchKeyword = "테스트 제목 10";
//
//        // 동적 조건 생성
//        BooleanBuilder builder = new BooleanBuilder();
//
//        QBoard qBoard = QBoard.board;
//
//        if (searchCondition.equals("TITLE")) {
//            builder.and(qBoard.title.like("%" + searchKeyword + "%")); // 제목 검색 조건
//        } else if(searchCondition.equals("CONTENT")) {
//            builder.and(qBoard.content.like("%" + searchKeyword + "%")); // 내용 검색 조건
//        }
//
//        // 페이지 요청: 0번째 페이지, 5개씩
//        Pageable paging = PageRequest.of(0, 5);
//
//        // 동적 조건 + 페이징으로 게시글 검색
//        Page<Board> boardList = dynamicBoardRepo.findAll(builder, paging);
//
//        // 결과 출력
//        System.out.println("검색 결과");
//        for (Board board : boardList) {
//            System.out.println("---> " + board.toString());
//        }
//    }
//}
