package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.w3c.dom.events.EventException;

/**
 * @author owner<br>
 *         ActionEvent�� ����� �̺�Ʈ ó�����.<br>
 *         Is a ����� ���� - �����ΰ� �̺�Ʈó���� ���� Ŭ�����ȿ��� ó���Ѵ�.<br>
 *         (���� ���� ����� ���մϴ�.)<br>
 * 
 *
 */

/* 1. ��ӹޱ� Is a */
@SuppressWarnings("serial")
public class EventHandlingIsA extends Frame implements ActionListener {

	// 2. ������Ʈ�� ���� : �̺�Ʈ ó���� //
	private Button button;

	/* ������ */
	public EventHandlingIsA() {
		super("Frame : Is a ����� �̺�Ʈ ó���ϴ� ���");

		// 3. ������Ʈ ���� //
		button = new Button("��ư�Դϴ�");

		// 4. ������Ʈ�� �̺�Ʈ�� ��� //
		button.addActionListener(this); // Arguments�� �Էµ� ��ü�� �������̵��� �޼ҵ尡 ȣ��˴ϴ�.

		// 5. ������ ������Ʈ ��ġ //
		Panel panel = new Panel();
		panel.add(button);
		add("Center", panel);

		// 6. ����������Ʈ ũ�� ���� //
		setBounds(100, 100, 300, 300);

		// 7. ����ȭ //
		setVisible(true);
	}

	@Override /* ActionListener�������̽� ���� �������̵� */
	public void actionPerformed(ActionEvent e) {
		System.out.println("��ư�� Ŭ���Ǿ����ϴ�.");
		dispose();
	}

	public static void main(String[] args) {
		new EventHandlingIsA();
	}

}
