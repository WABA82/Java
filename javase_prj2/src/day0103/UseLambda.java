package day0103;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UseLambda {

	public static void main(String[] args) {
//		TestLambda tl = () -> new Date().toString(); // return ���� ����.

//		TestLambda tl = () -> {
//			return new Date().toString();
//		}; // return�� ����� ��쿡�� {}�� ����ؾ� �մϴ�.

		TestLambda tl = () -> {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return sdf.format(new Date());
		};

		System.out.println(tl.toDay());

	}// main

}// class
