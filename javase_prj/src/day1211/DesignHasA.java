package day1211;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

/**
 * @author owner<br>
 *         Has a관계의 이벤트처리<br>
 *         장점 : 디자인과 이벤트처리 코드를 분리하여 코드의 복잡도를 낮출수 있다. 단전 :
 *
 */

@SuppressWarnings("serial") /* 위도우 컴포넌트의 프레임 클래스 상속 */
public class DesignHasA extends Frame {

	// 1. 컴포넌트 선언 //
	private Button button;

	public DesignHasA() {
		super("컴포넌트만 생성하는 클래스 입니다.");

		// 2. 컨포넌트 생성 //
		button = new Button("버튼입니다");

		// 3. 배치 //
		Panel panel = new Panel();
		panel.add(button);
		add("Center", panel);

		// 4. 이벤트등록 //

		// 5. 윈도우 크기 설정 //
		setBounds(100, 100, 400, 300);

		// 6. 가시화 //
		setVisible(true);

		// 7. 이벤트 등록
		EventHandligHasA ehha = new EventHandligHasA(this);
		System.out.println("생성된 디자인 객체 :" + this);

		// 8. 컨포넌트에 이벤트를 등록
		button.addActionListener(ehha); // 버튼에서 이벤트가 발생하면 ehha객체의 오버라이딩된 메소드에서 이벤트처리
	}

	public Button getButton() {
		return button;
	}

	public static void main(String[] args) {
		new DesignHasA();
	}

}
