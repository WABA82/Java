package day1227;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author owner<br>
 *         �����带 ����Ͽ� ���ѷ����� �ڵ带 ���ÿ� �����ϱ�
 * 
 */
@SuppressWarnings("serial")
public class UseThreadChatClient extends JFrame implements ActionListener, Runnable {

	private JTextArea jta;
	private JTextField jtf;
	JScrollPane jsp;

	private Socket client;// ������ �����ϱ� ���� ���� //
	private DataInputStream readStream;// ������ �����͸� �б� ���� ��Ʈ�� //
	private DataOutputStream writeStream;// ������ �����͸� ������ ���� ��Ʈ�� //

	private String nickName;
	private String serverNickName;// ������ ��ȭ��

	public UseThreadChatClient() {
		super(":::::::::::::ä��Ŭ���̾�Ʈ:::::::::::::");
		jta = new JTextArea();
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		jta.setBorder(new TitledBorder("��ȭ����"));
		jsp = new JScrollPane(jta);
		jtf = new JTextField();
		jtf.setBorder(new TitledBorder("��ȭ�Է�"));
		/* ��ġ */
		add("Center", jsp);
		add("South", jtf);

		/* ũ�⼳�� */
		setBounds(100, 100, 300, 400);

		/* ����ó�� : ���� ������ �͸�Ŭ������ �ۼ��Ѵ�. */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}

			@Override
			public void windowClosed(WindowEvent e) {
				try {
					close();
					System.exit(0);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		/* ����ȭ */
		setVisible(true);
		jtf.requestFocus(); // Ŀ�� ��û : ����ȭ ���Ŀ� ȣ���ؾ� �մϴ�. //

//		try {
//			connectServer();
//			/* ������ ���� Has A */
//			Thread t = new Thread(this);
//			t.start();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		/* �̺�Ʈ ��� */
		jtf.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			sendMsg();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	} // actionPerformed

	/* �������� �޼ҵ� */
	public void close() throws IOException {
		try {
			if (readStream != null) {
				readStream.close();
			}
			if (writeStream != null) {
				writeStream.close();
			}
		} finally {
			if (client != null) {
				client.close();
			}
		}

	}// close �޼ҵ�

	/* ������ �����ϰ� ������ �����ϱ�, ��ȭ�� �аų� ������ ���� ��Ʈ���� �����Ѵ�. */
	public void connectServer() throws IOException {
		nickName = JOptionPane.showInputDialog("��ȭ�� �Է�");
		// 2. ���� ���� //
		client = new Socket("211.63.89.133", 65535);
		// 4. ��Ʈ�� ����
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());
		// ������ ��ȭ�� ����
		writeStream.writeUTF(nickName);
		jta.setText("��ȭ�濡 \"" + nickName + "\"���� �����ϼ̽��ϴ�.");
		// ������ ��ȭ�� ����
		serverNickName = readStream.readUTF();
	} // connectServer

	/* ���ѷ��� �������� ���� �޼����� �д� �޼ҵ� */
	@Override
	public void run() {
		String revMsg = "";
		if (readStream != null) {
			try {
				while (true) {
					revMsg = readStream.readUTF();
					// ��ȭâ�� ����ϱ�
					jta.append("[" + serverNickName + "] : " + revMsg + "\n");
					// ��ũ�ѹ� ���� �ڵ�����
					jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				} // end while
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, serverNickName + "���� ����Ͽ����ϴ�.");
				// e.printStackTrace();
			}
		}

	} // readMsg

	/* �ۼ��� �޽����� ������ ������ */
	public void sendMsg() throws IOException {
		String sendMsg = jtf.getText().trim();
		writeStream.writeUTF(sendMsg);
		writeStream.flush();
		// �ۼ��� �޼��� ä��â�� ����ϱ�
		jta.append("[" + nickName + "]" + sendMsg + "\n");
		// TF�� ���� �ʱ�ȭ-����
		jtf.setText("");
		// ��ũ�ѹ� ���� �ڵ�����
		jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
	}// sendMsg

	public static void main(String[] args) {
//		new UseTreadChatClient();
		UseThreadChatClient scc = new UseThreadChatClient();
		try {
			scc.connectServer();
			/* ������ ���� Has A : �޼����� ���ÿ� �о�� �ϱ� ������ ������� ó�� */
			Thread t = new Thread(scc);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // main

} // class
