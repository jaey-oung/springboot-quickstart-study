package com.example.springbootquickstartstudy.ch5.repository;

import com.example.springbootquickstartstudy.ch5.domain.CascadeMember;
import org.springframework.data.repository.CrudRepository;

// CascadeMember 엔티티를 위한 리포지토리 인터페이스
// CrudRepository 상속으로 기본 CRUD 메서드 자동 제공
public interface CascadeMemberRepository extends CrudRepository<CascadeMember, String> {

}
