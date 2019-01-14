package day0114;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * @author owner<br>
 *         �����ڰ� �������� ������ �����ϴ� ����<br>
 */
@SuppressWarnings("serial")
public class FIleServer extends JFrame implements ActionListener, Runnable {

	private DefaultListModel<String> dlmFileList;
	private JButton btn_StartServer;

	private Thread thr_Server;
	private ServerSocket sk_ServerFile;

	public FIleServer() {
		super("���� ����");

		btn_StartServer = new JButton("��������");

		dlmFileList = new DefaultListModel<>();
		JList<String> listFile = new JList<>(dlmFileList);
		JScrollPane jsp = new JScrollPane(listFile);
		jsp.setBorder(new TitledBorder("���ϸ��"));

		JPanel panel = new JPanel();
		panel.add(btn_StartServer);

		add("Center", jsp);
		add("South", panel);

		btn_StartServer.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 400, 600);
		setVisible(true);

	}// �⺻������

	@Override
	public void run() {
		try {
			Socket sk_Client = null;
			DataInputStream dis = null;
			FileOutputStream fos = null;
			File file = null;
			StringBuilder fileName = new StringBuilder();
			int dataCnt = 0;
			byte[] readData = null;
			int dataLen = 0;
			try {
				while (true) {
					// ������ ������ �����մϴ�.
					sk_Client = sk_ServerFile.accept();
					// 2.Ŭ���̾�Ʈ�� �����ϴ� ���ϸ� ����.
					dis = new DataInputStream(sk_Client.getInputStream());
					fileName.delete(0, fileName.length());
					fileName.append(dis.readUTF());

					fileName.insert(fileName.toString().lastIndexOf("."),
							"_".concat(String.valueOf(System.currentTimeMillis())));
					dlmFileList.addElement(fileName.toString() + "Ŭ���̾�Ʈ ip :" + sk_Client.getInetAddress());

					// 4.Ŭ���̾�Ʈ�� �����ϴ� �迭�� ���� �ޱ�.
					dataCnt = dis.readInt();
					System.out.println("�������� �о�帰 �迭�� ���� : " + dataCnt);

					// 6.���� Ƚ����ŭ ������ �а� ���ÿ� ���Ϸ� ��������.
					file = new File("C:/dev/workspace/javase_prj2/src/day0114/images/" + fileName.toString());
					fos = new FileOutputStream(file);
					readData = new byte[512];
					if (file.exists()) {
						while (dataCnt > 0) {
							dataLen = dis.read(readData);// Ŭ���̾�Ʈ�� �����ϴ� �迭�� ���� ��ŭ �ޱ�
							fos.write(readData, 0, dataLen);// ���Ͽ� ���
							fos.flush();
							dataCnt--;
						} // end while
					} // end if

				} // end while
			} finally {
				if (fos != null) {
					fos.close();
				} // end fos
				if (dis != null) {
					dis.close();
				} // end if
				if (sk_Client != null) {
					sk_Client.close();
				} // end if
			} // end finally
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch
	}// run

	@Override
	public void actionPerformed(ActionEvent e) {
		if (thr_Server == null) {

			try {
				sk_ServerFile = new ServerSocket(10000);
				dlmFileList.addElement("������ 3000��Ʈ�� ����Ǿ����ϴ�.");
				thr_Server = new Thread(this);
				thr_Server.start();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, "��Ʈ�� �̹� ����� �Դϴ�.");
				e1.printStackTrace();
			} // end catch
		} else {
			JOptionPane.showMessageDialog(this, "������ �̹� �����ϰ� �ֽ��ϴ�.");
		} // end else
	}// actionPerformed

	public static void main(String[] args) {
		new FIleServer();
	}// main

}// class
