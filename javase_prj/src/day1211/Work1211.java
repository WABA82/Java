package day1211;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/* 윈도우 컴포넌트 상속 */
public class Work1211 extends Frame implements ItemListener {

	/* 컴포넌트 선언 */
	Choice colorChoice;
	Label choicedColorLabel;

	public Work1211() {
		/* 컴포넌트 생성 */
		colorChoice = new Choice();
		colorChoice.add("검은색");
		colorChoice.add("파란색");
		colorChoice.add("빨강색");
		colorChoice.add("녹   색");
		colorChoice.add("심홍색");

		choicedColorLabel = new Label("오늘은 화요일 입니다.");

		/* 패널 생성 */
		Panel centerGridPanel = new Panel();
		centerGridPanel.setLayout(new GridLayout(1, 2));
		centerGridPanel.add(choicedColorLabel);
		centerGridPanel.add(colorChoice);

		/* 배치 */
		add(centerGridPanel);

		/* 이벤트 등록 */
		colorChoice.addItemListener(this);

		/* 크기설정 */
		setBounds(100, 100, 300, 300);

		/* 가시화 */
		setVisible(true);

		/* 종료 활성화 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	/* 이벤트 처리 */
	@Override
	public void itemStateChanged(ItemEvent e) {

		String pickedColor = colorChoice.getSelectedItem();

		Color color = Color.BLACK;

		switch (pickedColor) {
		case "검은색":
			color = Color.BLACK;
			break;
		case "파란색":
			color = Color.BLUE;
			break;
		case "빨강색":
			color = Color.RED;
			break;
		case "녹   색":
			color = Color.GREEN;
			break;
		case "심홍색":
			color = Color.MAGENTA;
			break;
		}

		choicedColorLabel.setForeground(color);
	}

	public static void main(String[] args) {
		new Work1211();
	}

}
