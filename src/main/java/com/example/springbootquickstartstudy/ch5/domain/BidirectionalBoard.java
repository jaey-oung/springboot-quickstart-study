package com.example.springbootquickstartstudy.ch5.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

// 게시글(BidirectionalBoard) 엔티티 클래스
// BIDIRECTIONAL_BOARD 테이블과 매핑됨
@Getter
@Setter
@ToString(exclude = "bidirectionalMember") // 순환 참조 방지를 위해 작성자 제외
@Entity
public class BidirectionalBoard {
    @Id // 기본 키(PK) 지정
    @GeneratedValue // PK 값 자동 생성
    private Long seq; // 번호
    private String title; // 제목
    private String content; // 내용
    @Temporal(value = TemporalType.TIMESTAMP) // 작성일 → Date 타입을 TIMESTAMP로 매핑
    private Date createDate; // 작성일시
    private Long cnt; // 조회수

    @ManyToOne // 다대일(N:1) 양방향 연관관계 (게시글 → 회원)
    // MEMBER_ID 외래키(FK) 컬럼으로 매핑
    // @JoinColumn(name = "MEMBER_ID") // 외부 조인
    @JoinColumn(name = "MEMBER_ID", nullable = false) // 내부 조인
    private BidirectionalMember bidirectionalMember; // 작성자
}
