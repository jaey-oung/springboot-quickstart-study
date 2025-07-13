package com.example.springbootquickstartstudy.ch6.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity // 해당 클래스가 JPA 엔티티임을 명시
public class Board {

    @Id // 기본 키(PK) 지정
    @GeneratedValue // PK 값 자동 생성
    private Long seq; // 게시글 번호

    private String title; // 제목

    @Column(updatable = false) // 수정 불가 필드 (작성자는 한 번 입력되면 변경되지 않음)
    private String writer; // 작성자

    private String content; // 본문 내용

    // DB에서 기본값으로 SYSDATE를 넣도록 설정
    // JPA는 INSERT/UPDATE 시 이 필드를 무시 → DB가 자동 설정
    @Column(insertable = false, updatable = false, columnDefinition = "timestamp default current_timestamp")
    private Date createDate;

    // DB에서 기본값으로 0을 넣도록 설정 (조회수 초기값)
    // JPA는 INSERT/UPDATE 시 이 필드를 무시 → DB가 자동 설정
    @Column(insertable = false, updatable = false, columnDefinition = "number default 0")
    private Long cnt;

}
