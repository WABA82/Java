package day1205;

import java.util.StringTokenizer;

/**
 * @author owner<br>
 *         ���ڿ��� Ư�����ڷ� �����ϴ� StringTokenizer�� ���.
 */
public class UseStringTokenizer {

	public UseStringTokenizer() {
		System.out.println("�⺻ ������ �Դϴ�.");

		// �������� ���� : �Ű����� 1�� ������ ���.
		String msg = "������ ������ �Դϴ�. ������ -5���Դϴ�.";
		StringTokenizer stk = new StringTokenizer(msg);
		System.out.println(stk.countTokens() + "��");

		/* while �ݺ����� ����Ͽ� ��ū���� ���� �� �ִ�. */
		while (stk.hasMoreTokens()) { // ��ū�� �����ϴ���? boolean
			System.out.println(stk.nextToken()); // ��ū�� ��� �����͸� �������� �̵�
		}

		System.out.println("\n/*******************************/\n"); // ���м�

		// Ư�����ڷ� ���� : �Ű������� 2���� ������ ���.
		String names = "������,������~���ü�,����ö.������~������,������";
		StringTokenizer stk1 = new StringTokenizer(names, ",");
		System.out.println(stk1.countTokens() + "��");

		/* while �ݺ����� ����Ͽ� ��ū���� ���� �� �ִ�. */
		while (stk1.hasMoreTokens()) { // ��ȯ�� boolean
			System.out.println(stk1.nextToken()); // ��ū�� ��� �����͸� �������� �̵�
		}

		System.out.println("\n/*******************************/\n"); // ���м�

		// �����ϴ� ���ڵ� ��ū���� ����� : �Ű����� 3���� ������ ���.
		StringTokenizer stk2 = new StringTokenizer(names, ",.~", false);
		System.out.println(stk2.countTokens() + "��");

		/* while �ݺ����� ����Ͽ� ��ū���� ���� �� �ִ�. */
		while (stk2.hasMoreTokens()) {
			System.out.println(stk2.nextToken());
		}

	}

	public static void main(String[] args) {

		new UseStringTokenizer();

	}

}
