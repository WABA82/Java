package day1127;

/**
 * @author owner <br>
 *         1차원 배열 : 행하나에 열로만 구성된 배열<br>
 *         배열 - 메모리에 동일데이터형으로 나열된 데이터형<br>
 *         참조형 데이터타입, 고정길이 형 <br>
 *         일괄처리시 사용<br>
 *         방의 수 얻기 (배열명.length)
 */
public class UseArray1d {

	public UseArray1d() {
		// 1. 배열 선언) 데이터형[] 배열명 = null;
		int[] arr = null;
		// 2. 배열 생성) 배열명 = new 데이터형[방의갯수];
		arr = new int[6];
		// 선언과 생성) 데이터형[] 배열명 = new 데이터형[방의 갯수];
		int[] arr1 = new int[8];
		System.out.println(arr + " / " + arr1);

		System.out.println("arr 배열의 방의 갯수 : " + arr.length);
		System.out.println("arr1 배열의 방의 갯수 : " + arr1.length);

		// 3.값할당) 배열명[방의 인덱스] = 값;
		arr[0] = 11;
		arr[1] = 27;
		arr[2] = 14;
		arr[3] = 46;
		System.out.printf("arr[0] = %d, arr[1] = %d, arr[2] = %d\n", arr[0], arr[1], arr[2]);
		//
		System.out.println("arr[5] = " + arr[5]);

		// 일괄처리
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d] = %d \n", i, arr[i]);
		}

	}// 기본생성자

	/**
	 * 1차원 배열의 기본형 형식의 사용.
	 */
	public void arrayPrimitive() {
		System.out.println("-----------------------기본형 혁식---------------------------");

		// 1. 선언) 데이터형[] 배열명 = {값,,,,,,,,,};
		int[] arr = { 2018, 11, 27, 15, 20 };
		System.out.println("방의 갯수 : " + arr.length);
		int[] arr1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("arr1의 방의 수 : " + arr1.length);

		// 2. 값 할당)
		arr[0] = 2019;
		System.out.println(arr[0] + " / " + arr[1]);
		
		//배열 값 꺼내기
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.println("arr[" + i + "] = " + arr[i] + " ");
		}
		
		//향상된 for : for(배열방의 값을 저장한 변수 : 배열) { };
		// for ()
		
		for(int value : arr1) {
			System.out.println(value);
		}
		System.out.println("-----------------");
		
		//arr1배열의 마지막 방부터 처음 방까지 출력
		for (int i = arr1.length-1 ; i > -1 ; i--) {
			System.out.println(arr1[i]);
		}
		
	}// 메소드

	public static void main(String[] args) {
		new UseArray1d().arrayPrimitive();

	}// 메인메소드

}// 클래스 필드
