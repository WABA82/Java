package day1203;

public class UseDefaultMethod implements UseDefault {

	@Override
	public void test() {
		System.out.println("오버라이딩한 메소드 입니다.");
	}

	public static void main(String[] args) {
//	서브클래스 객체화

		UseDefaultMethod udm = new UseDefaultMethod();
		udm.test();

		// default메소드
		udm.temp();

//	is a 관계의 객체화

		UseDefault ud = new UseDefaultMethod();

		ud.test();
		// default메소드
		ud.temp();
	}

}
