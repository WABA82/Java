package day1210;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         컴포넌트 수동배치 : 컴포넌트 클래스의 set메소드 사용.
 *
 */

@SuppressWarnings("serial")
public class UseManualLayout extends Frame {

	public UseManualLayout() {
		super("수동배치 연습");

		// 1. 컴포넌트 생성
		Label lbl = new Label();
		lbl.setText("라벨");
		TextField tf = new TextField();
		Button btn = new Button("클릭");
		// 2. 기본 배치관리자 해제
		setLayout(null);
		// 3. 배치
		lbl.setLocation(10, 25);
		lbl.setSize(80, 50);
		tf.setBounds(50, 100, 120, 25);
		btn.setBounds(250, 200, 120, 23);
		add(lbl); // Frame에 배치
		add(tf);
		add(btn);
		// 4. 윈도우 좌표 설정
		setLocation(100, 200);
		// 5. 윈도우 크기 설정
		setSize(500, 600);
		// (4+5).
		setBounds(200, 100, 400, 250);
		setResizable(false); // 사이즈 고정.
		// 6. 가시화
		setVisible(true);
		// 7. 종료버튼 활성화
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		new UseManualLayout();
	}

}
