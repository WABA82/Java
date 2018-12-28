package kr.co.sist.chat.client.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class MultiChatClientView extends JFrame {

	private JTextArea jtaTalkDisplay;
	private JTextField jftServerlp, jtfNick, jtfTalk;
	private JButton jbtConnet, jbtCapture, jbtClose;
	private JScrollPane jspTalkDisplay;

	public MultiChatClientView() {
		super("채팅 클라이언트");
		jtaTalkDisplay = new JTextArea();

		jftServerlp = new JTextField("211.63.89.", 10);
		jtfNick = new JTextField(5);
		jtfTalk = new JTextField();
		jtfTalk.setBorder(new TitledBorder("대화"));

		jbtConnet = new JButton("접속");
		jbtCapture = new JButton("저장");
		jbtClose = new JButton("종료");

		jspTalkDisplay = new JScrollPane(jtaTalkDisplay);
		jspTalkDisplay.setBorder(new TitledBorder("대화창"));

		jtaTalkDisplay.setEditable(false);

		JPanel jpNorth = new JPanel();
		jpNorth.add(new JLabel("서버주소", JLabel.CENTER));
		jpNorth.add(jftServerlp);
		jpNorth.add(new JLabel("대화명", JLabel.CENTER));
		jpNorth.add(jtfNick);
		jpNorth.add(jbtConnet);
		jpNorth.add(jbtCapture);
		jpNorth.add(jbtClose);

		add("North", jpNorth);
		add("Center", jspTalkDisplay);
		add("South", jtfTalk);

		setBounds(100, 100, 550, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JTextArea getJtaTalkDisplay() {
		return jtaTalkDisplay;
	}

	public JTextField getJftServerlp() {
		return jftServerlp;
	}

	public JTextField getJtfNick() {
		return jtfNick;
	}

	public JTextField getJtfTalk() {
		return jtfTalk;
	}

	public JButton getJbtConnet() {
		return jbtConnet;
	}

	public JButton getJbtCapture() {
		return jbtCapture;
	}

	public JButton getJbtClose() {
		return jbtClose;
	}

	public JScrollPane getJspTalkDisplay() {
		return jspTalkDisplay;
	}
}