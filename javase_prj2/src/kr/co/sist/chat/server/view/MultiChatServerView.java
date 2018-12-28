package kr.co.sist.chat.server.view;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * @author owner<br>
 *         서버 뷰 : 채팅방 관리자 화면
 */
@SuppressWarnings("serial")
public class MultiChatServerView extends JFrame {

	/* 인스턴스변수 */
	private JList<String> jlChatList;
	private JScrollPane jspList;
	private JButton jbtOpenServer, jbtCloseServer;
	private DefaultListModel<String> dlmChatList;

	public MultiChatServerView() {
		super("::::::::::::::채팅방관리자::::::::::::::");
		dlmChatList = new DefaultListModel<>();
		jlChatList = new JList<String>();

		jspList = new JScrollPane(jlChatList);

		jbtOpenServer = new JButton("서버시작");
		jbtCloseServer = new JButton("서버중지");

		JPanel btnPanel = new JPanel();
		btnPanel.add(jbtOpenServer);
		btnPanel.add(jbtCloseServer);

		jspList.setBorder(new TitledBorder("접속자 정보"));

		add("Center", jspList);
		add("South", btnPanel);

		setBounds(100, 100, 300, 650);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JList<String> getJlChatList() {
		return jlChatList;
	}

	public JScrollPane getJspList() {
		return jspList;
	}

	public JButton getJbtOpenServer() {
		return jbtOpenServer;
	}

	public JButton getJbtCloseServer() {
		return jbtCloseServer;
	}

	public DefaultListModel<String> getDlmChatList() {
		return dlmChatList;
	}
}
