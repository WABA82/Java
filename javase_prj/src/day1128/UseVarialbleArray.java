package day1128;

/**
 * @author owner<br>
 *         행마다 열의 갯수가 다른 가변 배열
 *
 */
public class UseVarialbleArray {

	public UseVarialbleArray() {
		// 1.선언) 데이터형[][] 배열명 = null;
		int[][] vArr = null;

		// 2.생성) 배열명 = new 데이터형[*][];
		vArr = new int[4][];
		System.out.println("행의 갯수 : " + vArr.length + " - (열의 길이는 따로 정의해야 합니다.)");

		// 3.각 행의 열의 길이 정의) 배열명[행의 방번호] = new 데이터형[열의 갯수];
		vArr[0] = new int[3];
		vArr[1] = new int[4];
		vArr[2] = new int[1];
		vArr[3] = new int[] { 1, 2, 3, 4, 5, 6 }; // 초기화는 []안에 열의 수를 정의하지 않아야 할 수 있다.

		// 4.값할당) vArr[행의 방 번호][열의 방 번호] = 값;
		vArr[0][2] = 10;
		vArr[1][3] = 20;
		vArr[2][0] = 30;

		// 5.값사용)
		System.out.println(vArr[0][0] + " / " + vArr[0][1] + " / " + vArr[0][2]);

		// 6.for문 사용

		System.out.println("vArr의 방 구조 : \n");

		for (int i = 0; i < vArr.length; i++) {
			for (int j = 0; j < vArr[i].length; j++) {
				System.out.printf("vArr[%d][%d] = %-5d ", i, j, vArr[i][j]);
			}
			System.out.println();
		}

	}// 기본생성자

//////////////////////////////////////////////////////////////아래는 가변배열의 기본형 형식 사용입니다.///////////////////////////////////////////////////////

	/**
	 * 가변 배열의 기본형 형식 사용
	 */
	public void priType() {
		System.out.println(
				"--------------------------------가변배열의 기본형 형식 사용입니다.-----------------------------------------");

		// 문법) 데이터형[][] 배열명 = {{},{},{},,,,,};
		String[][] vArr = { { "딸기" }, { "포도", "참외", "수박", "복숭아" }, { "사과", "배", "감" }, { "뀰" } };
		String[] title = { "봄", "여름", "가을", "겨울" };

		for (int i = 0; i < vArr.length; i++) {
			System.out.print(title[i] + " : ");
			for (int j = 0; j < vArr[i].length; j++) {
				System.out.print(vArr[i][j] + "\t");
			}
			System.out.println();
		}

	}// priType

	public static void main(String[] args) {
		new UseVarialbleArray().priType();
	}// 메인 메소드

}// 클래스 필드
