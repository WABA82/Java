package kr.co.sist.service;

import java.sql.SQLException;
import java.util.List;

import kr.co.sist.dao.DAO;
import kr.co.sist.vo.EmpVO;

public class ServiceImpl implements Service {

	// 객체 다형성 : 자식이 아닌 부모의 이름으로 객체를 저장하면 모든 자식을 받을 수 있다.
	private DAO dao;

	// Service객체는 업무를 처리하는데 반드시 DAO를 사용해야 한다 - Service는 DAO에 의존성이 있다.
	// (DI : Service객체를 사용하려면 DAO를 의존성 주입 받아야 한다.)
	public ServiceImpl(DAO dao) {
		this.dao = dao;
	} // 생성자

	@Override
	public void addEmp(EmpVO emp_vo) {

		try {
			// 업무로직을 처리.
			System.out.println("추가 작업에 대한 업무로직 처리.");

			dao.insertEmp(emp_vo);

		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

	}// addEmp

	@Override
	public List<EmpVO> searchEmp() {
		System.out.println("조회 작업에 대한 업무로직 처리");
		List<EmpVO> list = null;
		try {
			list = dao.selectEmp();
		} catch (SQLException e) {
			e.printStackTrace();
		} // end catch

		return list;
	}// searchEmp

}// class
