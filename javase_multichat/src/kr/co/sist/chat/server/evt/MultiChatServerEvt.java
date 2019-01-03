package kr.co.sist.chat.server.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import kr.co.sist.chat.server.helper.MultiChatServerHelper;
import kr.co.sist.chat.server.view.MultiChatServerView;

public class MultiChatServerEvt extends WindowAdapter implements ActionListener, Runnable {
	private MultiChatServerView mcsv; // MultiChatServerView
	private Thread threadServer; // �����ڿ� ���� ó���� �ϱ� ���� Thread
	private ServerSocket server; // PORT ����
	private List<MultiChatServerHelper> listClient; // ��� �����ڸ� ������ List

	public MultiChatServerEvt(MultiChatServerView mcsv) {
		this.mcsv = mcsv;
		listClient = new ArrayList<MultiChatServerHelper>();

	} // MultiChatServerEvt

	@Override
	public void windowClosing(WindowEvent we) {
		mcsv.dispose();
	} // windowClosing

	@Override
	public void windowClosed(WindowEvent we) {
		try {
			if (server != null) {
				server.close();
			} // end if
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} // end catch
	} // windowClosed

	@Override
	public void run() {
		// ���� ������ ���� ������ ������ �޴� ��
		try {
			server = new ServerSocket(36001); // 0 ~ 65535���� PORT�� ���� �� �ִ�.

			DefaultListModel<String> dlmTemp = mcsv.getDlmChatList();

			dlmTemp.addElement("������ 36000 PORT�� ���� ���� ��...");

			Socket someClient = null; // ������ ������ ������ ��ü
			InetAddress ia = null; // �������� ip address�� ��� ���� ��ü
			// ������ ������ �޾� ��Ʈ���� �����ϰ�, ��ȭ�� �аų� ��� �����ڿ��� �����ϴ� ��
			MultiChatServerHelper mcsh = null;

			for (int cnt = 0;; cnt++) {
				someClient = server.accept();

				ia = someClient.getInetAddress();

//				dlmTemp.addElement("[ " + ia + " / " + " ] ������ ����");

				// ����, ������ ȭ��, ���� ������ �Ҵ��Ͽ� Helper class�� �����Ѵ�.
				mcsh = new MultiChatServerHelper(someClient, dlmTemp, cnt, mcsv, listClient, mcsv.getJspList());

				// ������ ���� �̸��� ���� ��ü�� ���� �� �����ϱ� ���� List�� �߰�
				listClient.add(mcsh);

				// �������� �޽����� �о���̱� ���� Thread ����
				mcsh.start();

			} // end for
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} // end catch
	} // run

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == mcsv.getJbtOpenServer()) {
			if (threadServer == null) {
				threadServer = new Thread(this);

				threadServer.start(); // start() �� run()
			} else {
				JOptionPane.showMessageDialog(mcsv, "ä�� ������ �̹� ���� ���Դϴ�.");
			}
		} // end if

		if (ae.getSource() == mcsv.getJbtCloseServer()) {
			switch (JOptionPane.showConfirmDialog(mcsv, "ä�� ������ �����Ͻðڽ��ϱ�?\n�����Ͻø� ��� �������� ������ �������ϴ�.")) {
			case JOptionPane.OK_OPTION:
				mcsv.dispose();
			} // end switch
		} // end if
	} // actionPerformed

} // class