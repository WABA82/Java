package day1122;

/**
 * @author owner 다형성 - 매소드의 오버로딩 : 하나의 클래스에서 같은 이름의 매소드를 만들고 사용.<br>
 *         문법)<br>
 *         같은 이름( 데이터 타입 다르게 만든다.){<br>
 *         <br>
 *         } <br>
 *
 */
public class TestOverLoad {

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 별 하나 출력
	 */
	public void printStar() {
		System.out.println("★");
	}// 필드-printStar method

	/**
	 * 입력되는 값에 따라 별을 여러개 출력하는 일
	 * 
	 * @param count 출력할 별의 갯수
	 */
	public void printStar(int count) {

		for (int i = 0; i < count; i++) {
			System.out.println("☆");
		}

	}// 필드-printStar method
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 고정일을 하는 매소드 - 구구단 3단만 출력한다.
	 */
	public void gugudan() {
		int dan = 3;
		System.out.println(dan + "단 출력");
		for (int i = 1; i < 10; i++) {
			System.out.println(dan + " X " + i + " = " + dan * i);
		}
	}

	/**
	 * 고정일을 하는 매소드 - 구구단 3단만 출력한다.
	 */
	public void gugudan(int input_value) {
		int dan = input_value;
		System.out.println(dan + "단 부터 9단까지 출력");

		if (dan < 10) {
			for (int i = dan; i < 10; i++) {
				for (int j = 1; j < 10; j++) {
					System.out.println(i + " X " + j + " = " + i * j);
				}
				System.out.println(i + " 단");
				System.out.println();
			}
		} else {
			System.out.println("2~9단 사이만 입력할 수 있습니다.");
		}
		// if 종료

	}// 매소드 종료.

	public static void main(String[] args) {

		TestOverLoad t = new TestOverLoad(); // 객체화

		t.printStar(); // 별 1개 출력
		t.printStar(5); // 별 여러개 출력

		t.gugudan(); // 한 단만 출력하는 구구단.
		t.gugudan(4); // 입력한 단을 출력하는 구구단.

	}

}
