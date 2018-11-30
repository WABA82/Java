package day1120;

/**
 * 다중 for문 : 인덱스를 여러개 사용해야 하는 경우<br>
 * 문법)<br>
 * for ( ) {<br>
 * <br>
 * for ( ) {<br>
 * 수행할 문장.<br>
 * }<br>
 * <br>
 * }<br>
 *
 * @author owner
 */
public class TestFor1 {

	public static void main(String[] args) {

		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 7; j++) {
				System.out.println(i + " " + j);
			} // end
			System.out.println("===========");
		} // end for

		// 구구단 출력
		for (int i = 2; i < 10; i++) {
			System.out.println(i + "단 시작");

			for (int j = 1; j < 10; j++) {
				System.out.println(i + " * " + j + " = " + i * j);
			} // for 종료
			System.out.println(i + "단 끝");

			System.out.println();
		} // for 종료

//		00
//		01 11
//		20 21 22
//		30 31 32 33

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(i + " " + j + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 0; i < 4; i++) {
			// for (시작값 ; 끝값 ; 증가식)
			for (int j = i+1; j < 5; j++) {
				System.out.println(i + " " + j + " ");
			}
			System.out.println();
		}
		
		
	}// main

}// class
