package day1219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author owner<br>
 *         ����ڰ� �Է��� Ű������ ���� ó���ϴ� System.in
 */
public class UseKeyboardInput {

	public UseKeyboardInput() {
//		int input;
		System.out.println("�ƹ�Ű�� ������ ����");

		/* 8bit Stream�� 16bit Stream���� */

		BufferedReader bufferedR = new BufferedReader(new InputStreamReader(System.in));

		try {
			/* �Էµ� ������ ���� ù��° �Է¹��� �ϳ��� �б� */
//			input = System.in.read();
//			System.out.println("�Է°� " + input);
//			input = 0;
//			while (true) {
//				input = System.in.read();
//				System.out.println((char) input);
//				if (input == 13) {
//					break;
//				}
//			}

			/* 16��Ʈ ��Ʈ���� ����Ͽ� �Էµ����͸� �ٴ����� �о� ���δ�. */
			String str = bufferedR.readLine();

			System.err.println(str);

			/* ��Ʈ�� ����� �������� ��Ʈ���� ������ ���´�. */
			bufferedR.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new UseKeyboardInput();

	}

}
