package com.example.springbootquickstartstudy.ch5.repository;

import com.example.springbootquickstartstudy.ch5.domain.Board;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

// Board 엔티티를 위한 리포지토리 인터페이스
// CrudRepository 상속 → 기본 CRUD 메서드 자동 제공
// QuerydslPredicateExecutor 상속 → 동적 쿼리 메서드 제공
public interface DynamicBoardRepository extends CrudRepository<Board, Long>, QuerydslPredicateExecutor<Board> {

}
