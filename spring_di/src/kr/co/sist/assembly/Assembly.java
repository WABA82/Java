package kr.co.sist.assembly;

import kr.co.sist.dao.DAO;
import kr.co.sist.dao.DaoMySQLImpl;
import kr.co.sist.service.Service;
import kr.co.sist.service.ServiceImpl;

/**
 * ������ ���� ���踦 �����ϴ� ��.
 * 
 * @author ����
 *
 */
public class Assembly {

	public Service getBean() {

		// 1. ������ ������ ��ü ����. - ���⸸ ��ġ�� �ȴ�.
		// DAO dao = new DaoOracleImpl();
		DAO dao = new DaoMySQLImpl();

		// 2. ������ ���Թ��� ��ü �����ϸ鼭 ������ ����.
		Service service = new ServiceImpl(dao);

		// 3. ������ ���Թ��� ��ü ��ȯ.
		return service;
	}// getBean

}// class
