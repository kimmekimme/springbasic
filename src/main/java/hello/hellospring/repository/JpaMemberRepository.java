package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
//JPA가 알아서 단건은 CRUD기능 동작
public class JpaMemberRepository implements MemberRepository{

    //EntityManager 기반 동작, DB연동 처리 스프링이 알아서, jpa 쓸라면 주입받아야함
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }
//pk기반이 아니면 jpql이라는 쿼리 작성해야 함. 스프링 데이터 jpa사용하면 안 해도 됨.
    @Override
    public Optional<Member> findByName(String name) {

        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name",name).getResultList();

        return result.stream().findAny();
    }


    @Override
    public List<Member> findAll() {
        List<Member> result = em.createQuery("select m from Member as m", Member.class).getResultList(); //Member: 객체대상 쿼리, 객체자체조회
        return result;
    }
}
