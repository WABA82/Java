package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author owner<br>
 *         Ư�� ������Ʈ�� Ư�� �̺�Ʈ�� ����Ҷ� ���. - �ȵ���̵� ���߿� ����ϴ� ��찡 ����.
 *
 */
@SuppressWarnings("serial") /* 1. ������ ������Ʈ ��� �ޱ� */
public class EventHandlingInnerClass extends Frame {

	/* 2. ������Ʈ ���� */
	private Button button;

	public EventHandlingInnerClass() {
		super("�̳�Ŭ������ ����� �̺�Ʈ ó�� ����");
		/* 3. ������Ʈ ���� */
		button = new Button("��ư�Դϴ�");

		/* 4. ��ġ */
		Panel panel = new Panel();
		panel.add(button);
		add("Center", panel);

		/* 5. �̺�Ʈ ��� */
		EventHandlingInnerClass.InnerAction iai = this.new InnerAction();
		button.addActionListener(iai);

		/* 6. ������ ũ�� ���� */
		setBounds(100, 100, 300, 300);

		/* 7. ����ȭ */
		setVisible(true);
	}

	/************* 5-1. inner Ŭ���� *************/

	/* �̳� Ŭ������ �̺�Ʈ ó�� �����ʸ� ���� */
	public class InnerAction implements ActionListener {

		@Override /* 5-2. */
		public void actionPerformed(ActionEvent e) {
			System.out.println("��ư�� Ŭ���Ͽ����ϴ�. o(>.<)o ��~~~");
			dispose();
		}
	}

	/************* inner Ŭ���� *************/

	public Button getButton() {
		return button;
	}

	/* ���� �޼ҵ� �Դϴ�. */
	public static void main(String[] args) {
		new EventHandlingInnerClass();
	}

}
