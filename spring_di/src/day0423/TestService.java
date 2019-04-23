package day0423;

public class TestService {

	private TestDAO td;// 의존성 주입 받은 객체는 인스턴스 변수로 선언한다.

	public TestService() {
		System.out.println("기본 생성자를 사용하여 객체 생성.");
	}// 생성자

	// interface를 의존성 주입 받으면 약결합이 된다.
	public TestService(TestDAO td) {
		this.td = td;
		System.out.println("생성자 의존성 주입");
	}// 생성자

	/* method 의존성 주입 */

	// method 의존성 주입 : 반드시 기본생성자가 존재해야 한다.
	public void setTd(TestDAO td) {
		this.td = td;
	}// setTd

	// method 의존성 주입 : 반드시 기본생성자가 존재해야 한다.
	public TestDAO getTd() {
		return td;
	}// setTd

}// class
