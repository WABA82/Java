package day1203;

/**
 * @author owner<br>
 *         수퍼클래스에서 정의한 메소드를 구현클래스(서브클래스)에서 무조건적으로 오버라이딩해야 한다.<br>
 *         인터페이스간의 상속에는 추상메소드를 오버라이딩 하지 않는다. 어차피 구현할 수 없기 때문에...<br>
 *
 */
public interface SuperInterface extends InterA, InterB { // 인터페이스틑 부모를 여러개 가질 수 있다.

	// 변수 X 상수만 사용할 수 있다.
	public static final int FLAGVALUE = 12;

	// 일반 메소드 X 추상메소드만 사용할 수 있다.
	// abstract 생략 가능하다.
	public abstract void method_A();

	public abstract void method_B(int i);

}
