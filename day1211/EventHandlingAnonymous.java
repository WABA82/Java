package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author owner<br>
 *         익명클래스로 이벤트 처리 연습입니다.<br>
 *
 */

@SuppressWarnings("serial") /* 1. Frame 받기 */
public class EventHandlingAnonymous extends Frame {

	// 2. 이벤트처리에 사용할 컴포넌트 선언 //
	private Button button;

	public EventHandlingAnonymous() {
		button = new Button("버튼입니다 - 누르면 꺼집니다");

		Panel panel = new Panel();
		panel.add(button);

		add("Center", panel);

		// 5. 이벤트 등록 하기
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼클릭");
				dispose();
			}
		});

		// 6. 윈도우 크기설정
		setBounds(200, 100, 300, 300);
		// 7. 가시화
		setVisible(true);

	}

	public static void main(String[] args) {
		new EventHandlingAnonymous();
	}

}
