package day1129;

/**
 * @author owner<br>
 *         면행열로 구성된 배열<br>
 *
 */
public class UseArray3 {

	public UseArray3() {
		// 3차원 배열 참조형 형식의 사용.

		// 1.선언) : 데이터형 [][][] 배열명 = null;
		int[][][] arr = null;

		// 2.생성) : 배열명 = new 데이터형[][][];
		arr = new int[2][3][4];
		// 선언+생성) 데이터형[][][] 배열명 = new 데이터형[면][행][열];
		int[][][] arr1 = new int[3][4][5];

		// 3.할당) 배열명[면의 방 번호][행의 방 번호][열의 방 번호] = 값;
		arr[0][0][0] = 10;
		arr[1][2][3] = 1000;

		// 4.사용) 배열명[면의 방 번호][행의 방 번호][열의 방 번호];
		System.out.println(arr[0][0][0] + ", " + arr[0][0][1] + ", " + arr[0][0][2]);

		// 4-1.각 방의 수) .length
		System.out.println(
				"arr배열의 면의 수 : " + arr.length + 
				", arr배열의 행의 수 : " + arr[0].length + 
				", arr배열의 열의 수 : " + arr[0][0].length
		);

		// 5.모든 방 출력)
		for (int i = 0; i < arr.length; i++) { // i면 시작
			System.out.println(i + "면 시작");

			for (int j = 0; j < arr[i].length; j++) {
				System.out.println(i + " 면 " + j + " 행 시작");

				for (int k = 0; k < arr[i][j].length; k++) {
					System.out.print(arr[i][j][k] + "\t");
				} // end for [k]
				System.out.println();

			} // end for [j]
			System.out.println();

		} // end for [i];
		
		// for~each문 사용)
		for (int[][] arr2 : arr1) { // 3차원 배열의 한 면은 2차원 배열로 이루어져 있다.
			for (int[] arr0 : arr2) { // 2차원 배열의 한 행은 1차원 배열로 이루어져 있다.
				for (int val : arr0) {
					System.out.print(val + "\t");
				}
				System.out.println();
			}
		System.out.println();
		}
		
	}

	public void priType() {
		// 기본형 형식으로 3차원 배열선언.
		// 데이터형[][][] 배열명 = { {{값,,},{값,}} , {[값,,},{}} };
		int[][][] arr = {
				{{1,2,3},{4,5,6}}/*0면*/,
				{{7,8,9},{10,11,12}}/*1면*/
		};
		System.out.println("면의 수 : " + arr.length + ", 행의 수 : " + arr[0].length + ", 열의 수 : " + arr[0][0].length + "\n");
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				for (int k = 0; k < arr[i][j].length; k++) {
					System.out.print(arr[i][j][k] + "\t");
				}
			System.out.println();
			}
		System.out.println();
		}
		
	}//priType 메소드 종료
	
	public static void main(String[] args) {
		new UseArray3().priType();
	}// 메인 메소드

}// 클래스 필드
