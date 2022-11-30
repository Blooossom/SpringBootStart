package com.example.test1.repository;

import com.example.test1.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface SpringDataJPAMemberRepository extends JpaRepository<com.example.test1.domain.Member,Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}
