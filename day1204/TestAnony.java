package day1204;

/**
 * @author owner<br>
 *         인터페이스가 메소드의 매개변수일때 사용하는 방법.<br>
 * 
 */
public class TestAnony {

	public void useAnonyInter(AnonyInter ai) {
		System.out.println(ai.getmsg() + " " + ai.getname());
	}

	public static void main(String[] args) {
		// 인터페이스를 정의하고 구현클래스를 만들고 is a 관계객체화를 한다.
		AnonyInter ai = new AnonyImpl();
		// TestAnony의 인스턴스자원을 사용하기 위해 객체화
		TestAnony ta = new TestAnony();

		// 인스턴스메소드 호출
		ta.useAnonyInter(ai);

		System.out.println("-----------이하는 익명클래스의 사용입니다.-----------");

		/* 익명클래스 생성 */
		ta.useAnonyInter(new AnonyInter() {

			@Override
			public String getname() {
				return "공선의" + test();
			}

			@Override
			public String getmsg() {
				return "온뇨쇼";
			}

			public String test() {
				return " 서브의 메소드";
			}

		});
		/* 익명클래스 종료 */

	}
}
