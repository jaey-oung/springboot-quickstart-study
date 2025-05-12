package com.example.springbootquickstartstudy.ch5.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
public class RelationalBoard {
    @Id @GeneratedValue
    private Long seq;
    private String title;
    private String content;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createDate;
    private Long cnt;

    @ManyToOne
    // @JoinColumn(name = "MEMBER_ID") // 외부 조인
    @JoinColumn(name = "MEMBER_ID", nullable = false) // 내부 조인
    private UnidirectionalMember unidirectionalMember;
}
