package day1203;

/**
 * @author owner<br>
 *         추상클래스를 상속받아 추상메소드를 구현하는 서브클래스
 */
public class AbstractSub extends AbstractSuper {

	public void subMethod() {
		System.out.println("서브 메소드!!!!!!!");
	}

	@Override
	public void absMethod() {
		// 추상 메소드는 슈퍼로 호출할 수 없다.
		System.out.println("오버라이딩한 서브클래스의 메소드");
	}

	@Override
	// 접근 지정자(확작되는 형으로) 반환형, 이름, 매개변수는 같아야 한다.
	public String absMethod1(int i) {
		return String.valueOf(i).concat("- 서브");
	}

	public static void main(String[] args) {
		// 자식클래스가 객체화 되면 추상클래스는 객체화가 된다.
		AbstractSub as = new AbstractSub();
		// 자식클래스로 객체화 : 부모의 변수, ,method, 자식의 변수 method
		as.i = 12;
		// 수퍼클래스의 일반 메소드.
		as.method();

		// 오버라이딩한 서브클래스의 메소드.
		as.absMethod();
		System.out.println(as.absMethod1(3));
		as.subMethod();

		// is a 관계의 객체화 : 객체다형성
		// 수퍼클래스명 객체명 = new 서브클래스생성자();
		AbstractSuper as1 = new AbstractSub();

		// 수퍼의 자원 사용 가능
		as1.i = 100;
		as1.method();

		// 서브에서 오버라이딩된 메소드가 있으면 서브의 오버라이딩된 메소드 사용.
		as1.absMethod();
		System.out.println(as1.absMethod1(2018));
		
		//is a 관계로 객체화 하면 자식이 가진 메소드는 호출 불가
	}

}
