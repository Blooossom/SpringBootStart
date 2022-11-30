package com.example.test1.service;

import com.example.test1.domain.Member;
import com.example.test1.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@Transactional//TC 후 롤백
class MemberServiceIntegrationTest {

@Autowired
MemberService memberService;
@Autowired
MemberRepository memberRepository;

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        /*
        memberService.join(member1);
        try{
            memberService.join(member2);
            fail();
        }catch (IllegalStateException err){
            assertThat(err.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
         */
        //then
    }



    @Test
    void findMember() {
    }

    @Test
    void findOne() {
    }
}