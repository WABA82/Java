package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

/**
 * @author owner<br>
 *         Has a������ �̺�Ʈó��<br>
 *         ���� : �����ΰ� �̺�Ʈó�� �ڵ带 �и��Ͽ� �ڵ��� ���⵵�� ����� �ִ�. ���� :
 *
 */

@SuppressWarnings("serial") /* ������ ������Ʈ�� ������ Ŭ���� ��� */
public class DesignHasA extends Frame {

	// 1. ������Ʈ ���� //
	private Button button;

	public DesignHasA() {
		super("������Ʈ�� �����ϴ� Ŭ���� �Դϴ�.");

		// 2. ������Ʈ ���� //
		button = new Button("��ư�Դϴ�");

		// 3. ��ġ //
		Panel panel = new Panel();
		panel.add(button);
		add("Center", panel);

		// 4. �̺�Ʈ��� //

		// 5. ������ ũ�� ���� //
		setBounds(100, 100, 400, 300);

		// 6. ����ȭ //
		setVisible(true);

		// 7. �̺�Ʈ ���
		EventHandligHasA ehha = new EventHandligHasA(this);
		System.out.println("������ ������ ��ü :" + this);

		// 8. ������Ʈ�� �̺�Ʈ�� ���
		button.addActionListener(ehha); // ��ư���� �̺�Ʈ�� �߻��ϸ� ehha��ü�� �������̵��� �޼ҵ忡�� �̺�Ʈó��
	}

	public Button getButton() {
		return button;
	}

	public static void main(String[] args) {
		new DesignHasA();
	}

}
