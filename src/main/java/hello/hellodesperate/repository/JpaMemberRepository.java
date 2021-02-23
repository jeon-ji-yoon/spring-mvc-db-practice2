package hello.hellodesperate.repository;

import hello.hellodesperate.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em; //jpa는 EntityManager 라는 것으로 모든 것이 동작한다

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); //jpa가 insert쿼리 다 만들어주고 id생성까지 해줌 ㅎㅎ
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
        /*
        * 클래스라는 것 자체도 필드, 생성자, 메서드 등의 속성을 가지고 있습니다.

즉, Class 클래스는 이러한 클래스의 구조 자체를 하나의 클래스로 표현해놓은 클래스입니다.
*/

    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
