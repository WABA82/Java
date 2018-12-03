package day1203;

public class UseInstance {

	public TestSuper test1() {
		// is a 관계의 객체화 : 수퍼의 자원과 자식이 오버라이딩한 메소드를 사용할 수 있다.
		// 수퍼클래스명 객체명 = new 서브클래스생성자();
		TestSuper ts = new TestSub();
		return ts;
	}// test1

	public TestSuper test2() {
		// is a 관계의 객체화 : 수퍼의 자원과 자식이 오버라이딩한 메소드를 사용할 수 있다.
		// 수퍼클래스명 객체명 = new 서브클래스생성자();
		TestSuper ts = new TestSub2();
		return ts;
	}// test2

	// static메소드에서는 this / super를 사용할 수 없다.
	public static void main(String[] args) {

//	일반적인 객체화
		// 서브클래스를 객체로 생성하여 사용.
		// 서브클래스명 객체명 = new 서브의 생성자();
		// 객체로 사용 : 수퍼클래스 자원, 서브클래스의 자원.
		TestSub ts = new TestSub();

		// 부모와 같은 이름의 변수는 자식의 것을 사용.
		ts.i = 100;

		// 수퍼클래스의 메소드 사용.
		ts.pMethod();

		// 서브클래스의 메소드 사용.
		ts.subMethod();

		// 서브클래스에서 오버라이딩한 메소드 사용.
		ts.printI();

//	객체 다형성(is a관계) : 수퍼클래스의 이름으로 객체화 하기
		// 장점 : 수퍼클래스만 사용할 수 있으면 된다.

		UseInstance ui = new UseInstance();

		TestSuper ts1 = ui.test1();
		TestSuper ts2 = ui.test2();

		// 오버라이딩 된 메소드 호출
		ts1.printI();
		ts2.printI();

	}

}
