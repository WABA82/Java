package day1211;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class UseItemLIstener2 extends Frame implements ItemListener {

	/* 컨포넌트 선언 */
	List dataList;
	Label nameLabel;
	Label ageLabel;

	public UseItemLIstener2() {

		super("아이템리스너 및 윈도우어댑터 연습");

		/* 컴포넌트 생성 */
		// 리스트
		dataList = new List();
		dataList.add("정택성/26");
		dataList.add("이재현/26");
		dataList.add("김정운/27");
		dataList.add("김정윤/30");
		dataList.add("이재찬/27");
		dataList.add("김개똥이/120");
		dataList.add("최썬더/6");
		dataList.add("이봉현최종진화물/98876");
		dataList.add("졸려용/1");
		// 라벨
		nameLabel = new Label("이름 :		");
		ageLabel = new Label("나이 :		");

		/* 패널 선언 및 생성 */
		Panel southPanel = new Panel();
		southPanel.add(nameLabel);
		southPanel.add(ageLabel);

		/* 배치 */
		add(BorderLayout.CENTER, dataList);
		add(BorderLayout.SOUTH, southPanel);
		setBounds(200, 200, 400, 300);

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

	/* 이벤트 정의 : 아이템리스너 */
	@Override
	public void itemStateChanged(ItemEvent e) {
	}

	public static void main(String[] args) {
		new UseItemLIstener2();
	}// main

}// class
