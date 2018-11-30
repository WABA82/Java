
public class Practice {
	public static void main(String[] args) {

		int value = 0; // 1~10까지의 숫자를 저장하기 위한 변수

		for (int i = 0; i < 10; i++) { // *** i는 세로를 출력하기 위한 반복문

			value = i; // i 다음에 올 숫자들을 출력하기 위한 변수
			for (int j = i; j < 10 + i; j++) { // *** j는 가로를 출력하기 위한 반복문.
				System.out.print((j < 10) ? ++value : --value); // 전위연산은 1을 먼저 더한 후 시작한다.
																// ( j < 10 )? (value = value + 1) : (value = value - 1)
																// 같음.
			}
			System.out.println();// 줄바꿈

		} // for

		System.out.println("=================================================================");

		System.out.println("3+4 = " + (3 + 4));

	}// main
}// class
