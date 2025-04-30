package com.example.springbootquickstartstudy.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

// 게시글 정보를 담는 VO(Value Object) 클래스
// 게시글 번호, 제목, 작성자, 내용, 작성일, 조회수 필드 포함
// Lombok을 사용해 Getter, Setter, toString 자동 생성
@Getter
@Setter
@ToString
public class BoardVO {
    private int seq;
    private String title;
    private String writer;
    private String content;
    private Date createDate = new Date();
    private int cnt= 0;

//    // 멤버 변수의 Getter/Setter 직접 작성
//    public int getSeq() {
//        return seq;
//    }
//
//    public void setSeq(int seq) {
//        this.seq = seq;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getWriter() {
//        return writer;
//    }
//
//    public void setWriter(String writer) {
//        this.writer = writer;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public Date getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Date createDate) {
//        this.createDate = createDate;
//    }
//
//    public int getCnt() {
//        return cnt;
//    }
//
//    public void setCnt(int cnt) {
//        this.cnt = cnt;
//    }
}
