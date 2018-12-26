package day1224;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

/**
 * @author owner<br>
 *         Ŭ���̾�Ʈ ���� ���� : ������ �ּҿ� ��Ʈ�� ������ ������ ���� �õ�.
 *
 */
public class SimpleClient {

	public SimpleClient() throws UnknownHostException, IOException {
		/* 2. ���� ���� : ����ȣ��Ʈ -"localhost","127.0.0.1" */
		Socket client = null;
		/* �������� ���� �޼��� �ϱ� ���� ��Ʈ�� ���� */
		DataInputStream dis = null;
		/* ������ �޼����� ������ ���� ��Ʈ�� */
		DataOutputStream dos = null;
		try {
			String ip = JOptionPane.showInputDialog(
					"���� ip\n130,132,133,134,135,157,146,131,141,142,143,144,145,155,156,148,149,151,152,153");
			client = new Socket("211.63.89." + ip, 3000);
			System.out.println("������ ���� �Ͽ����ϴ�. " + client);
			/* ���Ͽ��� ��Ʈ�� ��� */
			dis = new DataInputStream(client.getInputStream());
			/* �޼��� �б� */
			String receiveMsg = dis.readUTF();
			/* ��� */
			System.out.println("������ �޼��� : " + receiveMsg);

			/* 9. ������ �����͸� ������ ���� ��Ʈ�� ��� : ���Ͽ��� �������� */
			String sendMsg = "������ ������ �Դϴ�. - ������";
			dos = new DataOutputStream(client.getOutputStream());
			/* 10. �غ�� �޼����� ��Ʈ���� ��� */
			dos.writeUTF(sendMsg);
			/* 11.��Ʈ���� ��ϵ� �����͸� ������(����)�� ���� */
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
	}// ����

}// Ŭ����
