package com.example.springbootquickstartstudy.ch5.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

// 회원(BidirectionalMember) 엔티티 클래스
// BIDIRECTIONAL_MEMBER 테이블과 매핑됨
@Getter
@Setter
@ToString(exclude = "bidirectionalBoardList")
@Entity
public class BidirectionalMember {
    @Id // 기본 키(PK) 지정
    @Column(name = "MEMBER_ID") // MEMBER_ID 컬럼명 명시
    private String id; // 아이디
    private String password; // 비밀번호
    private String name; // 이름
    private String role; // 권한

    @OneToMany(mappedBy = "bidirectionalMember", fetch = FetchType.EAGER)
    // 회원이 작성한 게시글 목록
    // mappedBy → 연관관계의 주인은 게시글(BidirectionalBoard)
    // EAGER → 회원 조회 시 게시글도 함께 조회됨
    private List<BidirectionalBoard> bidirectionalBoardList  = new ArrayList<>();
}
