package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author owner<br>
 *         특정 컴포넌트에 특정 이벤트를 등록할때 사용. - 안드로이드 개발에 사용하는 경우가 많다.
 *
 */
@SuppressWarnings("serial") /* 1. 윈도우 컴포넌트 상속 받기 */
public class EventHandlingInnerClass extends Frame {

	/* 2. 컴포넌트 선언 */
	private Button button;

	public EventHandlingInnerClass() {
		super("이너클래스를 사용한 이벤트 처리 연습");
		/* 3. 컴포넌트 생성 */
		button = new Button("버튼입니다");

		/* 4. 배치 */
		Panel panel = new Panel();
		panel.add(button);
		add("Center", panel);

		/* 5. 이벤트 등록 */
		EventHandlingInnerClass.InnerAction iai = this.new InnerAction();
		button.addActionListener(iai);

		/* 6. 윈도우 크기 설정 */
		setBounds(100, 100, 300, 300);

		/* 7. 가시화 */
		setVisible(true);
	}

	/************* 5-1. inner 클래스 *************/

	/* 이너 클래스로 이벤트 처리 리스너를 구현 */
	public class InnerAction implements ActionListener {

		@Override /* 5-2. */
		public void actionPerformed(ActionEvent e) {
			System.out.println("버튼을 클릭하였습니다. o(>.<)o 꺄~~~");
			dispose();
		}
	}

	/************* inner 클래스 *************/

	public Button getButton() {
		return button;
	}

	/* 메인 메소드 입니다. */
	public static void main(String[] args) {
		new EventHandlingInnerClass();
	}

}
