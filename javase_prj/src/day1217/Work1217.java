package day1217;

import javax.swing.JOptionPane;

/* 
 * 1-1. ���α׷��� ���۵Ǹ� �޴� ����. j�ɼ���(inputDialog)
 * 1-2. 1�� �ְ� �Է��� ������ input Dialog�� ������ inputDialog
 * 1-3. ����� ������ List�� ����� ��� 0�̸� MessageDialog�� "�����Ͱ� �����ϴ�" ���.
 * 
 */
public class Work1217 {

	String s;

	public Work1217() {

		/* do~while �ݺ��� ��� : do���� �ڵ� �ּ� 1�� ���� */
		do {
			s = JOptionPane.showInputDialog("1 : �Է�, 2 : ���, 3 : ����");
			if (s.equals("1")) {
				JOptionPane.showInputDialog("�̸�,�ڹ�����,����Ŭ����");
			}

			/* !s.equals("3") : 3�� �ƴϴ�?-true */
		} while (!s.equals("3")); // ture :����, false : ����. //

	}

	public static void main(String[] args) {
		new Work1217();
	}

}
