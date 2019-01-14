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
 *         접속자가 보내오는 파일을 저장하는 서버<br>
 */
@SuppressWarnings("serial")
public class FIleServer extends JFrame implements ActionListener, Runnable {

	private DefaultListModel<String> dlmFileList;
	private JButton btn_StartServer;

	private Thread thr_Server;
	private ServerSocket sk_ServerFile;

	public FIleServer() {
		super("파일 서버");

		btn_StartServer = new JButton("서버가동");

		dlmFileList = new DefaultListModel<>();
		JList<String> listFile = new JList<>(dlmFileList);
		JScrollPane jsp = new JScrollPane(listFile);
		jsp.setBorder(new TitledBorder("파일목록"));

		JPanel panel = new JPanel();
		panel.add(btn_StartServer);

		add("Center", jsp);
		add("South", panel);

		btn_StartServer.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 400, 600);
		setVisible(true);

	}// 기본생성자

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
					// 접속자 소켓이 존재합니다.
					sk_Client = sk_ServerFile.accept();
					// 2.클라이언트가 전송하는 파일명 저장.
					dis = new DataInputStream(sk_Client.getInputStream());
					fileName.delete(0, fileName.length());
					fileName.append(dis.readUTF());

					fileName.insert(fileName.toString().lastIndexOf("."),
							"_".concat(String.valueOf(System.currentTimeMillis())));
					dlmFileList.addElement(fileName.toString() + "클라이언트 ip :" + sk_Client.getInetAddress());

					// 4.클라이언트가 전송하는 배열의 갯수 받기.
					dataCnt = dis.readInt();
					System.out.println("서버에서 읽어드린 배열의 갯수 : " + dataCnt);

					// 6.전송 횟수만큼 파일을 읽고 로컬에 파일로 내보낸다.
					file = new File("C:/dev/workspace/javase_prj2/src/day0114/images/" + fileName.toString());
					fos = new FileOutputStream(file);
					readData = new byte[512];
					if (file.exists()) {
						while (dataCnt > 0) {
							dataLen = dis.read(readData);// 클라이언트가 전송하는 배열의 길이 만큼 받기
							fos.write(readData, 0, dataLen);// 파일에 기록
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
				dlmFileList.addElement("서버가 3000포트로 실행되었습니다.");
				thr_Server = new Thread(this);
				thr_Server.start();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, "포트가 이미 사용중 입니다.");
				e1.printStackTrace();
			} // end catch
		} else {
			JOptionPane.showMessageDialog(this, "서버가 이미 동작하고 있습니다.");
		} // end else
	}// actionPerformed

	public static void main(String[] args) {
		new FIleServer();
	}// main

}// class
