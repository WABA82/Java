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
 *         선택한 파일을 서버로 전송하는 파일클라이언트<br>
 */
@SuppressWarnings("serial")
public class FileClient extends JFrame implements ActionListener {

	private JButton btn_SelectFile;
	private DefaultListModel<String> dlmFileList;

	public FileClient() {
		super("파일전송");

		btn_SelectFile = new JButton("파일선택");

		dlmFileList = new DefaultListModel<>();
		JList<String> listFile = new JList<>(dlmFileList);
		JScrollPane jspFileList = new JScrollPane(listFile);
		jspFileList.setBorder(new TitledBorder("전송한 파일"));

		JPanel panel = new JPanel();
		panel.add(btn_SelectFile);

		add("Center", jspFileList);
		add("South", panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btn_SelectFile.addActionListener(this);

		setBounds(100, 100, 400, 300);
		setVisible(true);
	}// 기본생성자

	private void selectFile() {
		FileDialog fd_Open = new FileDialog(this, "파일선택", FileDialog.LOAD);
		fd_Open.setVisible(true);
		String path = fd_Open.getDirectory();
		String name = fd_Open.getFile();

		if (name != null) {/* 파일이 선택 되었을 때 실행 */

			// 이미지 파일만 전송, 이미지 파일이 아닌 경우 경고창 출력
			// 이미지 파일 종류 : jpg, jpeg, gif, png, bmp
			String[] arrCompExt = "jpg,jpeg,gif,png,bmp".split(",");
			String slcImgExt = name.substring(name.lastIndexOf(".") + 1).toLowerCase();

			boolean extFlag = false;

			for (String eachCompExt : arrCompExt) {
				if (eachCompExt.equals(slcImgExt)) {
					extFlag = true;
				} // end if
			} // for ~ each

			if (!extFlag) {
				JOptionPane.showMessageDialog(this, "이미지 파일만 선택할 수 있습니다.");
				return;
			} // end if

		} // end if

		// 파일전송!!!
		try {
			sendFile(new File(path + "/" + name));
			JOptionPane.showMessageDialog(this, name + "파일을 전송하였습니다.");
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
			String ip = JOptionPane.showInputDialog("서버 ip");
			sk_client = new Socket("211.63.89." + ip.trim(), 10000);

			// 1.파일명을 전송
			String fileName = file.getName(); // 파일명 받기
			dos = new DataOutputStream(sk_client.getOutputStream());
			dos.writeUTF(fileName);
			dos.flush();

			// 3.전송할 파일의 byte[] 갯수 서버 전송
			int dataCnt = 0;
			int dataLen = 0;
			byte[] tempData = new byte[512];

			fis = new FileInputStream(file);
			while ((dataLen = fis.read(tempData)) != -1) {
				dataCnt++;
			} // end while
			System.out.println("전송할 배열의 갯수 : " + dataCnt);
			fis.close(); // 다음 번에 실행하기 위해 한번꺼줍니다.

			dos.writeInt(dataCnt); // 서버가 읽어들여야 하는 배열의 갯수를 전송한다.
			dos.flush();

			// 5. 파일에서 읽어들인 내용을 전송한다.
			dataLen = 0;
			fis = new FileInputStream(file);
			while ((dataLen = fis.read(tempData)) != -1) {
				dos.write(tempData, 0, dataLen);
				dos.flush();
				dataCnt--;
			} // end while
			System.out.println("0이면 전송이 잘된겁니다. " + dataCnt);

		} finally { /* finally : 연결끊기 */
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
