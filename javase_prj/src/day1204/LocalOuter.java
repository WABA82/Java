package day1204;

/**
 * @author owner<br>
 *         지역클래스의 선언과 사용입니다.<br>
 *
 */
public class LocalOuter {

	int i;

	public LocalOuter() {
		System.out.println("바깥클래스의 생성자");
	}

	public void method(int pram_i, final int param_j) {
		int local_i = 0;
		final int local_j = 0;

		/* 지역클래스 시작 */
		class Local {
			int loc_i;

			public Local() {
				System.out.println("지역클래스의 생성자 입니다.");
			}

			public void locMethod() {
				System.out.println("지역클래스의 메소드 입니다. loc_i = " + this.loc_i);
				System.out.println("외부클래스의 인스턴스변수 i = " + i);

				// final 매개변수만 사용할 수 있지만 JDK1.7이상 부터 매개변수를 사용할 수 있게 되었다.
				System.out.println("매개변수 사용 i = " + pram_i);
				System.out.println("매개변수 사용 j = " + param_j);
				System.out.println("지역변수 local_i = " + local_i + ", local_j = " + local_j);
				
				//JDK1.8에서부터 지역변수의 출력은 가능하지만 값 할당은 불가합니다. 
//				local_i = 2018;
			}
			

		}/* 클래스 종료 */
		Local lc = new Local();
		lc.locMethod();

		System.out.println("메소드가 호출되었습니다. loc_i = " + lc.loc_i);

	}

	public static void main(String[] args) {

		LocalOuter lo = new LocalOuter();

		lo.method(12, 4);
	}
}
