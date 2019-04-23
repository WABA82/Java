package day0423;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunJcf {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("day0423/applicationContext2.xml");

		System.out.println("//////////////////////// List Injection");
		JCFInjection jiList = ac.getBean("jiList", JCFInjection.class);
		System.out.println(jiList.getList());

		System.out.println("//////////////////////// Set Injection");
		JCFInjection jiSet = ac.getBean("jiSet", JCFInjection.class);
		System.out.println(jiSet.getSet());

		System.out.println("//////////////////////// VO List Injection");
		JCFInjection jiVoList = ac.getBean("jiVoList", JCFInjection.class);
		System.out.println(jiVoList.getVoList());

		System.out.println("//////////////////////// Map Injection");
		JCFInjection jiMap = ac.getBean("jiMap", JCFInjection.class);
		System.out.println(jiMap.getMap());

	}// main

}// class
