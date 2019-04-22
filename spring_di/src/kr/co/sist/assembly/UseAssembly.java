package kr.co.sist.assembly;

import java.util.List;

import kr.co.sist.service.Service;
import kr.co.sist.vo.EmpVO;

/**
 * ������ Ŭ����(Assembly Ŭ����)�� ����Ͽ� ���� ��ü�� ��� ���񽺸� ����ϴ� ��.
 * 
 * @author owner
 *
 */
public class UseAssembly {

	public static void main(String[] args) {
		Assembly as = new Assembly();

		Service service = as.getBean();

		service.addEmp(new EmpVO(1234, "�׽�Ʈ"));

		System.out.println("----------------------���� ��ȸ");

		List<EmpVO> list = service.searchEmp();

		for (EmpVO emp : list) {
			System.out.println(emp.getEmpno() + " / " + emp.getEname());
		} // for each

	}// main

}// class
