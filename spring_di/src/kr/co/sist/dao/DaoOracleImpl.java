package kr.co.sist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.vo.EmpVO;

public class DaoOracleImpl implements DAO {

	@Override
	public int insertEmp(EmpVO emp_vo) throws SQLException {
		// Oracle DB에 Insert작업 수행.
		System.out.println("Oracle에 사원정보 추가");
		return 1;
	}// insertEmp

	@Override
	public List<EmpVO> selectEmp() throws SQLException {
		// Oracle DB에서 조회.
		List<EmpVO> list = new ArrayList<>();
		list.add(new EmpVO(1111, "노진경"));
		list.add(new EmpVO(1112, "김희철"));
		list.add(new EmpVO(1113, "김정윤"));
		list.add(new EmpVO(1114, "이재찬"));
		return list;
	}// selectEmp

}// class
