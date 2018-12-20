package day1214;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * @author owner<br>
 *         자바x.스윙 : 이미지아이콘클래스 사용입니다.<br>
 *
 */
@SuppressWarnings("serial")
/* 윈도컴포넌트 상속 받기 : Is a */
public class UseImageIcon extends JFrame {

	/* 스윙일반컴포넌트 선언 */
	ImageIcon imgicon1, imgicon2, imgicon3;
	JButton button1, button2, button3;

	public UseImageIcon() {
		super("스윙패키지의 이미지아이콘클래스 사용");

		/* 스윙일반컴포넌트 생성 */
		// 이미지아이콘 생성 //
		imgicon1 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img1.png");
		imgicon2 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img2.png");
		imgicon3 = new ImageIcon("C:/dev/workspace/javase_prj/src/day1214/images/img3.png");

		button1 = new JButton("버튼1", imgicon1);
		button2 = new JButton("버튼2", imgicon2);
		button3 = new JButton("버튼3", imgicon3);

		/* 툴립텍스트 설정 */
		button1.setToolTipText("버튼1");
		button2.setToolTipText("버튼2를 클릭하세요.");
		button3.setToolTipText("버튼3 오늘은 금요일 입니다.");

		/* 롤오버아이콘 */
		button3.setRolloverIcon(imgicon2);

		/* 버튼 라벨 위치변경 */
		// 가로 위치 //
		button1.setHorizontalTextPosition(JButton.LEFT);
		button2.setHorizontalTextPosition(JButton.CENTER);
		button3.setHorizontalTextPosition(JButton.CENTER);

		// 세로 위치 //
		button1.setVerticalTextPosition(JButton.TOP);
		button2.setVerticalTextPosition(JButton.CENTER);
		button3.setVerticalTextPosition(JButton.BOTTOM);

		button1.
				
		/* 배치 */
		setLayout(new GridLayout(1, 3));
		add(button1);
		add(button2);
		add(button3);

		/* 프레임크기설정 */
		setBounds(100, 100, 900, 400);

		/* 종료활성화 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* 가시화 */
		setVisible(true);

	}

	public static void main(String[] args) {
		new UseImageIcon();
	}// 메인 메소드
}// 클래스
