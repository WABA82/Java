package day1206;

import java.util.Stack;

/**
 * @author owner<br>
 *         Stack : LIFO(last input first output)�� ������ Ŭ����.
 */
public class UseStack {

	public UseStack() {

		// Stack����
		Stack<String> stk = new Stack<String>();

		// �� �Ҵ�)
		// �θ�Ŭ������ �����ϴ� �޼ҵ�� ������ �������� ��ĥ�� �ֱ� ������ ������� �ʴ´�.
		stk.add("����Ŭ������ �޼ҵ� add�� ���");
		stk.push("�ϼ̽��ϴ�.");
		stk.push("����");
		stk.push("���õ�");
		System.out.println(stk);

		for (int i = 0; i < stk.size(); i++) {
			System.out.println(stk.get(i));
		}

		// ������ Ȯ��
		System.out.println("ũ�� : " + stk.size());

		// �� ���)
		// ���ÿ��� �����͸� ������ ���������� �� �����͸� ����� �� �����ϴ�.
		while (!stk.empty()) {
			System.out.println(stk.pop());
		}
	}

	public static void main(String[] args) {
		new UseStack();
	}

}
