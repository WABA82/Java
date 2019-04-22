package kr.co.sist.di;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.sist.service.ServiceImpl;
import kr.co.sist.vo.EmpVO;

public class UseSpringContainer {

	public static void main(String[] args) {

		// 1. ���������� ����Ͽ� Spring Container ����.
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/applicationContext.xml");

		// 2. Id�� ����Ͽ� Bean(������ ���Թ��� ��ü)���.
		// ServiceImpl si = (ServiceImpl) ac.getBean("service"); // 2.5���� ����
		ServiceImpl si = ac.getBean("service", ServiceImpl.class); // 3.0�̻� �������ʹ� ĳ������ �� �ǿ䰡 ����.

		// 3. ã�Ƴ� Bean�� ����Ͽ� ���.
		si.addEmp(new EmpVO(1234, "������"));

		List<EmpVO> list = si.searchEmp();
		for (EmpVO emp_vo : list) {
			System.out.println(emp_vo.getEmpno() + " / " + emp_vo.getEname());
		} // end for

	}// main

}// class
