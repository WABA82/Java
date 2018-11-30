package day1128;

/**
 * @author owner<br>
 *         행과 열로 구성된 2차원 배열
 *
 */
public class UseArray2d {

	/**
	 * 참조형타입으로 2차원 배열 사용
	 */
	public void refType() {
		// 1.선언) 데이터형 [][] 배열명 = null;
		int[][] arr = null;

		// 2.생성) 배열명 = new 데이터형 [행의 갯수][열의 갯수];
		arr = new int[3][4];
		System.out.println("행의 수 : " + arr.length + ", 열의 수 : " + arr[0].length);

		// ++선언 + 생성)
		int[][] arr1 = new int[4][5];
		System.out.println("행의 수 : " + arr1.length + ", 열의 수 : " + arr1[0].length);

		// 3.값) 배열명 [][] = 값;
		arr[0][0] = 10;
		arr[1][1] = 20;
		arr[2][2] = 30;

		// 4.값사용) 배열명[행의 방번호][열의 방번호]
		System.out.println(arr[0][0] + " / " + arr[0][1] + " / " + arr[0][2]);

		// 모든 방의 값 구하기) 2중 for문을 사용

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("arr[%d][%d] = %-4d", i, j, arr[i][j]);
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("--------------------for ~ each 구문 사용하기----------------------");

		// 2차원 배열의 한 행을 다른 배열에 담기
		for (int[] temp : arr1) {
			// 1차원 배열의 방 구하기
			for (int val : temp) {
				System.out.print(val + "\t");
			}
			System.out.println();
		}

	}// refType

	////////////////////////////////////////////// 아래는 기본형 형식으로 작성한 2차원 배열
	////////////////////////////////////////////// 입니다.////////////////////////////////

	/**
	 * 2차원 배열
	 */
	public void priType() {
		// 행 구분 괄호에 따라 행이 생성.
		// 1.선언+값할당) 데이터형 [][] 배열명 = {{값,}{,,}{,,}};
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		System.out.println("행 : " + arr.length + ", 열 : " + arr[0].length);

		// 2.값 할당)
		arr[0][0] = 100;

		// 3.값 사용)
		System.out.println(arr[0][0] + " / " + arr[0][1]);

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("arr[%d][%d] = %-4d ", i, j, arr[i][j]);
			}
			System.out.println();
		}

	}// priType

	public static void main(String[] args) {
		UseArray2d ua2 = new UseArray2d();

		ua2.refType();
		System.out.println("---------------------------------------------------");
		ua2.priType();
	}

}
