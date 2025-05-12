package com.example.springbootquickstartstudy.ch5.repository;

import com.example.springbootquickstartstudy.ch5.domain.UnidirectionalMember;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<UnidirectionalMember, String> {

}
