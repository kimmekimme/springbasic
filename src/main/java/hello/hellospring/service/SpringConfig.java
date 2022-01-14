package hello.hellospring.service;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.security.PrivateKey;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    //private EntityManager em;
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; //JPA가 만들어논 구현체 주입 받음
    }

    //private DataSource dataSource;
   //@Autowired
  //public SpringConfig(DataSource dataSource){ this.dataSource = dataSource; }

    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository);
    }

    @Bean //컴포넌트 스캔 쓰고 빈등록 따로 안하는 방법도 됨
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }

    //@Bean
    //public MemberRepository memberRepository(){
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository(dataSource);
       // return new JdbcTemplateMemberRepository(dataSource);
       // return new JpaMemberRepository(em);
    //}
}
//ctrl(command) + e: 최근파일목록
