package com.example.springbootquickstartstudy.ch5.repository;

import com.example.springbootquickstartstudy.ch5.domain.UnidirectionalMember;
import org.springframework.data.repository.CrudRepository;

public interface UnidirectionalMemberRepository extends CrudRepository<UnidirectionalMember, String> {

}
