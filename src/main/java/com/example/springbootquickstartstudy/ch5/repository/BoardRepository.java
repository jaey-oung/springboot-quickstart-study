package com.example.springbootquickstartstudy.ch5.repository;

import com.example.springbootquickstartstudy.ch5.domain.Board;
import org.springframework.data.repository.CrudRepository;

// Board 엔티티를 위한 리포지토리 인터페이스
// CrudRepository를 상속받아 기본 CRUD 메서드가 자동으로 제공됨
public interface BoardRepository extends CrudRepository<Board, Long> {
    // 별도의 메서드 선언 없이 기본 CRUD 메서드 사용 가능
}
