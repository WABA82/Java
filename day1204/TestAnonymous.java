package day1204;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class TestAnonymous extends Frame {

	// 기본생성자
	public TestAnonymous() {
		super("Anonymous inner class 연습");
		Button btn = new Button("클릭");
		add(btn);
		setSize(300, 300);
		setVisible(true);

		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}

	public static void main(String[] args) {

		new TestAnonymous();

	}

}
