package day1219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author owner<br>
 *         사용자가 입력한 키보드의 값을 처리하는 System.in
 */
public class UseKeyboardInput {

	public UseKeyboardInput() {
//		int input;
		System.out.println("아무키나 누르고 엔터");

		/* 8bit Stream과 16bit Stream연결 */

		BufferedReader bufferedR = new BufferedReader(new InputStreamReader(System.in));

		try {
			/* 입력된 문자중 가장 첫번째 입력문자 하나만 읽기 */
//			input = System.in.read();
//			System.out.println("입력값 " + input);
//			input = 0;
//			while (true) {
//				input = System.in.read();
//				System.out.println((char) input);
//				if (input == 13) {
//					break;
//				}
//			}

			/* 16비트 스트림을 사용하여 입력데이터를 줄단위로 읽어 들인다. */
			String str = bufferedR.readLine();

			System.err.println(str);

			/* 스트림 사용이 끝났으면 스트림의 연결을 끊는다. */
			bufferedR.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UseKeyboardInput();

	}

}
