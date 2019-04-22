package kr.co.sist.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.vo.EmpVO;

public class DaoMySQLImpl implements DAO {

	@Override
	public int insertEmp(EmpVO emp_vo) throws SQLException {
		// MySQL DB�� Insert�۾� ����.
		System.out.println("MySQL�� ������� �߰�");
		return 1;
	}// insertEmp

	@Override
	public List<EmpVO> selectEmp() throws SQLException {
		// MySQL DB���� ��ȸ.
		List<EmpVO> list = new ArrayList<>();
		list.add(new EmpVO(2111, "������"));
		list.add(new EmpVO(2112, "������"));
		list.add(new EmpVO(2113, "������"));
		list.add(new EmpVO(2114, "���ü�"));
		list.add(new EmpVO(2114, "�̺���"));
		return list;
	}// selectEmp

}// class
