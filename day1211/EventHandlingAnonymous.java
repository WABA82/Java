package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author owner<br>
 *         �͸�Ŭ������ �̺�Ʈ ó�� �����Դϴ�.<br>
 *
 */

@SuppressWarnings("serial") /* 1. Frame �ޱ� */
public class EventHandlingAnonymous extends Frame {

	// 2. �̺�Ʈó���� ����� ������Ʈ ���� //
	private Button button;

	public EventHandlingAnonymous() {
		button = new Button("��ư�Դϴ� - ������ �����ϴ�");

		Panel panel = new Panel();
		panel.add(button);

		add("Center", panel);

		// 5. �̺�Ʈ ��� �ϱ�
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("��ưŬ��");
				dispose();
			}
		});

		// 6. ������ ũ�⼳��
		setBounds(200, 100, 300, 300);
		// 7. ����ȭ
		setVisible(true);

	}

	public static void main(String[] args) {
		new EventHandlingAnonymous();
	}

}
