package kr.co.sist.assembly;

import kr.co.sist.dao.DAO;
import kr.co.sist.dao.DaoMySQLImpl;
import kr.co.sist.service.Service;
import kr.co.sist.service.ServiceImpl;

/**
 * 의존성 주입 관계를 설정하는 일.
 * 
 * @author 재현
 *
 */
public class Assembly {

	public Service getBean() {

		// 1. 의존성 주입할 객체 생성. - 여기만 고치면 된다.
		// DAO dao = new DaoOracleImpl();
		DAO dao = new DaoMySQLImpl();

		// 2. 의존성 주입받을 객체 생성하면서 의존성 주입.
		Service service = new ServiceImpl(dao);

		// 3. 의존성 주입받은 객체 반환.
		return service;
	}// getBean

}// class
