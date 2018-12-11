package day1211;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author owner<br>
 *         Adapter Ŭ������ ���Ǿ�� �ϴ� ����.
 */
@SuppressWarnings("serial")
public class UseWindowEvent extends Frame {

	public UseWindowEvent() {
		super("������ �̺�Ʈ ����");

		setBounds(100, 100, 400, 400);
		setVisible(true);

		UseWindowEvent.WindowImpl wi = this.new WindowImpl();
		addWindowListener(wi);
	}

	public class WindowImpl implements WindowListener {

		// �����츮���� �������̽��� �޼ҵ带 �������̵��� �޼ҵ�� �Դϴ�.

		@Override
		public void windowOpened(WindowEvent e) {
			System.out.println("WindowOpened");
		}

		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("WindowClosing");
			dispose();
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// ������Ŭ��¡���� dispose()�޼ҵ尡 ȣ��Ǹ� �׶� ������Ŭ����尡 ȣ��ȴ�.
			System.out.println("WindowClosed");
		}

		@Override
		public void windowIconified(WindowEvent e) {
			System.out.println("windowIconified");

		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			System.out.println("windowDeiconified");

		}

		@Override
		public void windowActivated(WindowEvent e) {
			System.out.println("windowActivated");

		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			System.out.println("windowDeactivated");

		}

	}

	public static void main(String[] args) {
		new UseWindowEvent();
	}

}
