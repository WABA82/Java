package kr.co.sist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.vo.EmpVO;

public class DaoMySQLImpl implements DAO {

	@Override
	public int insertEmp(EmpVO emp_vo) throws SQLException {
		// MySQL DB에 Insert작업 수행.
		System.out.println("MySQL에 사원정보 추가");
		return 1;
	}// insertEmp

	@Override
	public List<EmpVO> selectEmp() throws SQLException {
		// MySQL DB에서 조회.
		List<EmpVO> list = new ArrayList<>();
		list.add(new EmpVO(2111, "공선의"));
		list.add(new EmpVO(2112, "이재현"));
		list.add(new EmpVO(2113, "오영근"));
		list.add(new EmpVO(2114, "정택성"));
		list.add(new EmpVO(2114, "이봉현"));
		return list;
	}// selectEmp

}// class
