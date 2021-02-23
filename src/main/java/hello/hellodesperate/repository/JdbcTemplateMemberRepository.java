package hello.hellodesperate.repository;

import hello.hellodesperate.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class JdbcTemplateMemberRepository implements MemberRepository{
    private final JdbcTemplate jdbcTemplate;

    @Autowired //생성자가 1개일때 스프링빈으로 등록되면 autowired 생략가능
    public JdbcTemplateMemberRepository(DataSource datasource) {
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }


    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return jdbcTemplate.query("select * from member where id=?",)
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
