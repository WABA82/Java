package day1121;

/**
 * while : 시작과 끝을 모를 때 사용하는 반복문 최소 0번 수행 최대 조건까지 수행 <br>
 * 문법) while (조건) {코드 <br>
 * }
 * 
 * @author owner
 */
public class TestWhile {

	public static void main(String[] args) {

		int i = 0; // 초기값

		while (i < 10) {
			System.out.println(" i = " + i);
			i++;
		} // end while

		System.out.println("--------------------------------------------------------------------------------");

		// 단을 입력받아 2~9단 사이라면 구구단 출력

		i = Integer.parseInt(args[0]);

		if (i > 1 && i < 10) {
			int k = 1;
			while (k < 10) {
				System.out.println(i + "  X " + k + " = " + i * k);
				k++;
				i++;
			} // end while
		} // end if/////////////////////////////////////////

	}// main

}// class
