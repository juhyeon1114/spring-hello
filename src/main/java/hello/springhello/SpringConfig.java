package hello.springhello;

import hello.springhello.repository.MemberRepository;
import hello.springhello.repository.MemoryMemberRepository;
import hello.springhello.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * - 컴포넌트 스캔 방식을 이용하지 않고, 수동으로 스프링 컨테이너에 Bean을 등록
 * - 실무에서는 Controller, Service, Repository와 같은 정형화된 것들은 컴포넌트 스캔을 이용하고,
 *   상황에 따라서 구현클래스를 변경해야하는 경우엔 빈을 직접 등록해준다.
 */
@Configuration
public class SpringConfig {

//  @Bean
//  public MemberService memberService() {
//    return new MemberService(memberRepository());
//  }
//
//  @Bean
//  public MemberRepository memberRepository() {
//    return new MemoryMemberRepository();
//  }

}
