package com.example.test1;


import com.example.test1.repository.*;
import com.example.test1.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/*
자바 코드로 직접 스프링 빈 등록하기
 */
@Configuration
public class SpringConfig {


    //private DataSource dataSource;
    //private EntityManager em;

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

  //  @Bean
    //public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JDBCMemberRepository(dataSource);
        //return new JDBCTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);

    }

