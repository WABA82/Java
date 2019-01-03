package kr.co.sist.chat.client.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import kr.co.sist.chat.client.view.MultiChatClientView;

public class MultiChatClientEvt extends WindowAdapter implements ActionListener, Runnable {
	private MultiChatClientView mccv;
	private Socket client;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private Thread threadMsg;
	private String nick;

	public MultiChatClientEvt(MultiChatClientView mccv) {
		this.mccv = mccv;
	} // MultiChatClientEvt

	@Override
	public void windowClosing(WindowEvent we) {
		mccv.dispose();
	} // windowClosing

	@Override
	public void windowClosed(WindowEvent we) {
		try {
			if (readStream != null) {
				readStream.close();
			} // end if
			if (writeStream != null) {
				writeStream.close();
			} // end if
			if (client != null) {
				client.close();
			} // end if
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			System.exit(0); // JVM이 생성한 모든 instance를 kill
		} // end finally
	} // windowClosed

	/**
	 * 서버로 메시지를 보내는 일
	 * 
	 * @throws IOException
	 */
	public void sendMsg() throws IOException {
		if (writeStream != null) {
			JTextField jtf = mccv.getJtfTalk();
			// 입력한 메시지를 읽어들인다.
			String msg = jtf.getText().trim();
			// String nick = mccv.getJtfNick().getText().trim();

			if (!msg.isEmpty()) {
				// 스트림에 쓰고
				writeStream.writeUTF("[ " + nick + " ] " + msg);

				// 목적지로 분출한다.
				writeStream.flush();
			} // end if

			jtf.setText("");
		} // end if
	} // sendMsg

	private void capture() throws IOException {
		switch (JOptionPane.showConfirmDialog(mccv, "대화 내용을 저장하시겠습니까?")) {
		case JOptionPane.OK_OPTION:
			// 스트림을 사용하여 저장
			File saveDir = new File("c:/dev/chat");

			saveDir.mkdirs();

			File saveFile = new File(saveDir.getAbsolutePath() + "/java_chat[" + System.currentTimeMillis() + "].dat");

			BufferedWriter bw = null;

			try {
				bw = new BufferedWriter(new FileWriter(saveFile));

				// 스트림에 대화 내용 기록
				bw.write(mccv.getJtaTalkDisplay().getText());

				// 스트림에 기록된 내용을 분출
				bw.flush();

				JOptionPane.showMessageDialog(mccv, saveDir + "에 대화 내용이 기록되었습니다.");
			} finally {
				if (bw != null) {
					bw.close();
				} // end if
			} // end finally
		} // end switch
	} // capture

	@Override
	public void actionPerformed(ActionEvent ae) {
		/* 접속버튼 눌렸을 때 */
		if (ae.getSource() == mccv.getJbtConnect()) {
			try {
				connectToServer();
			} catch (UnknownHostException uhe) {
				JOptionPane.showMessageDialog(mccv, "서버를 알 수 없습니다.");
				uhe.printStackTrace();
			} catch (IOException ioe) {
				JOptionPane.showInternalMessageDialog(mccv, "연결 실패");
				ioe.printStackTrace();
			} // end catch
		} // end if

		/* 저장버튼 눌렸을 때 */
		if (ae.getSource() == mccv.getJbtCapture()) {
			try {
				if (!mccv.getJtaTalkDisplay().getText().equals("")) {
					capture();
				} else {
					JOptionPane.showMessageDialog(mccv, "저장할 대화 내용이 없습니다.");
				} // end else
			} catch (IOException ioe) {
				JOptionPane.showMessageDialog(mccv, "파일로 저장하는 중 문제가 발생했습니다.\n잠시 후 다시 시도해주세요.");
				ioe.printStackTrace();
			} // end catch
		} // end if

		/* 닫기버튼 눌렸을 때 */
		if (ae.getSource() == mccv.getJbtClose()) {
			mccv.dispose();
		} // end if

		/* 접속자목록버튼 눌렸을 때 */
		if (ae.getSource() == mccv.getJbtOthersList()) {
			/*** 여기하기 ***/
		}

		if (ae.getSource() == mccv.getJtfTalk()) {
			try {
				sendMsg();
			} catch (IOException ioe) {
				JOptionPane.showInternalMessageDialog(mccv, "서버가 종료되어 메시지를 전송할 수 없습니다.");
				ioe.printStackTrace();
			} // end catch
		} // end if
	} // actionPerformed

	@Override
	public void run() {
		if (readStream != null) {
			try {
				String revMsg = "";
				// 서버에서 보내오는 메시지를 읽어들여
				while (true) {
					revMsg = readStream.readUTF();

					JScrollPane jsp = mccv.getJspTalkDisplay();

					// 채팅창에 뿌리고
					mccv.getJtaTalkDisplay().append(revMsg + "\n");

					// 스크롤바를 가장 아래로 이동시킨다.
					jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				} // end while
			} catch (IOException ioe) {
				JOptionPane.showMessageDialog(mccv, "서버가 종료되었습니다.");
				ioe.printStackTrace();
			} // end catch
		} // end if
	} // run

	public void connectToServer() throws UnknownHostException, IOException {
		if (client == null) {
			nick = mccv.getJtfNick().getText().trim();

			if (nick.equals("")) {
				JOptionPane.showMessageDialog(mccv, "대화명을 입력해주세요.");
				mccv.getJtfNick().requestFocus();
				return;
			} // end if

			String serverIp = mccv.getJtfServerIp().getText().trim();

			client = new Socket(serverIp, mccv.getSlctPort()); // 입력한 ip address의 컴퓨터에 연결

			// 스트림
			readStream = new DataInputStream(client.getInputStream());
			writeStream = new DataOutputStream(client.getOutputStream());

			// 대화명을 서버로 보낸다.
			writeStream.writeUTF(nick);
			writeStream.flush();

			mccv.getJtaTalkDisplay().setText("서버에 접속했습니다.\n즐거운 채팅되세요.\n");

			// 메시지 읽기
			threadMsg = new Thread(this);

			threadMsg.start();

		} else {
			JOptionPane.showMessageDialog(mccv, client.getInetAddress().getHostAddress() + " 이미 서버에 접속 중입니다.");
		} // end else
	} // connectToServer

} // class