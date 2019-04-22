package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.dao.DAO;
import kr.co.sist.vo.EmpVO;

public class ServiceImpl implements Service {

	// ��ü ������ : �ڽ��� �ƴ� �θ��� �̸����� ��ü�� �����ϸ� ��� �ڽ��� ���� �� �ִ�.
	private DAO dao;

	// Service��ü�� ������ ó���ϴµ� �ݵ�� DAO�� ����ؾ� �Ѵ� - Service�� DAO�� �������� �ִ�.
	// (DI : Service��ü�� ����Ϸ��� DAO�� ������ ���� �޾ƾ� �Ѵ�.)
	public ServiceImpl(DAO dao) {
		this.dao = dao;
	} // ������

	@Override
	public void addEmp(EmpVO emp_vo) {

		try {
			// ���������� ó��.
			System.out.println("�߰� �۾��� ���� �������� ó��.");

			dao.insertEmp(emp_vo);

		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

	}// addEmp

	@Override
	public List<EmpVO> searchEmp() {
		System.out.println("��ȸ �۾��� ���� �������� ó��");
		List<EmpVO> list = null;
		try {
			list = dao.selectEmp();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

		return list;
	}// searchEmp

}// class
