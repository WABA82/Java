package day1211;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author owner<br>
 *         Adapter Ŭ������ ���Ǿ�� �ϴ� ����.
 */
@SuppressWarnings("serial")
public class UseWindowEvent2 extends Frame {

	public UseWindowEvent2() {
		super("������ �̺�Ʈ ����");

		setBounds(100, 100, 400, 400);
		setVisible(true);

		UseWindowEvent2.WindowImpl wi = this.new WindowImpl();
		addWindowListener(wi);
	}

	// ������ ����� Ŭ������ ��ӹ����� �ʿ��� �޼ҵ常 �������̵� �ϸ�ȴ�.
	public class WindowImpl extends WindowAdapter {
		// �����츮���� �������̽��� �޼ҵ带 �������̵��� �޼ҵ�� �Դϴ�.
		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("WindowClosing");
			dispose();
		}
	}

	public static void main(String[] args) {
		new UseWindowEvent2();
	}
}
