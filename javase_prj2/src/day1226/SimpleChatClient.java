package day1226;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author owner<br>
 * 
 */
@SuppressWarnings("serial")
public class SimpleChatClient extends JFrame implements ActionListener {

	private JTextArea jta;
	private JTextField jtf;

	private Socket client;// ������ �����ϱ� ���� ���� //
	private DataInputStream readStream;// ������ �����͸� �б� ���� ��Ʈ�� //
	private DataOutputStream writeStream;// ������ �����͸� ������ ���� ��Ʈ�� //

	public SimpleChatClient() {
		super(":::::::::::::ä��Ŭ���̾�Ʈ:::::::::::::");
		jta = new JTextArea();
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		jta.setBorder(new TitledBorder("��ȭ����"));
		JScrollPane jsp = new JScrollPane(jta);
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
		});

		/* ����ȭ */
		setVisible(true);
		jtf.requestFocus(); // Ŀ�� ��û : ����ȭ ���Ŀ� ȣ���ؾ� �մϴ�. //

		try {
			connectServer();
			readMsg();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/* �̺�Ʈ ��� */
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
		// 2. ���� ���� //
		client = new Socket("localhost", 65535);
		// 4. ��Ʈ�� ����
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());
	} // connectServer

	/* ���ѷ��� �������� ���� �޼����� �д� �޼ҵ� */
	public void readMsg() throws IOException {
		String revMsg = "";
		while (true) {
			revMsg = readStream.readUTF();
			// ��ȭâ�� ����ϱ�
			jta.append("[server] : " + revMsg + "\n");
		}
	} // readMsg

	/* �ۼ��� �޽����� ������ ������ */
	public void sendMsg() throws IOException {
		String sendMsg = jtf.getText().trim();
		writeStream.writeUTF(sendMsg);
		writeStream.flush();
		// �ۼ��� �޼��� ä��â�� ����ϱ�
		jta.append("[Ŭ���̾�Ʈ]" + sendMsg + "\n");
		// TF�� ���� �ʱ�ȭ-����
		jtf.setText("");
	}// sendMsg

	public static void main(String[] args) {
		new SimpleChatClient();
//		SimpleChatClient scc = new SimpleChatClient();
//		try {
//			scc.connectServer();
//			scc.readMsg();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	} // main

} // class
