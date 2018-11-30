package day1121;

/**
 * @author owner 메소드 : 중복코드를 최소화 할때 사용
 */
public class UseMethod {

	// 인스턴스 메소드 : 인스턴스 변수를 사용할 때 사용.
	public void instMethod() {
		System.out.println("instance : 객체화하여 사용하는 method");
	}// instmethod

	// 스태틱 메소드 : 인스턴스 변수를 사용하지 않을 때 사용.
	public static void staticMethod() {
		System.out.println("static : 객체화 없이 직접 호출하여 사용하는 method");
	}// static Method

	public static void main(String[] args) {
		// instMethod(); -- 객체화 이후에 객체명으로 호출할 수 있다.
		
		UseMethod um = new UseMethod(); //인트턴스 메소드를 사용하기 위한 클래스의 객체화
		um.instMethod();
		
//		um.staticMethod(); -- 스태틱 메소드는 특정 객체에 속해있는 메소드가 아니므로 객체명으로 호출하지 않는다.
		UseMethod.staticMethod();
		
		
		
	}

}
