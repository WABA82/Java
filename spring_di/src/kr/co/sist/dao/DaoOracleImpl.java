package kr.co.sist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.vo.EmpVO;

public class DaoOracleImpl implements DAO {

	@Override
	public int insertEmp(EmpVO emp_vo) throws SQLException {
		// Oracle DB�� Insert�۾� ����.
		System.out.println("Oracle�� ������� �߰�");
		return 1;
	}// insertEmp

	@Override
	public List<EmpVO> selectEmp() throws SQLException {
		// Oracle DB���� ��ȸ.
		List<EmpVO> list = new ArrayList<>();
		list.add(new EmpVO(1111, "������"));
		list.add(new EmpVO(1112, "����ö"));
		list.add(new EmpVO(1113, "������"));
		list.add(new EmpVO(1114, "������"));
		return list;
	}// selectEmp

}// class
