package day1119;

/**
 *if ~ else : ���� �ϳ��� �ڵ带 �����ؾ��� �� ���<br>
 *����) <br>
 *		if (���ǽ�) { <br>
 *			���ǿ� ���� �� ������ �����;
 *		}	else if { <br>
 *			���ǿ� ���� ���� �� ������ �����;
 *		}
 *
 * @author owner
 */
public class TestIfElse {

	public static void main(String[] args) {
		int i = -11;

		// ������ �����ϴ� ���� �������� , ��������� �Ǵ��ϴ�
		System.out.print(i + "��(��) ");
		if (i < 0) {
			System.out.println("����");
		} else {
			System.out.println("���");
		}

		// ������ �����ϴ� ���� Ȧ������ , ¦�������� �Ǵ��ϴ�
		if ((i % 2) == 0) {
			System.out.println("¦��");
		} else {
			System.out.println("Ȧ��");
		}
		
		// i%2 == 1 �� �� ���� i�� ������ ��� == -1�� �� �ؾ� �Ѵ�.
		if ((i % 2) == 1 || (i % 2) == -1 ) {
			System.out.println("Ȧ��");
		} else {
			System.out.println("¦��");
		}

		// �Է��� ���� 3�� ������ "¦"�� ����ϰ� �׷��� �ʴٸ� �Է��� ���� ��� �ϼ���.
		int i_value = Integer.parseInt(args[0]);

		if ((i_value % 3) == 0) {
			System.out.println("¦");
		} else {
			System.out.println(i_value);
		}

	}// main
}// class
