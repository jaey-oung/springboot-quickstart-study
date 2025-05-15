package com.example.springbootquickstartstudy.ch5.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

// 게시글(CascadeBoard) 엔티티 클래스
// CASCADE_BOARD 테이블과 매핑됨
@Getter
@Setter
@ToString(exclude = "cascadeMember") // 순환 참조 방지
@Entity
public class CascadeBoard {
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
    private CascadeMember cascadeMember; // 작성자

    // 게시글의 작성자를 설정하면, 회원 엔티티에도 이 게시글을 추가하여 양방향 관계 유지
    public void setCascadeMember(CascadeMember cascadeMember) {
        this.cascadeMember = cascadeMember;
        cascadeMember.getCascadeBoardList().add(this);
    }
}
