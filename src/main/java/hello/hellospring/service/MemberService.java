package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//컨테이너 등록
public class MemberService { //ctrl + shift + t: 테스트 생성
    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository){

        this.memberRepository = memberRepository;
    }
    //회원가입
    public Long join(Member member){

//메소드 추출: ctrl + alt + m
        validateDuplicateMember(member); //중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())//optional 반환
             .ifPresent(m -> { //m==member
                 throw new IllegalStateException("이미 존재하는 회원입니다.");
             });
    }

    public List<Member> findMembers() { //전체 회원 조회
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) { //회원 조회
        return memberRepository.findById(memberId);
    }

}
