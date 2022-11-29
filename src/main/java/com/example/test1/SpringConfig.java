package com.example.test1;


import com.example.test1.repository.MemberRepository;
import com.example.test1.repository.MemoryMemberRepository;
import com.example.test1.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
자바 코드로 직접 스프링 빈 등록하기
 */
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
