package hello.hellodesperate;

import hello.hellodesperate.repository.JdbcMemberRepository;
import hello.hellodesperate.repository.JpaMemberRepository;
import hello.hellodesperate.repository.MemberRepository;
import hello.hellodesperate.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration //아래의 것들을 스프링 빈에 등록하라는 뜻이네?
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;

    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {

        return new JpaMemberRepository(em);

        //return new JdbcMemberRepository(dataSource);
    }



}
