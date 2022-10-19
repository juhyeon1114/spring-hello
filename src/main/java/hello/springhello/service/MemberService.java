package hello.springhello.service;

import hello.springhello.domain.Member;
import hello.springhello.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service: 스프링 컨테이너에 서비스로 등록
@Service
public class MemberService {

  private final MemberRepository memberRepository;

  @Autowired
  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  public Long join(Member member) {
    validateDuplicatedMember(member);

    memberRepository.save(member);
    return member.getId();
  }

  private void validateDuplicatedMember(Member member) {
    memberRepository.findByName(member.getName())
      .ifPresent(m ->{
        throw new IllegalStateException("이미 존재하는 회원입니다");
      });
  }

  public List<Member> findMembers() {
    return memberRepository.findAll();
  }

  public Optional<Member> findOne(Long memberId) {
    return memberRepository.findById(memberId);
  }

}
