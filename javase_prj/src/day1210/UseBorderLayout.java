package day1210;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         일반컨포넌트와 LayoutManager의 사용.
 *
 */
//1. 윈도우 컴포넌트를 상속 받아야한다.상속 오브젝 - 수퍼클래스 - 서브클래스 순으로 생성된다.
@SuppressWarnings("serial")
public class UseBorderLayout extends Frame {

	public UseBorderLayout() {
		super("BorderLayout 연습"); // 타이틀 바에 메시지 작성.

		// 2. 사용할 일반 컴포넌트를 생성.
		TextField tfNorth = new TextField("North");
		Label lblEast = new Label("East");
		TextArea taCenter = new TextArea("Center");
		Label lblWest = new Label("West");

		Choice choSouth = new Choice();
		choSouth.add("South");

		// 3. 배치관리자 설정 : 윈도우 컴포넌트인 Frame, Dialog는 BorderLayout이 기본설정 된다.
		setLayout(new BorderLayout());

		// 4. 컴포넌트의 배치관리자를 사용하여 배치.
		// add("위치, 컴포넌트"); add(리터럴, 컴포넌트);
		// 문자열 상수를 사용하여 배치
		add("North", tfNorth);
		add("Center", taCenter); // 센터인 컨포넌트만 배치하면 나머지 부분은 자리가 남지 않는다.
		// Constant(Field)를 사용하여 배치
		add(BorderLayout.WEST, lblWest);
		add(BorderLayout.EAST, lblEast);
		add(BorderLayout.SOUTH, choSouth);

		// 5. 윈도우 크기 설정.
		setSize(400, 400);

		// 가시화
		setVisible(true);

		// 종료 메소드.
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
				super.windowClosing(we);
			}
		}/* 익명클래스 종료 */);
	}

	public static void main(String[] args) {
		new UseBorderLayout();
	}

}
