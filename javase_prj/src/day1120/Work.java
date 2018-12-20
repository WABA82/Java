package day1120;
/*숙제 1.
구구단 출력 (flowchart 그리고 )
2x1=2    3x1=3  4x1=4  ...            9x1=9
.
.
.
2x9=18                                     9x9=81

숙제2.
0 0
 1 0 1 1
   2 0 2 1 2 2
     3 0 3 1 3 2 3 3 */

public class Work {

	public static void main(String[] args) {

		// -------------------------------------------------------------------구구단 출력 ()
		for (int i = 1; i < 10; i++) { // 단 출력
			for (int j = 2; j < 10; j++) { // 1~9까지 출력
				System.out.print(j + " X " + i + " = " + (i * j) + "	");
			} // end for
			System.out.println();
		} // end for
			// -------------------------------------------------------------------구구단 출력 종료

		System.out.println("--------------------------------------------------------");

		// -------------------------------------------------------------------숙제2
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= i; j++) {
				if (i == 1 && j == 0) {
					System.out.print(" ");
				} else if (i == 2 && j == 0) {
					System.out.print("  ");
				} else if (i == 3 && j == 0) {
					System.out.print("   ");
				}
				System.out.print(i + " " + j + " ");
			}
			System.out.println();
		}
		// -------------------------------------------------------------------숙제2 종료

	}// main

}// class
