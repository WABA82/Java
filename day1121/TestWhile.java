package day1121;

/**
 * while : ���۰� ���� �� �� ����ϴ� �ݺ��� �ּ� 0�� ���� �ִ� ���Ǳ��� ���� <br>
 * ����) while (����) {�ڵ� <br>
 * }
 * 
 * @author owner
 */
public class TestWhile {

	public static void main(String[] args) {

		int i = 0; // �ʱⰪ

		while (i < 10) {
			System.out.println(" i = " + i);
			i++;
		} // end while

		System.out.println("--------------------------------------------------------------------------------");

		// ���� �Է¹޾� 2~9�� ���̶�� ������ ���

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
