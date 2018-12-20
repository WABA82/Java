package day1210;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         컨테이너 : 컨테이너 컴포넌트와 일반 컴포넌트 저장할수 있는 컴포넌트의 사용.
 *
 */
@SuppressWarnings("serial")
public class UsePanel extends Frame {

	public UsePanel() {
		super("컨테이너 컴포넌트의 사용");
		// 1. 컴포넌트 생성
		Label lblName = new Label("이름");
		lblName.setBackground(Color.PINK);
		lblName.setForeground(Color.MAGENTA);

		TextField tfName = new TextField(20);
		Color backBlack = new Color(0x000000);
		Color foreWhite = new Color(0xFFFFFF);
		tfName.setBackground(backBlack);
		tfName.setForeground(foreWhite);

		Button btnAdd = new Button("추가");
		Button btnClose = new Button("종료");

		TextArea taDisplay = new TextArea();
		taDisplay.setFont(new Font("Dialog", Font.BOLD, 20));

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
//		add("North", tfName);
//		add("North", btnAdd);
//		add("North", btnClose);
		add("Center", taDisplay);

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

	public static void main(String[] args) {
		new UsePanel();
	}

}
