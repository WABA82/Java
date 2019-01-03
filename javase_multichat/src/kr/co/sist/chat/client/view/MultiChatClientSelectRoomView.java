package kr.co.sist.chat.client.view;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import kr.co.sist.chat.client.evt.MultiChatClientSelectRoomEvt;

@SuppressWarnings("serial")
public class MultiChatClientSelectRoomView extends JFrame {

	/* 인트턴스변수 선언 */
	private JButton btnConnect;
	private JRadioButton jrbtnteam1, jrbtnteam2, jrbtnteam3, jrbtnteam4;

	public MultiChatClientSelectRoomView() {
		super("방 선택");

		/* 컴포넌트 생성 */
		btnConnect = new JButton("접속하기");
		jrbtnteam1 = new JRadioButton("1조");
		jrbtnteam2 = new JRadioButton("2조");
		jrbtnteam3 = new JRadioButton("3조");
		jrbtnteam4 = new JRadioButton("4조");
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(jrbtnteam1);
		btnGroup.add(jrbtnteam2);
		btnGroup.add(jrbtnteam3);
		btnGroup.add(jrbtnteam4);

		/* 배치 */
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(0, 4));
		centerPanel.add(jrbtnteam1);
		centerPanel.add(jrbtnteam2);
		centerPanel.add(jrbtnteam3);
		centerPanel.add(jrbtnteam4);

		JPanel southPanel = new JPanel();
		southPanel.add(btnConnect);
		add("Center", centerPanel);
		add("South", southPanel);

		/* 크기설정 */
		setBounds(350, 350, 250, 200);
		setResizable(false);

		/* 이벤트 등록 */
		MultiChatClientSelectRoomEvt sre = new MultiChatClientSelectRoomEvt(this);
		btnConnect.addActionListener(sre);
		jrbtnteam1.addActionListener(sre);
		jrbtnteam2.addActionListener(sre);
		jrbtnteam3.addActionListener(sre);
		jrbtnteam4.addActionListener(sre);

		/* 가시화 */
		setVisible(true);

	}// 생성자

	public JButton getBtnConnect() {
		return btnConnect;
	}

	public JRadioButton getJrbtnteam1() {
		return jrbtnteam1;
	}

	public JRadioButton getJrbtnteam2() {
		return jrbtnteam2;
	}

	public JRadioButton getJrbtnteam3() {
		return jrbtnteam3;
	}

	public JRadioButton getJrbtnteam4() {
		return jrbtnteam4;
	}

}// class
