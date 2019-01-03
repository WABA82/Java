package kr.co.sist.chat.client.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import kr.co.sist.chat.client.evt.MultiChatClientEvt;

@SuppressWarnings("serial")
public class MultiChatClientView extends JFrame {

	private JTextArea jtaTalkDisplay;
	private JTextField jtfServerIp, jtfNick, jtfTalk;
	private JButton jbtConnect, jbtCapture, jbtClose, jbtOthersList;
	private JScrollPane jspTalkDisplay;
	private int slctPort;

	public MultiChatClientView(int slctPort) {
		super("ä�� Ŭ���̾�Ʈ");
		this.slctPort = slctPort;

		jtaTalkDisplay = new JTextArea();

		jtfServerIp = new JTextField("211.63.89.", 10);
		jtfNick = new JTextField(5);
		jtfTalk = new JTextField();
		jtfTalk.setBorder(new TitledBorder("��ȭ"));

		jbtConnect = new JButton("����");
		jbtCapture = new JButton("����");
		jbtClose = new JButton("����");
		jbtOthersList = new JButton("������ ���");

		jspTalkDisplay = new JScrollPane(jtaTalkDisplay);
		jspTalkDisplay.setBorder(new TitledBorder("��ȭâ"));

		jtaTalkDisplay.setEditable(false);

		JPanel jpNorth = new JPanel();
		jpNorth.add(new JLabel("�����ּ�", JLabel.CENTER));
		jpNorth.add(jtfServerIp);
		jpNorth.add(new JLabel("��ȭ��", JLabel.CENTER));
		jpNorth.add(jtfNick);
		jpNorth.add(jbtConnect);
		jpNorth.add(jbtCapture);
		jpNorth.add(jbtClose);
		jpNorth.add(jbtOthersList);

		add("North", jpNorth);
		add("Center", jspTalkDisplay);
		add("South", jtfTalk);

		MultiChatClientEvt mcce = new MultiChatClientEvt(this);
		addWindowListener(mcce);

		jbtConnect.addActionListener(mcce);
		jbtClose.addActionListener(mcce);
		jbtCapture.addActionListener(mcce);
		jtfTalk.addActionListener(mcce);

		setBounds(100, 100, 630, 400);
		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JTextArea getJtaTalkDisplay() {
		return jtaTalkDisplay;
	}

	public JTextField getJtfServerIp() {
		return jtfServerIp;
	}

	public JTextField getJtfNick() {
		return jtfNick;
	}

	public JTextField getJtfTalk() {
		return jtfTalk;
	}

	public JButton getJbtConnect() {
		return jbtConnect;
	}

	public JButton getJbtCapture() {
		return jbtCapture;
	}

	public JButton getJbtClose() {
		return jbtClose;
	}

	public JButton getJbtOthersList() {
		return jbtOthersList;
	}

	public JScrollPane getJspTalkDisplay() {
		return jspTalkDisplay;
	}

	public int getSlctPort() {
		return slctPort;
	}

}// class