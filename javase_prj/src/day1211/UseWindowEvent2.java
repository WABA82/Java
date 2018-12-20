package day1211;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author owner<br>
 *         Adapter 클래스가 사용되어야 하는 이유.
 */
@SuppressWarnings("serial")
public class UseWindowEvent2 extends Frame {

	public UseWindowEvent2() {
		super("윈도우 이벤트 연습");

		setBounds(100, 100, 400, 400);
		setVisible(true);

		UseWindowEvent2.WindowImpl wi = this.new WindowImpl();
		addWindowListener(wi);
	}

	// 윈도우 어댑터 클래스를 상속받으면 필요한 메소드만 오버라이딩 하면된다.
	public class WindowImpl extends WindowAdapter {
		// 윈도우리스너 인터페이스의 메소드를 오버라이딩한 메소드들 입니다.
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
