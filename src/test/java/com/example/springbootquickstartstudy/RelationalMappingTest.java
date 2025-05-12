package com.example.springbootquickstartstudy;

import com.example.springbootquickstartstudy.ch5.domain.UnidirectionalBoard;
import com.example.springbootquickstartstudy.ch5.domain.UnidirectionalMember;
import com.example.springbootquickstartstudy.ch5.repository.UnidirectionalMemberRepository;
import com.example.springbootquickstartstudy.ch5.repository.UnidirectionalBoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class UnidirectionalMappingTest {
    @Autowired
    private UnidirectionalBoardRepository unidirectionalBoardRepo;

    @Autowired
    private UnidirectionalMemberRepository unidirectionalMemberRepo;

    @Test
    public void testManyToOneInsert() {
        UnidirectionalMember unidirectionalMember1 = new UnidirectionalMember();
        unidirectionalMember1.setId("member1");
        unidirectionalMember1.setPassword("member111");
        unidirectionalMember1.setName("둘리");
        unidirectionalMember1.setRole("User");
        unidirectionalMemberRepo.save(unidirectionalMember1);

        UnidirectionalMember unidirectionalMember2 = new UnidirectionalMember();
        unidirectionalMember2.setId("member2");
        unidirectionalMember2.setPassword("member222");
        unidirectionalMember2.setName("도우너");
        unidirectionalMember2.setRole("Admin");
        unidirectionalMemberRepo.save(unidirectionalMember2);

        for (int i = 1; i <= 3; i++) {
            UnidirectionalBoard unidirectionalBoard = new UnidirectionalBoard();
            unidirectionalBoard.setUnidirectionalMember(unidirectionalMember1);
            unidirectionalBoard.setTitle("둘리가 등록한 게시글 " + i);
            unidirectionalBoard.setContent("둘리가 등록한 게시글 내용 " + i);
            unidirectionalBoard.setCreateDate(new Date());
            unidirectionalBoard.setCnt(0L);
            unidirectionalBoardRepo.save(unidirectionalBoard);
        }

        for (int i = 1; i <= 3; i++) {
            UnidirectionalBoard unidirectionalBoard = new UnidirectionalBoard();
            unidirectionalBoard.setUnidirectionalMember(unidirectionalMember2);
            unidirectionalBoard.setTitle("도우너가 등록한 게시글 " + i);
            unidirectionalBoard.setContent("도우너가 등록한 게시글 내용 " + i);
            unidirectionalBoard.setCreateDate(new Date());
            unidirectionalBoard.setCnt(0L);
            unidirectionalBoardRepo.save(unidirectionalBoard);
        }
    }

    @Test
    public void testManyToOneSelect() {
        UnidirectionalBoard unidirectionalBoard = unidirectionalBoardRepo.findById(5L).get();
        System.out.println("[ " + unidirectionalBoard.getSeq() + "번 게시글 정보 ]");
        System.out.println("제목: " + unidirectionalBoard.getTitle());
        System.out.println("내용: " + unidirectionalBoard.getContent());
        System.out.println("작성자: " + unidirectionalBoard.getUnidirectionalMember().getName());
        System.out.println("작성자 권한 : " + unidirectionalBoard.getUnidirectionalMember().getRole());
    }
}
