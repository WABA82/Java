package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.w3c.dom.events.EventException;

/**
 * @author owner<br>
 *         ActionEvent를 사용한 이벤트 처리방법.<br>
 *         Is a 관계로 구현 - 디자인과 이벤트처리를 나의 클래스안에서 처리한다.<br>
 *         (값에 대한 사용이 편리합니다.)<br>
 * 
 *
 */

/* 1. 상속받기 Is a */
@SuppressWarnings("serial")
public class EventHandlingIsA extends Frame implements ActionListener {

	// 2. 컴포넌트를 선언 : 이벤트 처리할 //
	private Button button;

	/* 생성자 */
	public EventHandlingIsA() {
		super("Frame : Is a 관계로 이벤트 처리하는 방법");

		// 3. 컴포넌트 생성 //
		button = new Button("버튼입니다");

		// 4. 컴포넌트에 이벤트에 등록 //
		button.addActionListener(this); // Arguments로 입력된 객체의 오버라이딩된 메소드가 호출됩니다.

		// 5. 생성된 컴포넌트 배치 //
		Panel panel = new Panel();
		panel.add(button);
		add("Center", panel);

		// 6. 윈도컴포너트 크기 설정 //
		setBounds(100, 100, 300, 300);

		// 7. 가시화 //
		setVisible(true);
	}

	@Override /* ActionListener인터페이스 구현 오버라이딩 */
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼이 클릭되었습니다.");
		dispose();
	}

	public static void main(String[] args) {
		new EventHandlingIsA();
	}

}
