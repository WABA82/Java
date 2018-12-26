package day1226;

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
 * 
 */
@SuppressWarnings("serial")
public class SimpleChatServer extends JFrame implements ActionListener {

	private JTextArea jta;
	private JTextField jtf;

	private ServerSocket server;
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;

	/* ������ */
	public SimpleChatServer() {
		super(":::::::::::::ä�ü���:::::::::::::");
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

		try {
			openServer();
			revMsg();
		} catch (SocketException se) {
			System.err.println("�����ڰ� �������� ���� " + se.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "���� ���� ���� (�޼����� ���� �� �����ϴ�.)");
		}

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
		jta.setText("�������� - �����ڸ� ��ٸ��� �ֽ��ϴ�.\n");
		// 3.������ ���� �ޱ�.
		client = server.accept();
		jta.append("Ŭ���̾�Ʈ ����\n");
		// 4.Stream ����.
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());
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
		jta.append("[��(server) �޼���] " + msg + "\n");
		// �Է��� ���ϵ��� jtf�� �ʱ�ȭ
		jtf.setText("");
	}// sendMsg //

	/* �޽��� �ޱ�(���ѷ���) : �����ڰ� �������� �޼����� ��� �о�´�. */
	public void revMsg() throws IOException {
		String msg = "";
		while (true) {
			// �޼����� �о�鿩 //
			msg = readStream.readUTF();
			// ��ȭâ�� ��� //
			jta.append("[client] : " + msg + "\n");
		} // end while

	} // revMsg //

	public static void main(String[] args) {
		new SimpleChatServer();
//		SimpleChatServer scs = new SimpleChatServer();
//		try {
//			scs.openServer();
//			scs.revMsg();
//		} catch (SocketException se) {
//			System.err.println("�����ڰ� �������� ���� " + se.getMessage());
//		} catch (IOException e) {
//			JOptionPane.showMessageDialog(scs, "���� ���� ���� (�޼����� ���� �� �����ϴ�.)");
//		}
	} // main

} // class
