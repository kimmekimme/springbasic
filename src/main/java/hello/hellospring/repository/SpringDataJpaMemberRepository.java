package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//인터페이스의 상속 인터페이스 문법 extends(복습)
//구현체 만들어서 스프링이 알아서 빈에 등록
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository { //<extends object,


    //jpql이 select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name); //끝

    //Optional<Member> findByNameId(String name, Long id); //끝
}
