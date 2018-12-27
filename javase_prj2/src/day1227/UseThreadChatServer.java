package day1227;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author owner<br>
 *         Thread ����Ͽ� �޼����� �д� �ڵ带 ȭ��, �޼����� ������ �ڵ�� ���ÿ� ó���Ѵ�.
 * 
 */
@SuppressWarnings("serial")
public class UseThreadChatServer extends JFrame implements ActionListener, Runnable {

	private JTextArea jta;
	private JScrollPane jsp;
	private JTextField jtf;

	private ServerSocket server;
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;

	private String serverNickName;
	private String clientNickName;

	/* ������ */
	public UseThreadChatServer() {
		super(":::::::::::::ä�ü���:::::::::::::");
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
				System.out.println("����");
				dispose(); // ȭ�鸸 ����
//				System.exit(0);
			}

			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("��ȥ");
				try {
					close(); // Ŭ���̾�Ʈ�� �������� ��Ʈ��, ����, ���������� ����
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		/* ����ȭ */
		setVisible(true);
		jtf.requestFocus(); // Ŀ�� ��û : ����ȭ ���Ŀ� ȣ���ؾ� �մϴ�. //

//		try {
//			openServer();
//			/* ������ ���� (Has A) : �޼����� �д� �ڵ带 ������� ó���ϸ� ��� �ֵ� ������ �ϰ� �˴ϴ� */
//			Thread t = new Thread(this);
//			t.start(); // start�� ���� runȣ��
//		} catch (SocketException se) {
//			System.err.println("�����ڰ� �������� ���� " + se.getMessage());
//		} catch (IOException e) {
//			JOptionPane.showMessageDialog(this, "���� ���� ���� (�޼����� ���� �� �����ϴ�.)");
//		}

		/* �̺�Ʈ ó�� */
		jtf.addActionListener(this);
	}// ������

	public void close() throws IOException {
		try {
			if (readStream != null) {
				readStream.close();
			}
			if (writeStream != null) {
				writeStream.close();
			}
			if (client != null) {
				client.close();
			}
		} finally {
			if (server != null) {
				server.close();
			}
		} // try~finally

	}// close

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (writeStream != null) {
				sendMsg();
			} else {
				JOptionPane.showMessageDialog(this, "��ȭ��밡 �����ϴ�.");
				jtf.setText("");
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	} // actionPerformed

	/*
	 * �������� ���� (��Ʈ����) ������ ������ ������(accept) ��ȭ�� �Ҽ� �ֵ��� ��Ʈ����
	 * ����(readStream,writeStream)
	 */
	public void openServer() throws IOException, SocketException {
		// 1.�������� ����.
		server = new ServerSocket(65535);
		serverNickName = JOptionPane.showInputDialog(this, "��ȭ���� �Է��� �ּ���.");
		jta.setText("�������� - �����ڸ� ��ٸ��� �ֽ��ϴ�.\n");
		// 3.������ ���� �ޱ�.
		client = server.accept();
		jta.append("Ŭ���̾�Ʈ ����\n");
		// 4.Stream ����.
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());

		clientNickName = readStream.readUTF();
		writeStream.writeUTF(serverNickName);
	}// openServer //

	/* �޽��� ������ */
	public void sendMsg() throws IOException {
		// �ؽ�Ʈ�ʵ��� ���� �������� //
		String msg = jtf.getText().trim();
		// ��Ʈ���� ��� �ϱ� //
		writeStream.writeUTF(msg);
		// ��Ʈ�� �������� //
		writeStream.flush();
		// ���� �� ������ �� ȭ�鿡 ����ϱ� //
		jta.append("[" + serverNickName + "] " + msg + "\n");
		// �Է��� ���ϵ��� jtf�� �ʱ�ȭ
		jtf.setText("");
		// ��ũ�ѹ� �ڵ����� ����
		jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());

	}// sendMsg //

	/* �޽��� �ޱ�(���ѷ���) : �����ڰ� �������� �޼����� ��� �о�´�. */
	@Override
	public void run() {
		String msg = "";
		if (readStream != null) {
			try {
				while (true) {
					// �޼����� �о�鿩 //
					msg = readStream.readUTF();
					// ��ȭâ�� ��� //
					jta.append("[" + clientNickName + "] : " + msg + "\n");
					// �޼����� TA�� �߰��Ǹ� JScrollPane�� ��ũ�� ���� ���� JSP�� �ְ����� �������ش�. //
					jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				} // end while
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "�����ڰ� ����Ͽ����ϴ�.");
				// e.printStackTrace();
			}
		}

	} // revMsg //

	public static void main(String[] args) {
//		new UseTreadChatServer();
		UseThreadChatServer scs = new UseThreadChatServer();
		try {
			scs.openServer();
			/* Thread ���� (Has A) */
			Thread t = new Thread(scs);
			t.start();
		} catch (SocketException se) {
			System.err.println("�����ڰ� �������� ���� " + se.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(scs, "���� ���� ���� (�޼����� ���� �� �����ϴ�.)");
		}
	} // main

} // class
