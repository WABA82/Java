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
			System.exit(0); // JVM�� ������ ��� instance�� kill
		} // end finally
	} // windowClosed

	/**
	 * ������ �޽����� ������ ��
	 * 
	 * @throws IOException
	 */
	public void sendMsg() throws IOException {
		if (writeStream != null) {
			JTextField jtf = mccv.getJtfTalk();
			// �Է��� �޽����� �о���δ�.
			String msg = jtf.getText().trim();
			// String nick = mccv.getJtfNick().getText().trim();

			if (!msg.isEmpty()) {
				// ��Ʈ���� ����
				writeStream.writeUTF("[ " + nick + " ] " + msg);

				// �������� �����Ѵ�.
				writeStream.flush();
			} // end if

			jtf.setText("");
		} // end if
	} // sendMsg

	private void capture() throws IOException {
		switch (JOptionPane.showConfirmDialog(mccv, "��ȭ ������ �����Ͻðڽ��ϱ�?")) {
		case JOptionPane.OK_OPTION:
			// ��Ʈ���� ����Ͽ� ����
			File saveDir = new File("c:/dev/chat");

			saveDir.mkdirs();

			File saveFile = new File(saveDir.getAbsolutePath() + "/java_chat[" + System.currentTimeMillis() + "].dat");

			BufferedWriter bw = null;

			try {
				bw = new BufferedWriter(new FileWriter(saveFile));

				// ��Ʈ���� ��ȭ ���� ���
				bw.write(mccv.getJtaTalkDisplay().getText());

				// ��Ʈ���� ��ϵ� ������ ����
				bw.flush();

				JOptionPane.showMessageDialog(mccv, saveDir + "�� ��ȭ ������ ��ϵǾ����ϴ�.");
			} finally {
				if (bw != null) {
					bw.close();
				} // end if
			} // end finally
		} // end switch
	} // capture

	@Override
	public void actionPerformed(ActionEvent ae) {
		/* ���ӹ�ư ������ �� */
		if (ae.getSource() == mccv.getJbtConnect()) {
			try {
				connectToServer();
			} catch (UnknownHostException uhe) {
				JOptionPane.showMessageDialog(mccv, "������ �� �� �����ϴ�.");
				uhe.printStackTrace();
			} catch (IOException ioe) {
				JOptionPane.showInternalMessageDialog(mccv, "���� ����");
				ioe.printStackTrace();
			} // end catch
		} // end if

		/* �����ư ������ �� */
		if (ae.getSource() == mccv.getJbtCapture()) {
			try {
				if (!mccv.getJtaTalkDisplay().getText().equals("")) {
					capture();
				} else {
					JOptionPane.showMessageDialog(mccv, "������ ��ȭ ������ �����ϴ�.");
				} // end else
			} catch (IOException ioe) {
				JOptionPane.showMessageDialog(mccv, "���Ϸ� �����ϴ� �� ������ �߻��߽��ϴ�.\n��� �� �ٽ� �õ����ּ���.");
				ioe.printStackTrace();
			} // end catch
		} // end if

		/* �ݱ��ư ������ �� */
		if (ae.getSource() == mccv.getJbtClose()) {
			mccv.dispose();
		} // end if

		/* �����ڸ�Ϲ�ư ������ �� */
		if (ae.getSource() == mccv.getJbtOthersList()) {
			/*** �����ϱ� ***/
		}

		if (ae.getSource() == mccv.getJtfTalk()) {
			try {
				sendMsg();
			} catch (IOException ioe) {
				JOptionPane.showInternalMessageDialog(mccv, "������ ����Ǿ� �޽����� ������ �� �����ϴ�.");
				ioe.printStackTrace();
			} // end catch
		} // end if
	} // actionPerformed

	@Override
	public void run() {
		if (readStream != null) {
			try {
				String revMsg = "";
				// �������� �������� �޽����� �о�鿩
				while (true) {
					revMsg = readStream.readUTF();

					JScrollPane jsp = mccv.getJspTalkDisplay();

					// ä��â�� �Ѹ���
					mccv.getJtaTalkDisplay().append(revMsg + "\n");

					// ��ũ�ѹٸ� ���� �Ʒ��� �̵���Ų��.
					jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
				} // end while
			} catch (IOException ioe) {
				JOptionPane.showMessageDialog(mccv, "������ ����Ǿ����ϴ�.");
				ioe.printStackTrace();
			} // end catch
		} // end if
	} // run

	public void connectToServer() throws UnknownHostException, IOException {
		if (client == null) {
			nick = mccv.getJtfNick().getText().trim();

			if (nick.equals("")) {
				JOptionPane.showMessageDialog(mccv, "��ȭ���� �Է����ּ���.");
				mccv.getJtfNick().requestFocus();
				return;
			} // end if

			String serverIp = mccv.getJtfServerIp().getText().trim();

			client = new Socket(serverIp, mccv.getSlctPort()); // �Է��� ip address�� ��ǻ�Ϳ� ����

			// ��Ʈ��
			readStream = new DataInputStream(client.getInputStream());
			writeStream = new DataOutputStream(client.getOutputStream());

			// ��ȭ���� ������ ������.
			writeStream.writeUTF(nick);
			writeStream.flush();

			mccv.getJtaTalkDisplay().setText("������ �����߽��ϴ�.\n��ſ� ä�õǼ���.\n");

			// �޽��� �б�
			threadMsg = new Thread(this);

			threadMsg.start();

		} else {
			JOptionPane.showMessageDialog(mccv, client.getInetAddress().getHostAddress() + " �̹� ������ ���� ���Դϴ�.");
		} // end else
	} // connectToServer

} // class