package hello.springhello.controller;

import hello.springhello.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//@Controller: 스프링 컨테이너에 컨트롤러로 등록
@Controller
public class MemberController {

  private final MemberService memberService;

  // @Autowired: memberService를 스프링 컨테이너에서 가져옴
  @Autowired
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

}
