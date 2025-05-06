package com.example.springbootquickstartstudy.ch5.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

// 게시글(Board) 엔티티 클래스
// BOARD 테이블과 매핑됨
@Getter
@Setter
@ToString
@Entity
public class Board {
    @Id // 기본 키(PK) 지정
    @GeneratedValue // PK 값 자동 생성
    private Long seq; // 번호
    private String title; // 제목
    private String content; // 내용
    private String writer; // 작성자
    @Temporal(value = TemporalType.TIMESTAMP) // 작성일 → Date 타입을 TIMESTAMP로 매핑
    private Date createDate; // 작성일시
    private Long cnt; // 조회수
}
