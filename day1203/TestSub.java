package day1203;

public class TestSub extends TestSuper {

	int i;

	public TestSub() {
		super();
		System.out.println("서브클래스 생성자");
	}

	public void subMethod() {
		System.out.println("서브클래스 메소드");
	}

	@Override
	public void printI() {
		System.out.println("서브클래스에서 오버라이딩한 printI메소드 : " + i + ", 수퍼클래스의 i = " + super.i);
	}

}
