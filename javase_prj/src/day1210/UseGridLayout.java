package day1210;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         그리드 레이아웃 : 행과 열로 구성된며, 모든 컴포넌트의 크기가 도일하다.
 *
 */
public class UseGridLayout extends Frame {

	public UseGridLayout() {
		super("그리드 레이아웃 연습");
		Button btn1 = new Button("버튼1");
		Button btn2 = new Button("버튼2");
		Button btn3 = new Button("버튼3");
		Button btn4 = new Button("버튼4");
		Button btn5 = new Button("버튼5");
		Button btn6 = new Button("버튼6");
		Button btn7 = new Button("버튼7");
		Button btn8 = new Button("버튼8");
		Button btn9 = new Button("버튼9");

		// 3. 배치관리자 설정
		setLayout(new GridLayout(3, 3));

		// 4. 배치 : 배치는 왼쪽 -> 오른쪽 순으로 배치됩니다.
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(btn6);
		add(btn7);
		add(btn8);
		add(btn9);

		// 5. 크기 설정
		setSize(300, 400);

		// 6. 가시화
		setVisible(true);

		// 종료 처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

	}

	public static void main(String[] args) {
		new UseGridLayout();
	}

}
