package day1120;

/**
 * ���� for�� : �ε����� ������ ����ؾ� �ϴ� ���<br>
 * ����)<br>
 * for ( ) {<br>
 * <br>
 * for ( ) {<br>
 * ������ ����.<br>
 * }<br>
 * <br>
 * }<br>
 *
 * @author owner
 */
public class TestFor1 {

	public static void main(String[] args) {

		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 7; j++) {
				System.out.println(i + " " + j);
			} // end
			System.out.println("===========");
		} // end for

		// ������ ���
		for (int i = 2; i < 10; i++) {
			System.out.println(i + "�� ����");

			for (int j = 1; j < 10; j++) {
				System.out.println(i + " * " + j + " = " + i * j);
			} // for ����
			System.out.println(i + "�� ��");

			System.out.println();
		} // for ����

//		00
//		01 11
//		20 21 22
//		30 31 32 33

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(i + " " + j + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 0; i < 4; i++) {
			// for (���۰� ; ���� ; ������)
			for (int j = i+1; j < 5; j++) {
				System.out.println(i + " " + j + " ");
			}
			System.out.println();
		}
		
		
	}// main

}// class
