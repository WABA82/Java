package day1212;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         키보드 이벤트 처리
 */

// 1. 윈도우 컴포넌트 상속 // 
@SuppressWarnings("serial")
public class UseKeyListener extends Frame implements KeyListener {

	public static final int ENTER = 10;

	// 2. 일반 윈도우컴포넌트 생성 //
	private TextField tf;
	private Label lbl;

	/* 생성자 */
	public UseKeyListener() {

		super("키보드 이벤트 연습");
		// 3. 컴포넌트 생성 //
		tf = new TextField();
		lbl = new Label("출력창", Label.CENTER);

		// 4. 배치 //
		add(BorderLayout.NORTH, tf);
		add(BorderLayout.CENTER, lbl);

		// 5. 컴포넌트를 이벤트에 등록
		tf.addKeyListener(this);

		// 6. 윈도우 크기 및 위치 설정 //
		setBounds(100, 100, 400, 150);

		// 7. 가시화 //
		setVisible(true);

		// 8. 종료 활성화 //
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	@Override // 키가 완전히 눌린 상황 입니다. 눌린 문자만 알수 있고 키코드는 알 수 없다.
	public void keyTyped(KeyEvent ke) {
		System.out.println("키 타입드");

	}

	@Override // 키의 정확한 정보를 알수 없고, 단지 키가 눌리고 있는지만 알수 있습니다.
	public void keyPressed(KeyEvent ke) {
		System.out.println("키 프레스드");

	}

	@Override
	public void keyReleased(KeyEvent ke) {
		System.out.println("키 릴리즈드");
		// 눌린 키의 문자와 코드값을 얻어
		char inputKey = ke.getKeyChar();
		int inputCode = ke.getKeyCode(); // 키보드 코드는 키보드 키의 고유한 숫자값 : 유니코드와 다소 다릅니다.
		System.out.println(inputKey + " " + inputCode);
		// 출력 라벨에 뿌린다.
		StringBuilder output = new StringBuilder();
		output.append("눌린키 문자 : ").append(inputKey).append(", 눌린키의 키코드 : ").append(inputCode);
		lbl.setText(output.toString());

		switch (inputCode) {
		case ENTER:
			// JDK 1.7에서 발생한 버그 : TextField, TextArea는 setText("")를 바로 사용하면 초기화 되지 않는다.
			// 값을 한번 얻어낸 후
			tf.getText();
			tf.setText("");
			break;
		case KeyEvent.VK_ESCAPE:
			dispose();
		}

	}

	/* 메인메소드 입니다. */
	public static void main(String[] args) {
		new UseKeyListener();
	}

}
