package day1122;

/**
 * @author owner ������ - �żҵ��� �����ε� : �ϳ��� Ŭ�������� ���� �̸��� �żҵ带 ����� ���.<br>
 *         ����)<br>
 *         ���� �̸�( ������ Ÿ�� �ٸ��� �����.){<br>
 *         <br>
 *         } <br>
 *
 */
public class TestOverLoad {

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * �� �ϳ� ���
	 */
	public void printStar() {
		System.out.println("��");
	}// �ʵ�-printStar method

	/**
	 * �ԷµǴ� ���� ���� ���� ������ ����ϴ� ��
	 * 
	 * @param count ����� ���� ����
	 */
	public void printStar(int count) {

		for (int i = 0; i < count; i++) {
			System.out.println("��");
		}

	}// �ʵ�-printStar method
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * �������� �ϴ� �żҵ� - ������ 3�ܸ� ����Ѵ�.
	 */
	public void gugudan() {
		int dan = 3;
		System.out.println(dan + "�� ���");
		for (int i = 1; i < 10; i++) {
			System.out.println(dan + " X " + i + " = " + dan * i);
		}
	}

	/**
	 * �������� �ϴ� �żҵ� - ������ 3�ܸ� ����Ѵ�.
	 */
	public void gugudan(int input_value) {
		int dan = input_value;
		System.out.println(dan + "�� ���� 9�ܱ��� ���");

		if (dan < 10) {
			for (int i = dan; i < 10; i++) {
				for (int j = 1; j < 10; j++) {
					System.out.println(i + " X " + j + " = " + i * j);
				}
				System.out.println(i + " ��");
				System.out.println();
			}
		} else {
			System.out.println("2~9�� ���̸� �Է��� �� �ֽ��ϴ�.");
		}
		// if ����

	}// �żҵ� ����.

	public static void main(String[] args) {

		TestOverLoad t = new TestOverLoad(); // ��üȭ

		t.printStar(); // �� 1�� ���
		t.printStar(5); // �� ������ ���

		t.gugudan(); // �� �ܸ� ����ϴ� ������.
		t.gugudan(4); // �Է��� ���� ����ϴ� ������.

	}

}
