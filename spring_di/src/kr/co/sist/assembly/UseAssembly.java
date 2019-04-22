package kr.co.sist.assembly;

import java.util.List;

import kr.co.sist.service.Service;
import kr.co.sist.vo.EmpVO;

/**
 * 조립자 클래스(Assembly 클래스)를 사용하여 서비스 객체를 얻고 서비스를 사용하는 일.
 * 
 * @author owner
 *
 */
public class UseAssembly {

	public static void main(String[] args) {
		Assembly as = new Assembly();

		Service service = as.getBean();

		service.addEmp(new EmpVO(1234, "테스트"));

		System.out.println("----------------------이하 조회");

		List<EmpVO> list = service.searchEmp();

		for (EmpVO emp : list) {
			System.out.println(emp.getEmpno() + " / " + emp.getEname());
		} // for each

	}// main

}// class
