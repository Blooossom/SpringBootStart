package com.example.test1.service;

import com.example.test1.domain.Member;
import com.example.test1.repository.MemberRepository;
import com.example.test1.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {


    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository=memberRepository;
    }
    //memberRepository를  직접 생성해주는 것이 아니라 외부에서 넣어주도록 함

    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    public List<Member> findMember(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(member1 -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
        //회원가입 중복처리
         /*
        아래 코드를 줄이면 위처럼
        Optional<Member> result = memberRepository.findByName(member.getName());

        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });
        */

    }
}
