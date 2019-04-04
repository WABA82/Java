package kr.co.sist.exam.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.co.sist.exam.domain.DeptInfo;

public class MyBatisDAO {

	private static MyBatisDAO mb_dao;
	private SqlSessionFactory ssf = null;

	private MyBatisDAO() {
	}// 생성자

	public static MyBatisDAO getInstance() {
		if (mb_dao == null) {
			mb_dao = new MyBatisDAO();
		} // end if
		return mb_dao;
	}// getInstance

	public synchronized SqlSessionFactory getSessionFactory() {

		if (ssf == null) {
			org.apache.ibatis.logging.LogFactory.useLog4JLogging();

			Reader reader = null;
			try {
				// 1.설정용 xml로딩
				reader = Resources.getResourceAsReader("kr/co/sist/exam/dao/mybatis_config.xml");

				// 2. MyBatis Framework 생성.
				SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();

				// 3DB완 연동된 객체 받기.
				ssf = ssfb.build(reader);

				// 연결 끊기.
				if (reader != null) {
					reader.close();
				} // end if

			} catch (IOException ie) {
				ie.printStackTrace();
			} // end catch

		} // end if

		return ssf;
	}// getSessionFactory

	public String SingleColumn() {
		// MyBatis 핸들러(SqlSession)를 사용하여 Mapper(쿼리를 작성하는 xml)에 있는 ID를 찾고 Parsing 해서 조회된 결과를 얻는다.
		String dname = "";
		
		SqlSession ss = getSessionFactory().openSession();
		dname = ss.selectOne("singleColumn");
		
		ss.close();
		return dname;
	}// SingleColumn

	public DeptInfo multiColumn() {
		DeptInfo di = null;

		MyBatisDAO mb_dao = MyBatisDAO.mb_dao;
		SqlSession ss = mb_dao.getSessionFactory().openSession();

		di = ss.selectOne("multiColumn");
		ss.close();

		return di;
	}// multiColumn

	public List<Integer> multiRow() {
		List<Integer> list = null;
		
		MyBatisDAO mb_dao = MyBatisDAO.getInstance();
		SqlSession ss = mb_dao.getSessionFactory().openSession();
		
		list = ss.selectList("multiRow");
		ss.close();
		
		return list;
	}// multiRow

	public static void main(String[] args) {
		MyBatisDAO m = MyBatisDAO.getInstance();
		System.out.println(m.multiColumn());
	}// main

}// class
