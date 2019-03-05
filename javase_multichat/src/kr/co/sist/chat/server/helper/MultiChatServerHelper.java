package kr.co.sist.chat.server.helper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 * �������� �����ϸ� ������ ���Ͽ� ��Ʈ���� ���ͼ� �����ϴ� Ŭ���� �����ڰ� �����ϸ� ������ ���Ͽ� �� ��Ʈ������ �޽����� ���� ������
 * �о���̰�, ��� �����ڿ��� �޽��� ���
 * 
 * @author owner
 */
public class MultiChatServerHelper extends Thread {
	
	private Socket someClient;
	private DataInputStream readStream;
	private DataOutputStream writeStream;
	private DefaultListModel<String> dlm;
	private int cnt;
	private List<MultiChatServerHelper> connectList;
	private JFrame jf;
	private JScrollPane jsp;
	private String nick;

	/**
	 * ������ ������ �޾Ƽ� ��Ʈ���� ��� �޽����� �аų� ���� �� �ִ� ���·� �����.
	 * 
	 * @param socket ������ ����
	 * @param dlm    ������ ����â�� ����ϱ� ���� Model ��ü
	 * @param cnt    ���� ����
	 */
	public MultiChatServerHelper(Socket socket, DefaultListModel<String> dlm, int cnt, JFrame jf, List<MultiChatServerHelper> list, JScrollPane jsp) {
		someClient = socket;
		this.dlm = dlm;
		this.cnt = cnt;
		this.jf = jf;
		connectList = list;
		this.jsp = jsp;

		// ��Ʈ�� ���
		try {
			readStream = new DataInputStream(someClient.getInputStream());
			writeStream = new DataOutputStream(someClient.getOutputStream());

			// �����ڰ� �������� nick�� �޴´�.
			nick = readStream.readUTF();

			// ����â�� ���� �޽��� ���
			dlm.addElement("[" + someClient.getInetAddress() + " / " + nick + "] ���� �����ϼ̽��ϴ�.");

			// ������ ������ �����ڿ��� �޽����� ���
			broadcast("[ " + cnt + " ]��° �����ڰ� [ " + nick + " ]���� ä�ù濡 �����߽��ϴ�.");

			jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(jf, "������ ���� �� ���� �߻�...");
			ioe.printStackTrace();
		} // end catch

	} // MultiCharServerHelper

	@Override
	public void run() {
		if (readStream != null) {
			try {
				String revMsg = "";
				// �������� �������� ��� �޽����� �о, ��� �����ڿ��� �Ѹ���.
				while (true) {
					revMsg = readStream.readUTF();
					broadcast(revMsg);
				} // end while
			} catch (IOException ioe) {

				// �����ڰ� ����ϸ� �ش� �����ڸ� ����Ʈ���� �����Ѵ�.
				connectList.remove(this);

				// �޽����� �о������ ���ϴ� ���¶��, �����ڰ� ������ ������ ����
				dlm.addElement(cnt + "��°" + nick + "������ ���");
				broadcast("[ " + nick + " ] ���� ����߽��ϴ�.");

				jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());

				ioe.printStackTrace();
			} // end catch
		} // end if
	} // run

	/**
	 * ��� �����ڿ��� �޽����� �ѷ��ִ� �� synchronized : ��ƼThread���� ���ÿ� ȣ���� �� ����. (����ȭ ó��)
	 * 
	 * @param msg
	 */
	public synchronized void broadcast(String msg) {
		MultiChatServerHelper mcsh = null;
		try {
			for (int i = 0; i < connectList.size(); i++) {
				mcsh = connectList.get(i); // ����Ʈ���� Helper ��ü�� ���
				mcsh.writeStream.writeUTF(msg); // ��� ��Ʈ���� ���
				mcsh.writeStream.flush(); // ������ (����)�� ����
			} // end for
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(jf, "[ " + cnt + " ]��° �����ڿ��� �޽����� ���� �� �����ϴ�.");
			ioe.printStackTrace();
		} // end catch
	} // broadcast

} // class

