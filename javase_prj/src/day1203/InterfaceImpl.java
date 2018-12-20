package day1203;

import org.omg.CORBA.Object;

/**
 * @author owner<br>
 *         인터페이스를 구형하는 클래스(서브클래스 이고 추상메소드를 오버라이딩하는 클래스)<br>
 *         수퍼인터페이스가 상속을 받는 상황이라면 구현클래스에서 상속관계의인터페이스 까지도 구형해야 한다.
 */
public class InterfaceImpl implements SuperInterface {

	@Override
	public void method_A() {
		System.out.println("메소드A");
	}

	@Override
	public void method_B(int i) {
		System.out.println("메소드B" + ", 매개변수 i = " + i);
	}

	@Override
	public String msgB() {
		return "오늘은 월요일 입니다.";
	}

	@Override
	public String msg() {
		return "내일은 화용일 입니다.";
	}

	public void test() {

	}

	public static void main(String[] args) {
		InterfaceImpl ii = new InterfaceImpl();

		ii.method_A();
		ii.method_B(1);
		System.out.println(ii.msg());
		System.out.println(ii.msgB());

		// is a 관계의 객체화
		// InterfaceImpl에서 오버라이딩이 되었다면 모두 사용할 수 있다.
		SuperInterface si = new InterfaceImpl();
		System.out.println(si.msg());

		InterA ia = new InterfaceImpl();
		System.out.println(ia.msg());

		InterB ib = new InterfaceImpl();
		System.out.println(ib.msgB());

	}

}
