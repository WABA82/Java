package day1224;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

/**
 * @author owner<br>
 *         클라이언트 소켓 연습 : 서버의 주소와 포트를 가지고 서버에 연결 시도.
 *
 */
public class SimpleClient {

	public SimpleClient() throws UnknownHostException, IOException {
		/* 2. 소켓 생성 : 로컬호스트 -"localhost","127.0.0.1" */
		Socket client = null;
		/* 서버에서 보낸 메세지 일기 위한 스트림 선언 */
		DataInputStream dis = null;
		/* 서버로 메세지를 보내기 위한 스트림 */
		DataOutputStream dos = null;
		try {
			String ip = JOptionPane.showInputDialog(
					"서버 ip\n130,132,133,134,135,157,146,131,141,142,143,144,145,155,156,148,149,151,152,153");
			client = new Socket("211.63.89." + ip, 3000);
			System.out.println("서버에 접속 하였습니다. " + client);
			/* 소켓에서 스트림 얻기 */
			dis = new DataInputStream(client.getInputStream());
			/* 메세지 읽기 */
			String receiveMsg = dis.readUTF();
			/* 출력 */
			System.out.println("서버의 메세지 : " + receiveMsg);

			/* 9. 서버로 데이터를 보내기 위한 스트림 얻기 : 소켓에서 가져오기 */
			String sendMsg = "오늘은 수요일 입니다. - 이재현";
			dos = new DataOutputStream(client.getOutputStream());
			/* 10. 준비된 메세지를 스트림에 기록 */
			dos.writeUTF(sendMsg);
			/* 11.스트림에 기록된 데이터를 목적지(소켓)로 분출 */
			dos.flush();

		} finally {
			if (client != null) {
				client.close();
			}
			if (dis != null) {
				dis.close();
			}
			if (dos != null) {
				dos.close();
			}
		} // try~finally
	}

	public static void main(String[] args) {
		try {
			new SimpleClient();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// 메인

}// 클래스
