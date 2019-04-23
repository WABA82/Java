package day0423;

public class TestService2 {

	private TestDAO td;// 의존성 주입 받은 객체는 인스턴스 변수로 선언한다.
	private TestDAO2 td2;// 의존성 주입 받은 객체는 인스턴스 변수로 선언한다.

	public TestService2() {
		System.out.println("기본 생성자를 사용하여 객체 생성.");
	}// 생성자

	// interface를 의존성 주입 받으면 약결합이 된다.
	public TestService2(TestDAO td, TestDAO2 td2) {
		this.td = td;
		this.td2 = td2;
		System.out.println("매개변수가 여러개인 생성자의 의존성 주입");
	}// 생성자

}// class
