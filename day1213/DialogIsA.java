package day1213;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
/* 다이얼로그 컴포넌트 상속 받기 Is A */
public class DialogIsA extends Dialog implements ActionListener {

	/* 일반 컴포넌트 선언 */
	private Button button;

	/* 생성자 */
	public DialogIsA(UseDialogIsA uda) {
		super(uda, "다이얼로그", true);

		/* 컴포넌트 생성 */
		Label label = new Label("오늘은 목요일 입니다.");
		button = new Button("닫기");

		/* 배치하기 */
		// label 컴포넌트 배치 //
		Panel panel = new Panel();
		panel.add(label);
		add(BorderLayout.CENTER, panel);
		// button 컴포넌트 배치
		add(BorderLayout.SOUTH, button);

		/* 이벤트 등록 */
		button.addActionListener(this);

		/* 종료 이벤트 처리 : 다이얼로그컴포넌트 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		/* 크기 설정 및 가시화 */
		// 수퍼프레임을 기준으로 다이얼로그 띄우기 //
		System.out.println("부모 x좌표 : " + uda.getX() + "부모 y좌표 : " + uda.getY());
		setBounds((uda.getX() + 50), (uda.getY() + 50), 200, 200);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
