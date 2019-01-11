package day0111;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class BtnMsg extends JFrame implements ActionListener {

	private JButton[] jbtNames;
	private String[] names;
	private String[] msg;

	public BtnMsg() {
		super("이름을 클릭해주세요.");

		names = new String[] { "김정윤", "박영민", "노진경", "김희철", "김정운", "이재찬", "이재현", "공선의", "김건하", "오영근" };
		msg = new String[] { "서울은 춥다.", "각자해보세요.", "담배피러가자", "집에 가고 싶다.", "재찬이가 좋아요.", "조퇴하고 싶다.", "형! 제가 캐리할께요.",
				"수영하고 싶다.", "점심먹으러 가자", "주말에 공부하세요." };
		jbtNames = new JButton[10];

		for (int i = 0; i < jbtNames.length; i++) {
			jbtNames[i] = new JButton(names[i]);
			jbtNames[i].addActionListener(this);
			add(jbtNames[i]);
		} // end for i

		setLayout(new GridLayout(5, 2));

//		for (int i = 0; i < jbtNames.length; i++) {
//			add(jbtNames[i]);
//		} // end for i

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 200, 400);
		setVisible(true);
	}// 기본생성자

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < jbtNames.length; i++) {
			if (e.getSource() == jbtNames[i]) {
				JOptionPane.showMessageDialog(this, msg[i]);
				break;
			} // end if
		} // end for

	}// actionPerformed

	public static void main(String[] args) {
		new BtnMsg();
	}// main

}// class
