package day0114;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

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
 *         ������ ������ ������ �����ϴ� ����Ŭ���̾�Ʈ<br>
 */
@SuppressWarnings("serial")
public class FileClient extends JFrame implements ActionListener {

	private JButton btn_SelectFile;
	private DefaultListModel<String> dlmFileList;

	public FileClient() {
		super("��������");

		btn_SelectFile = new JButton("���ϼ���");

		dlmFileList = new DefaultListModel<>();
		JList<String> listFile = new JList<>(dlmFileList);
		JScrollPane jspFileList = new JScrollPane(listFile);
		jspFileList.setBorder(new TitledBorder("������ ����"));

		JPanel panel = new JPanel();
		panel.add(btn_SelectFile);

		add("Center", jspFileList);
		add("South", panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn_SelectFile.addActionListener(this);

		setBounds(100, 100, 400, 300);
		setVisible(true);
	}// �⺻������

	private void selectFile() {
		FileDialog fd_Open = new FileDialog(this, "���ϼ���", FileDialog.LOAD);
		fd_Open.setVisible(true);
		String path = fd_Open.getDirectory();
		String name = fd_Open.getFile();

		if (name != null) {/* ������ ���� �Ǿ��� �� ���� */

			// �̹��� ���ϸ� ����, �̹��� ������ �ƴ� ��� ���â ���
			// �̹��� ���� ���� : jpg, jpeg, gif, png, bmp
			String[] arrCompExt = "jpg,jpeg,gif,png,bmp".split(",");
			String slcImgExt = name.substring(name.lastIndexOf(".") + 1).toLowerCase();

			boolean extFlag = false;

			for (String eachCompExt : arrCompExt) {
				if (eachCompExt.equals(slcImgExt)) {
					extFlag = true;
				} // end if
			} // for ~ each

			if (!extFlag) {
				JOptionPane.showMessageDialog(this, "�̹��� ���ϸ� ������ �� �ֽ��ϴ�.");
				return;
			} // end if

		} // end if

		// ��������!!!
		try {
			sendFile(new File(path + "/" + name));
			JOptionPane.showMessageDialog(this, name + "������ �����Ͽ����ϴ�.");
			dlmFileList.addElement(name);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // end catch

	}// selectFile

	private void sendFile(File file) throws UnknownHostException, IOException {
		Socket sk_client = null;
		DataOutputStream dos = null;
		FileInputStream fis = null;
		try {
			String ip = JOptionPane.showInputDialog("���� ip");
			sk_client = new Socket("211.63.89." + ip.trim(), 10000);

			// 1.���ϸ��� ����
			String fileName = file.getName(); // ���ϸ� �ޱ�
			dos = new DataOutputStream(sk_client.getOutputStream());
			dos.writeUTF(fileName);
			dos.flush();

			// 3.������ ������ byte[] ���� ���� ����
			int dataCnt = 0;
			int dataLen = 0;
			byte[] tempData = new byte[512];

			fis = new FileInputStream(file);
			while ((dataLen = fis.read(tempData)) != -1) {
				dataCnt++;
			} // end while
			System.out.println("������ �迭�� ���� : " + dataCnt);
			fis.close(); // ���� ���� �����ϱ� ���� �ѹ����ݴϴ�.

			dos.writeInt(dataCnt); // ������ �о�鿩�� �ϴ� �迭�� ������ �����Ѵ�.
			dos.flush();

			// 5. ���Ͽ��� �о���� ������ �����Ѵ�.
			dataLen = 0;
			fis = new FileInputStream(file);
			while ((dataLen = fis.read(tempData)) != -1) {
				dos.write(tempData, 0, dataLen);
				dos.flush();
				dataCnt--;
			} // end while
			System.out.println("0�̸� ������ �ߵȰ̴ϴ�. " + dataCnt);

		} finally { /* finally : ������� */
			if (fis != null) {
				fis.close();
			} // end if
			if (dos != null) {
				dos.close();
			} // end if
			if (sk_client != null) {
				sk_client.close();
			} // end if
		} // end finally

	}// sendFile

	@Override
	public void actionPerformed(ActionEvent e) {
		selectFile();
	}// actionPerformed

	public static void main(String[] args) {
		new FileClient();
	}// main

}// class
