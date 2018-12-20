package day1120;

/**
 * @author owner continue : 반복문 내의 반복실행 코드의 수행을 건너 뛰는 일.<br>
 * 
 */
public class TestContinue {

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				continue;
			} // end if
			System.out.println("i = " + i);
		} // end for

	}// main

}// class
