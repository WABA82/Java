package day1213;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         프레임 클래스에서 다이얼로그클래스를 has a 관계로 사용
 */
@SuppressWarnings("serial")
/* 상속받기 */
public class UseDialogHasA extends Frame implements ActionListener {

	private Button btn1;// Frame에 배치
	private Button btn2;// 다이얼로그용에 배치
	/* 다이얼로그 선언 : 인스턴스변수 선언해야 액션펴폼드메소드를 사용할 수 있다. */
	Dialog dialog;

	/* 생성자 */
	public UseDialogHasA() {
		super("다이얼로그 만들고 사용하기");

		/* 일반 컴포넌트 생성 */
		btn1 = new Button("다이얼로그 사용 ");

		/* 배치 */
		Panel panel = new Panel();
		panel.add(btn1);
		add(panel);

		/* 이벤트등록 : btn1을 클릭하면 다이얼로그 창이 띄워진다. */
		btn1.addActionListener(this);

		/* 크기 설정 */
		setBounds(100, 100, 300, 400);

		/* 종료 이벤트 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		/* 가시화 */
		setVisible(true);

	}

	@Override
	/* ActionListener의 메소드 : */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			creatDialog();
		}
		if (e.getSource() == btn2) {
			dialog.dispose();
		}
	}

	public void creatDialog() {
		/* 생성 */
		dialog = new Dialog(this, "다이얼로그", true);

		/* Dialog에 배치될 컴포넌트 생성 */
		Label lbl = new Label("오늘은 눈오는 목요일 입니다.");
		btn2 = new Button("닫기");

		dialog.add(BorderLayout.CENTER, lbl);
		dialog.add(BorderLayout.SOUTH, btn2);

		/* 이벤트 등록 */
		btn2.addActionListener(this);

		/* 크기 설정 */
		dialog.setBounds(200, 200, 300, 300);

		/* 종료 이벤트 : 반드시 가시화 위에 위치헤야 한다. */
		dialog.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dialog.dispose(); // 다이얼로그만 종료 되도록 객체를 명시해 준다.
			}
		});

		/* 가시화 */
		dialog.setVisible(true);

	}

	public static void main(String[] args) {
		new UseDialogHasA();
	}

}
