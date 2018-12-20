package day1211;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author owner<br>
 *         Adapter 클래스가 사용되어야 하는 이유.
 */
@SuppressWarnings("serial")
public class UseWindowEvent extends Frame {

	public UseWindowEvent() {
		super("윈도우 이벤트 연습");

		setBounds(100, 100, 400, 400);
		setVisible(true);

		UseWindowEvent.WindowImpl wi = this.new WindowImpl();
		addWindowListener(wi);
	}

	public class WindowImpl implements WindowListener {

		// 윈도우리스너 인터페이스의 메소드를 오버라이딩한 메소드들 입니다.

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
			// 윈도우클로징에서 dispose()메소드가 호출되면 그때 윈도우클로즈드가 호출된다.
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
