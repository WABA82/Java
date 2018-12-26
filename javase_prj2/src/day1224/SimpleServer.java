package day1224;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * @author owner<br>
 *         ServerSocket ���� : port(0~65535�� �ϳ�)�� ����, ������ ������ �޴� ��.
 */
public class SimpleServer {

	public SimpleServer() throws IOException {
		/* ��Ʈ���� : �����ڰ� �����⸦ ��ٸ��ϴ�. */
		ServerSocket server = null;
		/* �����ڿ��� ������ �޼��� */
		String msg = "HelloWorld";
		/* �����ڿ��� �޼����� ������ ���� ��Ʈ�� */
		DataOutputStream dos = null;
		/* �����ڰ� ���� �޼����� �б����� ��Ʈ�� */
		DataInputStream dis = null;
		try {
			while (true) {
				server = new ServerSocket(3000);
				System.out.println("���� ���� �� " + server);
				/* �����ڰ� ������ ������ ������ �޴´�. */
				Socket client = server.accept();
				System.out.println("������ ���� : " + client);
				/* �����ڿ��� �޼����� ������ ���� ��Ʈ�� ���� */
				dos = new DataOutputStream(client.getOutputStream());
				/* �� ��Ʈ���� ������ ���� */
				dos.writeUTF(msg);
				/* ��Ʈ���� ������ - �������� ���� */
				dos.flush();

				/* 12. Ŭ���̾�Ʈ�� �������� �޽����� �ϱ����� ��Ʈ������ */
				dis = new DataInputStream(client.getInputStream());
				String revMsg = ""; // Ŭ���̾�Ʈ�� ������ �޽��� ����
				/* 13. ��Ʈ������ �޽����б� */
				revMsg = dis.readUTF();
				JOptionPane.showMessageDialog(null, "Ŭ���̾�Ʈ�� �޽���\n" + revMsg);
			}
		} finally {
			/* ���� ���� �ݱ� */
			if (server != null) {
				server.close();
			}
			/* �������� ��Ʈ�� �ݱ� */
			if (dos != null) {
				dos.close();
			}
			/* �о���� ��Ʈ�� �ݱ� */
			if (dis != null) {
				dis.close();
			}
		} // try~finally
	}// SimpleServer

	public static void main(String[] args) {
		try {
			new SimpleServer();
		} catch (IOException e) {
			System.out.println("�̹� ������� ��Ʈ �Դϴ�.");
			e.printStackTrace();
		}
	}

}
