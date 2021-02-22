package hello.hellodesperate;

import hello.hellodesperate.repository.JdbcMemberRepository;
import hello.hellodesperate.repository.MemberRepository;
import hello.hellodesperate.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration //아래의 것들을 스프링 빈에 등록하라는 뜻이네?
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {

        return new JdbcMemberRepository(dataSource);
    }



}
