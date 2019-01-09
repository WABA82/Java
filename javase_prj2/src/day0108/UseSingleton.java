package day0108;

public class UseSingleton {

	public static void main(String[] args) {
		// Singleton Pattern으로 만들어진 객체 사용.
		// 생성자라 private로 만들어져 있지 때문에 클래스 외부에서 객체화가 되지 않는다.
		// Singleton s = new Singleton();

		Singleton s = Singleton.getInstance();
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();

		/* 객체의 주소가 같아야 싱글톤이다 */
		System.out.println(s);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}// main

}// class
