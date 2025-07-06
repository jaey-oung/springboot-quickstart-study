//package com.example.springbootquickstartstudy;
//
//import com.example.springbootquickstartstudy.ch5.domain.Board;
//import com.example.springbootquickstartstudy.ch5.repository.BoardRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Date;
//
//// BoardRepository 기능 테스트 클래스
//@SpringBootTest
//public class BoardRepositoryTest {
//    // BoardRepository 주입
//    @Autowired
//    private BoardRepository boardRepo;
//
//    // 게시글 등록 테스트
//    @Test
//    public void testInsertBoard() {
//        Board board = new Board();
//        board.setTitle("첫 번째 게시글"); // 제목 설정
//        board.setWriter("테스터"); // 작성자 설정
//        board.setContent("잘 등록되나요?"); // 내용 설정
//        board.setCreateDate(new Date()); // 작성일시 설정
//        board.setCnt(0L); // 조회수 설정
//
//        boardRepo.save(board); // 게시글 저장
//    }
//
//    // 게시글 조회 테스트
//    @Test
//    public void testGetBoard() {
//        Board board = boardRepo.findById(1L).get(); // ID가 1인 게시글 조회
//        System.out.println(board.toString()); // 조회 결과 출력
//    }
//
//    // 게시글 수정 테스트
//    @Test
//    public void testUpdateBoard() {
//        System.out.println("=== 1번 게시글 조회 ===");
//        Board board = boardRepo.findById(1L).get(); // ID가 1인 게시글 조회
//
//        System.out.println("=== 1번 게시글 제목 수정 ===");
//        board.setTitle("제목을 수정했습니다"); // 제목 변경
//        boardRepo.save(board); // 변경 내용 저장
//    }
//
//    // 게시글 삭제 테스트
//    @Test
//    public void testDeleteBoard() {
//        boardRepo.deleteById(1L); // ID가 1인 게시글 삭제
//    }
//}
