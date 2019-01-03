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

	/* ��Ʈ�Ͻ����� ���� */
	private JButton btnConnect;
	private JRadioButton jrbtnteam1, jrbtnteam2, jrbtnteam3, jrbtnteam4;

	public MultiChatClientSelectRoomView() {
		super("�� ����");

		/* ������Ʈ ���� */
		btnConnect = new JButton("�����ϱ�");
		jrbtnteam1 = new JRadioButton("1��");
		jrbtnteam2 = new JRadioButton("2��");
		jrbtnteam3 = new JRadioButton("3��");
		jrbtnteam4 = new JRadioButton("4��");
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(jrbtnteam1);
		btnGroup.add(jrbtnteam2);
		btnGroup.add(jrbtnteam3);
		btnGroup.add(jrbtnteam4);

		/* ��ġ */
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

		/* ũ�⼳�� */
		setBounds(350, 350, 250, 200);
		setResizable(false);

		/* �̺�Ʈ ��� */
		MultiChatClientSelectRoomEvt sre = new MultiChatClientSelectRoomEvt(this);
		btnConnect.addActionListener(sre);
		jrbtnteam1.addActionListener(sre);
		jrbtnteam2.addActionListener(sre);
		jrbtnteam3.addActionListener(sre);
		jrbtnteam4.addActionListener(sre);

		/* ����ȭ */
		setVisible(true);

	}// ������

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
