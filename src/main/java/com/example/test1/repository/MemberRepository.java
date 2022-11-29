package com.example.test1.repository;

import com.example.test1.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    //가져온 것이 null일수도 있지만
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
