package day1224;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * @author owner<br>
 *         ServerSocket 연습 : port(0~65535중 하나)를 열고, 접속자 소켓을 받는 일.
 */
public class SimpleServer {

	public SimpleServer() throws IOException {
		/* 포트열기 : 접속자가 들어오기를 기다립니다. */
		ServerSocket server = null;
		/* 접속자에게 보내줄 메세지 */
		String msg = "HelloWorld";
		/* 접속자에게 메세지를 보내기 위한 스트림 */
		DataOutputStream dos = null;
		/* 접속자가 보낸 메세지를 읽기위한 스트림 */
		DataInputStream dis = null;
		try {
			while (true) {
				server = new ServerSocket(3000);
				System.out.println("서버 가동 중 " + server);
				/* 접속자가 들어오면 접속자 소켓을 받는다. */
				Socket client = server.accept();
				System.out.println("접속자 있음 : " + client);
				/* 접속자에게 메세지를 보내기 위한 스트림 연결 */
				dos = new DataOutputStream(client.getOutputStream());
				/* 얻어낸 스트림에 데이터 쓰기 */
				dos.writeUTF(msg);
				/* 스트림의 목적지 - 소켓으로 분출 */
				dos.flush();

				/* 12. 클라이언트가 보내오는 메시지를 일기위한 스트림연결 */
				dis = new DataInputStream(client.getInputStream());
				String revMsg = ""; // 클라이언트가 보내온 메시지 저장
				/* 13. 스트림에서 메시지읽기 */
				revMsg = dis.readUTF();
				JOptionPane.showMessageDialog(null, "클라이언트의 메시지\n" + revMsg);
			}
		} finally {
			/* 서버 소켓 닫기 */
			if (server != null) {
				server.close();
			}
			/* 내보내기 스트림 닫기 */
			if (dos != null) {
				dos.close();
			}
			/* 읽어오기 스트림 닫기 */
			if (dis != null) {
				dis.close();
			}
		} // try~finally
	}// SimpleServer

	public static void main(String[] args) {
		try {
			new SimpleServer();
		} catch (IOException e) {
			System.out.println("이미 사용중인 포트 입니다.");
			e.printStackTrace();
		}
	}

}
