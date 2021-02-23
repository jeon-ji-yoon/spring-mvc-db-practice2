package hello.hellodesperate;

import hello.hellodesperate.repository.MemberRepository;
import hello.hellodesperate.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //아래의 것들을 스프링 빈에 등록하라는 뜻이네?
public class SpringConfig {

    private final MemberRepository memberRepository; //springDataJpaMemberRepository
    //jparepository 가 해당 인터페이스를 자동으로 빈에 등록해줌...

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository);
    }
    /*
    @Bean
    public MemberRepository memberRepository() {


        return
        //return new JpaMemberRepository(em);

        //return new JdbcMemberRepository(dataSource);
    }
*/


}
