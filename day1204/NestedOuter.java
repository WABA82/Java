package day1204;

/**
 * @author owner<br>
 *         내부클래스를 static변수 처럼 사용할 수 있는 중첩클래스.
 *
 */
public class NestedOuter {

	int i;
	static int j = 12;

	// 기본생성자.
	public NestedOuter() {
		System.out.println("바깥클래스의 생성자");
	}

	// 바깥클래스의 인스턴스 메소드
	public void outInstMethod() {
		System.out.println("바깥 클래스의 인스턴스 메소드");
	}

	// 바깥클래스의 인스턴스 메소드
	public static void outStaticMethod() {
		System.out.println("바깥 클래스의 스태틱 메소드");
	}

	/* Nested 클래스 시작 */
	static class NestedInner {
//		인스턴스변수 - 스태틱 클래스에서는 인스턴스자원을 권장하지 않는다.
//		int in_i; 
		static int in_j;// 스태틱변수

		public void inMethod() {
			System.out.println("안쪽 클래스의 인스턴스 메소드");
		}

		public static void inStatMethod() {
			System.out.println("안쪽 클래스의 인스턴스 메소드\n");

			System.out.println("안쪽에서 바깥클래스의 자원 사용은 static만 사용할 수 있습니다. " + NestedOuter.j);

			// 바깥 클래스의 인스턴스자원 사용.
			NestedOuter no = new NestedOuter();
			no.outInstMethod();
		}

	}
	/* Nested 클래스 끝 */

	public static void main(String[] args) {

		// static 영역을 사용할 때에는 객체화없이 클래스명.변수명,
		// 클래스명.메소드명으로 사용한다.

//		NestedOuter no = new NestedOuter();
		NestedInner.inStatMethod();

	}
}
