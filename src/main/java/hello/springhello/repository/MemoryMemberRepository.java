package hello.springhello.repository;

import hello.springhello.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository: 스프링 컨테이너에 리포지토리로 등록
@Repository
public class MemoryMemberRepository implements MemberRepository {

  private static Map<Long, Member> store = new HashMap<>();
  private static long sequence = 0L;

  @Override
  public Member save(Member member) {
    member.setId(++sequence);
    store.put(member.getId(), member);
    return member;
  }

  @Override
  public Optional<Member> findById(Long id) {
    /**
     * @desc
     * .ofNullable(item): item이 null일 수 있어도 에러가 나지 않도록 해준다. 후속 처리 필요.
     */
    return Optional.ofNullable(store.get(id));
  }

  @Override
  public Optional<Member> findByName(String name) {
    return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
  }

  @Override
  public List<Member> findAll() {
    return new ArrayList<>(store.values());
  }

  public void clearStore() {
    store.clear();
  }
}
