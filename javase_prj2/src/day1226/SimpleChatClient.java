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

	private Socket client;// 서버와 연결하기 위한 소켓 //
	private DataInputStream readStream;// 서버의 데이터를 읽기 위한 스트림 //
	private DataOutputStream writeStream;// 서버로 데이터를 보내기 위한 스트림 //

	public SimpleChatClient() {
		super(":::::::::::::채팅클라이언트:::::::::::::");
		jta = new JTextArea();
		jta.setEditable(false);
		jta.setLineWrap(true);
		jta.setWrapStyleWord(true);
		jta.setBorder(new TitledBorder("대화내용"));
		JScrollPane jsp = new JScrollPane(jta);
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
		});

		/* 가시화 */
		setVisible(true);
		jtf.requestFocus(); // 커서 요청 : 가시화 한후에 호출해야 합니다. //

		try {
			connectServer();
			readMsg();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/* 이벤트 등록 */
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
		// 2. 소켓 생성 //
		client = new Socket("localhost", 65535);
		// 4. 스트림 생성
		readStream = new DataInputStream(client.getInputStream());
		writeStream = new DataOutputStream(client.getOutputStream());
	} // connectServer

	/* 무한루프 서버에서 보낸 메세지를 읽는 메소드 */
	public void readMsg() throws IOException {
		String revMsg = "";
		while (true) {
			revMsg = readStream.readUTF();
			// 대화창에 출력하기
			jta.append("[server] : " + revMsg + "\n");
		}
	} // readMsg

	/* 작성된 메시지를 서버로 보내기 */
	public void sendMsg() throws IOException {
		String sendMsg = jtf.getText().trim();
		writeStream.writeUTF(sendMsg);
		writeStream.flush();
		// 작성된 메세지 채팅창에 출력하기
		jta.append("[클라이언트]" + sendMsg + "\n");
		// TF의 내용 초기화-삭제
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
