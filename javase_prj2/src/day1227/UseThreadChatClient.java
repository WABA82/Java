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
 *         쓰레드를 사용하여 무한루프의 코드를 동시에 실행하기
 * 
 */
@SuppressWarnings("serial")
public class UseThreadChatClient extends JFrame implements ActionListener, Runnable {

	private JTextArea jta;
	private JTextField jtf;
	JScrollPane jsp;

	private Socket client;// 서버와 연결하기 위한 소켓 //
	private DataInputStream readStream;// 서버의 데이터를 읽기 위한 스트림 //
	private DataOutputStream writeStream;// 서버로 데이터를 보내기 위한 스트림 //

	private String nickName;
	private String serverNickName;// 서버의 대화명

	public UseThreadChatClient() {
		super(":::::::::::::채팅클라이언트:::::::::::::");
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

		/* 가시화 */
		setVisible(true);
		jtf.requestFocus(); // 커서 요청 : 가시화 한후에 호출해야 합니다. //

//		try {
//			connectServer();
//			/* 쓰레드 생성 Has A */
//			Thread t = new Thread(this);
//			t.start();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		/* 이벤트 등록 */
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

	/* 연결종료 메소드 */
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

	}// close 메소드

	/* 소켓을 생성하고 서버에 연결하기, 대화를 읽거나 보내기 위해 스트림을 연결한다. */
	public void connectServer() throws IOException {
		nickName = JOptionPane.showInputDialog("대화명 입력");
		// 2. 소켓 생성 //
		client = new Socket("211.63.89.133", 65535);
		// 4. 스트림 생성
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());
		// 서버로 대화명 전달
		writeStream.writeUTF(nickName);
		jta.setText("대화방에 \"" + nickName + "\"으로 입장하셨습니다.");
		// 서버의 대화명 저장
		serverNickName = readStream.readUTF();
	} // connectServer

	/* 무한루프 서버에서 보낸 메세지를 읽는 메소드 */
	@Override
	public void run() {
		String revMsg = "";
		if (readStream != null) {
			try {
				while (true) {
					revMsg = readStream.readUTF();
					// 대화창에 출력하기
					jta.append("[" + serverNickName + "] : " + revMsg + "\n");
					// 스크롤바 길이 자동조절
					jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				} // end while
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, serverNickName + "님이 퇴실하였습니다.");
				// e.printStackTrace();
			}
		}

	} // readMsg

	/* 작성된 메시지를 서버로 보내기 */
	public void sendMsg() throws IOException {
		String sendMsg = jtf.getText().trim();
		writeStream.writeUTF(sendMsg);
		writeStream.flush();
		// 작성된 메세지 채팅창에 출력하기
		jta.append("[" + nickName + "]" + sendMsg + "\n");
		// TF의 내용 초기화-삭제
		jtf.setText("");
		// 스크롤바 길이 자동조절
		jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
	}// sendMsg

	public static void main(String[] args) {
//		new UseTreadChatClient();
		UseThreadChatClient scc = new UseThreadChatClient();
		try {
			scc.connectServer();
			/* 쓰레드 생성 Has A : 메세지를 동시에 읽어야 하기 때문에 쓰레드로 처리 */
			Thread t = new Thread(scc);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // main

} // class
