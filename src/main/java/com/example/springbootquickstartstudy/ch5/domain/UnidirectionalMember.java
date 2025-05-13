package com.example.springbootquickstartstudy.ch5.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 회원(UnidirectionalMember) 엔티티 클래스
// UNIDIRECTIONAL_MEMBER 테이블과 매핑됨
@Getter
@Setter
@ToString
@Entity
public class UnidirectionalMember {
    @Id // 기본 키(PK) 지정
    @Column(name = "MEMBER_ID") // MEMBER_ID 컬럼명 명시
    private String id; // 아이디
    private String password; // 비밀번호
    private String name; // 이름
    private String role; // 권한
}
