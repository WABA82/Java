package kr.co.sist.admin.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import kr.co.sist.lunch.admin.run.LunchAdminMain;

public class FileServer extends Thread {

	@Override
	public void run() {
		ServerSocket server = null;

		try {
			try {

				server = new ServerSocket(25000);
				Socket client = null;

				DataInputStream dis = null;
				DataOutputStream dos = null;

				int cnt = 0;

				String[] fileNames = null;
				String[] serverFileNames = null;

				List<String> tempFileList = new ArrayList<String>();

				while (true) {
					client = server.accept();

					dis = new DataInputStream(client.getInputStream());

					cnt = dis.readInt();// 클라이언트가 보내오는 파일이름의 갯수
					fileNames = new String[cnt];

					for (int i = 0; i < cnt; i++) {
						fileNames[i] = dis.readUTF();
					} // end for i

					// 서버에 존재하는 파일명을 배열로 복사
					serverFileNames = new String[LunchAdminMain.lunchImageList.size()];
					LunchAdminMain.lunchImageList.toArray(serverFileNames);

					// 클라이언트가 보내온 파일명과 서버의 파일명을 비교하여
					for (String tName : LunchAdminMain.lunchImageList) {
						tempFileList.add(tName);
						tempFileList.add("s_" + tName);
					} // end for each

					// 클라이언트가 없는 파일명을 출력
					for (String rmName : fileNames) {
						tempFileList.remove(rmName);
						tempFileList.remove("s_" + rmName);
					} // end for

					dos = new DataOutputStream(client.getOutputStream());

					// 전송할 파일의 개수를 보낸다.
					dos.writeInt(tempFileList.size());
					dos.flush();

					for (String fName : tempFileList) {
						fileSend(fName, dos);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} // end for

				} // end while

			} finally {
				if (server != null) { // end if
					server.close();
				} // end if
			} // end finally
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "파일 내보내기 실패");
			e.printStackTrace();
		} // end catch
	}// run

	private void fileSend(String fName, DataOutputStream dos) throws IOException {

		FileInputStream fis = null;

		try {
			String imgPath = "C:/dev/workspace/lunch_prj/src/kr/co/sist/lunch/admin/img/";

			fis = new FileInputStream(imgPath + fName);

			int fileLen = 0;
			int fileData = 0;

			byte[] readData = new byte[512];

			while ((fileLen = fis.read(readData)) != -1) {
				fileData++; // 몇개를 보낼 껀지
			} // end for

			fis.close();

			dos.writeInt(fileData);// 파일의 갯수
			dos.flush();

			dos.writeUTF(fName); // 파일명
			dos.flush();

			fis = new FileInputStream(imgPath + fName);

			while ((fileLen = fis.read(readData)) != -1) {
				dos.write(readData, 0, fileLen);
				dos.flush();
				fileData--;
			} // end while

		} finally {
//			if (dos != null) {
//				dos.close();
//			} // end if
			if (fis != null) {
				fis.close();
			} // end if
		} // end finally

	}// fileSend

}// class
