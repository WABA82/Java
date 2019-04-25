package kr.co.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.co.sist.vo.MemberVO;

@Component
public class JdbcDAO {

	@Autowired(required = false)
	private JdbcTemplate jt;

	public void insertMember(MemberVO m_vo) {

		// Spring_jdbc를 사용하여 레코드 추가.
		String insertMember = "insert into test_like(num, name, loc, highschool, img) values(seq_reply.nextval,?,?,?,?)";

		jt.update(insertMember, m_vo.getName(), m_vo.getLoc(), m_vo.getHighSchool(), m_vo.getImg());

	}// insertMember

}// class
