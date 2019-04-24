package kr.co.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.JdbcDAO;

@Component
public class JdbcService {

	@Autowired
	private JdbcDAO j_dao;

	public void daoPrint() {
		System.out.println("Äõ¸®½ÇÇà °´Ã¼(jdbcTemplate) : " + j_dao.getJt());
	}// getPrint

}// class
