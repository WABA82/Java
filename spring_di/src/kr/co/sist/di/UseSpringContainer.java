package kr.co.sist.di;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.sist.service.ServiceImpl;
import kr.co.sist.vo.EmpVO;

public class UseSpringContainer {

	public static void main(String[] args) {

		// 1. 설정파일을 사용하여 Spring Container 생성.
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/applicationContext.xml");

		// 2. Id를 사용하여 Bean(의존성 주입받은 객체)얻기.
		// ServiceImpl si = (ServiceImpl) ac.getBean("service"); // 2.5이하 버젼
		ServiceImpl si = ac.getBean("service", ServiceImpl.class); // 3.0이상 버젼부터는 캐스팅을 할 피요가 없음.

		// 3. 찾아낸 Bean을 사용하여 사용.
		si.addEmp(new EmpVO(1234, "김정윤"));

		List<EmpVO> list = si.searchEmp();
		for (EmpVO emp_vo : list) {
			System.out.println(emp_vo.getEmpno() + " / " + emp_vo.getEname());
		} // end for

	}// main

}// class
