package com.example.springbootquickstartstudy.ch6.persistence;

import com.example.springbootquickstartstudy.ch6.domain.Board;
import org.springframework.data.repository.CrudRepository;

// Board 엔티티를 위한 CRUD 기능 제공
// <엔티티 타입, 기본 키 타입>으로 제네릭 지정됨

// 기본적으로 다음 메서드들을 자동 제공함:
// - save(S entity)
// - findById(ID id)
// - findAll()
// - deleteById(ID id)
// 등
public interface BoardRepository extends CrudRepository<Board,Long> {

}
