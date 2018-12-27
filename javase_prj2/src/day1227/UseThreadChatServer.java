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
 *         Thread 사용하여 메세지를 읽는 코드를 화면, 메세지를 보내는 코드와 동시에 처리한다.
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

	/* 생성자 */
	public UseThreadChatServer() {
		super(":::::::::::::채팅서버:::::::::::::");
		jta = new JTextArea();
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		jta.setBorder(new TitledBorder("대화내용"));
		jsp = new JScrollPane(jta);
		jtf = new JTextField();
		jtf.setBorder(new TitledBorder("대화입력"));
		/* 배치 */
		add("Center", jsp);
		add("South", jtf);
		/* 크기설정 */
		setBounds(100, 100, 300, 400);
		/* 종료처리 : 소켓 때문에 익명클래스로 작성한다. */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("종료");
				dispose(); // 화면만 종료
//				System.exit(0);
			}

			@Override
			public void windowClosed(WindowEvent e) {
				System.out.println("영혼");
				try {
					close(); // 클라이언트와 연결중인 스트림, 소켓, 서버소켓을 종료
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		/* 가시화 */
		setVisible(true);
		jtf.requestFocus(); // 커서 요청 : 가시화 한후에 호출해야 합니다. //

//		try {
//			openServer();
//			/* 쓰레드 생성 (Has A) : 메세지를 읽는 코드를 쓰레드로 처리하면 어디에 있든 동작을 하게 됩니다 */
//			Thread t = new Thread(this);
//			t.start(); // start에 의해 run호출
//		} catch (SocketException se) {
//			System.err.println("접속자가 들어오기전 종료 " + se.getMessage());
//		} catch (IOException e) {
//			JOptionPane.showMessageDialog(this, "서버 가동 실패 (메세지를 읽을 수 없습니다.)");
//		}

		/* 이벤트 처리 */
		jtf.addActionListener(this);
	}// 생성자

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
				JOptionPane.showMessageDialog(this, "대화상대가 없습니다.");
				jtf.setText("");
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	} // actionPerformed

	/*
	 * 서버소켓 생성 (포트열림) 접속자 소켓이 들어오면(accept) 대화를 할수 있도록 스트림을
	 * 연결(readStream,writeStream)
	 */
	public void openServer() throws IOException, SocketException {
		// 1.서버소켓 생성.
		server = new ServerSocket(65535);
		serverNickName = JOptionPane.showInputDialog(this, "대화명을 입력해 주세요.");
		jta.setText("서버가동 - 접속자를 기다리고 있습니다.\n");
		// 3.접속자 소켓 받기.
		client = server.accept();
		jta.append("클라이언트 접속\n");
		// 4.Stream 연결.
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());

		clientNickName = readStream.readUTF();
		writeStream.writeUTF(serverNickName);
	}// openServer //

	/* 메시지 보내기 */
	public void sendMsg() throws IOException {
		// 텍스트필드의 값을 가져오기 //
		String msg = jtf.getText().trim();
		// 스트림에 기록 하기 //
		writeStream.writeUTF(msg);
		// 스트림 내보내기 //
		writeStream.flush();
		// 내가 씉 내용을 내 화면에 출력하기 //
		jta.append("[" + serverNickName + "] " + msg + "\n");
		// 입력이 편하도록 jtf를 초기화
		jtf.setText("");
		// 스크롤바 자동조정 설정
		jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());

	}// sendMsg //

	/* 메시지 받기(무한루프) : 접속자가 보내오는 메세지를 계속 읽어온다. */
	@Override
	public void run() {
		String msg = "";
		if (readStream != null) {
			try {
				while (true) {
					// 메세지를 읽어들여 //
					msg = readStream.readUTF();
					// 대화창에 출력 //
					jta.append("[" + clientNickName + "] : " + msg + "\n");
					// 메세지가 TA에 추가되면 JScrollPane의 스크롤 바의 값을 JSP의 최고값으로 변경해준다. //
					jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				} // end while
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "접속자가 퇴실하였습니다.");
				// e.printStackTrace();
			}
		}

	} // revMsg //

	public static void main(String[] args) {
//		new UseTreadChatServer();
		UseThreadChatServer scs = new UseThreadChatServer();
		try {
			scs.openServer();
			/* Thread 생성 (Has A) */
			Thread t = new Thread(scs);
			t.start();
		} catch (SocketException se) {
			System.err.println("접속자가 들어오기전 종료 " + se.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(scs, "서버 가동 실패 (메세지를 읽을 수 없습니다.)");
		}
	} // main

} // class
