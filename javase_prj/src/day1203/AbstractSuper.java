package day1203;

/**
 * @author owner<br>
 *         상속을 목적으로 만드는 수퍼클래스-객체화가 되지 않는다.<br>
 *         자식클래스가 반드시 구현해야할 추상메소드를 가진다.<br>
 */
public abstract class AbstractSuper {

	int i;

	public AbstractSuper() {
		// 자식클래스가 생성될 때만 호출된다.
		System.out.println("AbstractSuper 수퍼클래스 생성자 입니다.");
	}

	public void method() {
		System.out.println("수퍼클래스의 일을 하는 일반 메소드");
	}

	// 추상 메소드 상속 받은 서브클래스에서 무조건 구현(오버라이딩)해야 되는 목록의 정의
	public abstract void absMethod();

	public abstract String absMethod1(int i);

//	public static void main(String[] args) {
//		new AbstractSuper();
//	}// 메인 메소드
}// 추상클래스 필드
