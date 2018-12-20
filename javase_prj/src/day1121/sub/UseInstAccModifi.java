package day1121.sub;

//import day1121.InstAccModifi;

/**
 * 같은 패키지에 존재하는 다른 클래스의 인스턴스변수 사용
 * 접근지정자가 public인 것만 사용가능
 * @author Owner
 */
public class UseInstAccModifi {

	public static void main(String[] args) {
		InstAccModifi ivam=new InstAccModifi();
		System.out.println("public : "+ivam.pub_i);
//		System.out.println("protected : "+ivam.pro_i);
//		System.out.println("default : "+ivam.def_i);
//		System.out.println("private : "+ivam.pri_i);
	}//main

}//class
