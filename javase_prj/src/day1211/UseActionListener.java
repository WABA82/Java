package day1211;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         액션리스너를 사용한 이벤트 처리 - is a 관계로 이벤트 처리
 *
 */
@SuppressWarnings("serial")
public class UseActionListener extends Frame implements ActionListener {

	/* 인스턴스 변수(클래스 내의 어디서나 접근 가능.) 선언 */
	TextField tfName;
	TextArea taDisplay;

	public UseActionListener() {
		super("액션 이벤트의 사용");

		// 1. 컴포넌트 생성
		Label lblName = new Label("이름");
		tfName = new TextField(20);
		Button btnAdd = new Button("추가");
		Button btnClose = new Button("종료");
		taDisplay = new TextArea();

		// 컨테이너 컴포넌트 생성 : 일반컴포넌트를 담을.
		Panel panelNorth = new Panel();
		panelNorth.add(lblName);
		panelNorth.add(tfName);
		panelNorth.add(btnAdd);
		panelNorth.add(btnClose);

		// 2. 배치관리자 설정
		setLayout(new BorderLayout());

		// 3. 보더레이아웃의 특징 : 하나의 지역에 하나의 컴포넌트만 저장 가능.
		add("North", panelNorth);
		add("Center", taDisplay);

		/* 이벤트 등록 */
		btnAdd.addActionListener(this); // 버튼에서 이벤트가 등록됨
		tfName.addActionListener(this);

		// 4. 윈도우 크기설정
		setBounds(200, 100, 400, 250);

		// 5. 가시화
		setVisible(true);

		// 6. 윈도우 종료 이벤트처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/* TextField의 값을 받기. */
		String name = tfName.getText();

		if (!name.isEmpty()) { // 입력문자열이 비어있지 않다면 추가.
			/* TextArea에 추가 */
			taDisplay.append(name + "\n");
			/* TextField의 값을 초기화 */
			tfName.setText("");
		}

		/* 커서를 텍스트 필드에 재설정 */
		tfName.requestFocus();
	}

	public static void main(String[] args) {
		new UseActionListener();
	}

}
