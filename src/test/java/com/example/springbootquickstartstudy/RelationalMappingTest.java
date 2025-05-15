package com.example.springbootquickstartstudy;

import com.example.springbootquickstartstudy.ch5.domain.*;
import com.example.springbootquickstartstudy.ch5.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class RelationalMappingTest {
    // UnidirectionalBoardRepository 주입
    @Autowired
    private UnidirectionalBoardRepository unidirectionalBoardRepo;

    // UnidirectionalMemberRepository 주입
    @Autowired
    private UnidirectionalMemberRepository unidirectionalMemberRepo;

    // BidirectionalBoardRepository 주입
    @Autowired
    private BidirectionalBoardRepository bidirectionalBoardRepo;

    // BidirectionalMemberRepository 주입
    @Autowired
    private BidirectionalMemberRepository bidirectionalMemberRepo;

    // CascadeBoardRepository 주입
    @Autowired
    private CascadeBoardRepository cascadeBoardRepo;

    // CascadeMemberRepository 주입
    @Autowired
    private CascadeMemberRepository cascadeMemberRepo;

    // 단방향 연관관계 저장 테스트
    @Test
    public void testManyToOneInsert() {
        // 회원 엔티티 저장
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

        // 게시글 엔티티 저장
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

    // 단방향 연관관계 조회 테스트
    @Test
    public void testManyToOneSelect() {
        UnidirectionalBoard unidirectionalBoard = unidirectionalBoardRepo.findById(5L).get();
        System.out.println("[ " + unidirectionalBoard.getSeq() + "번 게시글 정보 ]");
        System.out.println("제목: " + unidirectionalBoard.getTitle());
        System.out.println("내용: " + unidirectionalBoard.getContent());
        System.out.println("작성자: " + unidirectionalBoard.getUnidirectionalMember().getName());
        System.out.println("작성자 권한 : " + unidirectionalBoard.getUnidirectionalMember().getRole());
    }

    // 양방향 연관관계 저장 테스트
    @Test
    public void testBidirectionalInsert() {
        // 회원 엔티티 저장
        BidirectionalMember bidirectionalMember1 = new BidirectionalMember();
        bidirectionalMember1.setId("member1");
        bidirectionalMember1.setPassword("member111");
        bidirectionalMember1.setName("둘리");
        bidirectionalMember1.setRole("User");
        bidirectionalMemberRepo.save(bidirectionalMember1);

        BidirectionalMember bidirectionalMember2 = new BidirectionalMember();
        bidirectionalMember2.setId("member2");
        bidirectionalMember2.setPassword("member222");
        bidirectionalMember2.setName("도우너");
        bidirectionalMember2.setRole("Admin");
        bidirectionalMemberRepo.save(bidirectionalMember2);

        // 게시글 엔티티 저장
        for (int i = 1; i <= 3; i++) {
            BidirectionalBoard bidirectionalBoard = new BidirectionalBoard();
            bidirectionalBoard.setBidirectionalMember(bidirectionalMember1);
            bidirectionalBoard.setTitle("둘리가 등록한 게시글 " + i);
            bidirectionalBoard.setContent("둘리가 등록한 게시글 내용 " + i);
            bidirectionalBoard.setCreateDate(new Date());
            bidirectionalBoard.setCnt(0L);
            bidirectionalBoardRepo.save(bidirectionalBoard);
        }

        for (int i = 1; i <= 3; i++) {
            BidirectionalBoard bidirectionalBoard = new BidirectionalBoard();
            bidirectionalBoard.setBidirectionalMember(bidirectionalMember2);
            bidirectionalBoard.setTitle("도우너가 등록한 게시글 " + i);
            bidirectionalBoard.setContent("도우너가 등록한 게시글 내용 " + i);
            bidirectionalBoard.setCreateDate(new Date());
            bidirectionalBoard.setCnt(0L);
            bidirectionalBoardRepo.save(bidirectionalBoard);
        }
    }

    // 양방향 연관관계 조회 테스트
    @Test
    public void testTwoWayMapping() {
        BidirectionalMember bidirectionalMember = bidirectionalMemberRepo.findById("member1").get();

        System.out.println("==============================");
        System.out.println(bidirectionalMember.getName() + "가(이) 저장한 게시글 목록");
        System.out.println("==============================");
        List<BidirectionalBoard> bidirectionalBoardList = bidirectionalMember.getBidirectionalBoardList();
        for (BidirectionalBoard bidirectionalBoard : bidirectionalBoardList) {
            System.out.println(bidirectionalBoard.toString());
        }
    }

    // 영속성 전이 기반 연관관계 저장 테스트
    // CascadeMember 엔티티 저장 시 관련 CascadeBoard 게시글들도 함께 저장됨
    @Test
    public void testCascadeInsert() {
        // 회원 엔티티 저장
        CascadeMember cascadeMember1 = new CascadeMember();
        cascadeMember1.setId("member1");
        cascadeMember1.setPassword("member111");
        cascadeMember1.setName("둘리");
        cascadeMember1.setRole("User");

        CascadeMember cascadeMember2 = new CascadeMember();
        cascadeMember2.setId("member2");
        cascadeMember2.setPassword("member222");
        cascadeMember2.setName("도우너");
        cascadeMember2.setRole("Admin");

        // 게시글 엔티티 저장
        for (int i = 1; i <= 3; i++) {
            CascadeBoard cascadeBoard = new CascadeBoard();
            cascadeBoard.setCascadeMember(cascadeMember1);
            cascadeBoard.setTitle("둘리가 등록한 게시글 " + i);
            cascadeBoard.setContent("둘리가 등록한 게시글 내용 " + i);
            cascadeBoard.setCreateDate(new Date());
            cascadeBoard.setCnt(0L);
        }
        cascadeMemberRepo.save(cascadeMember1);

        for (int i = 1; i <= 3; i++) {
            CascadeBoard cascadeBoard = new CascadeBoard();
            cascadeBoard.setCascadeMember(cascadeMember2);
            cascadeBoard.setTitle("도우너가 등록한 게시글 " + i);
            cascadeBoard.setContent("도우너가 등록한 게시글 내용 " + i);
            cascadeBoard.setCreateDate(new Date());
            cascadeBoard.setCnt(0L);
        }
        cascadeMemberRepo.save(cascadeMember2);
    }

    // 영속성 전이 기반 연관관계 삭제 테스트
    // CascadeMember 삭제 시 관련 CascadeBoard 게시글들도 함께 삭제됨
    @Test
    public void testCascadeDelete() {
        cascadeMemberRepo.deleteById("member2");
    }
}
