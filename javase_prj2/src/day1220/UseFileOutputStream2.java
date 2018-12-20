package day1220;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

/**
 * @author owner<br>
 *         8비트 스트림과 16비트 스트림을 사용하여 문자열 데이터를 파일에 기록합니다.
 */
public class UseFileOutputStream2 {

	public UseFileOutputStream2() throws IOException {
		String data = "오지고요 지리고요 고요고요 고요한 밤이고요.";

		/* File객체 생성 : 파일이 존재한다면 덮어 쓸 것인지 판단하기 위한 용도. */
		File file = new File("c:/dev/temp/java_write2.txt");

		boolean flag = false;
		if (file.exists()) { // 파일이 존재할때 //
			boolean[] temp = { false, true, true }; // 예, 아니오, 취소 //
			flag = temp[JOptionPane.showConfirmDialog(null, "덮어쓰시겠습니까?")];
		}
		/* 스트림 생성 */
		if (!flag) {
			BufferedWriter bw = null;
			try {
				/* 파일을 생성하는 스트림 : 폴더가 없을 때 FileNotFound예외 발생 */
				FileOutputStream fos = new FileOutputStream(file);
				/* 문자열을 쓰기 위한 스트림생성 */
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				/* 속도 개선을 위한 스트림생성 */
				bw = new BufferedWriter(osw);
				bw.write(data);
				bw.flush();
				System.out.println("파일에 기록완료");
			} finally {
				/* 스트림객체가 생성 되어있을 때 */
				if (bw != null) {
					bw.close();
				}
			}
		} // end if //

	}// UseFileOutputStream2 //

	public static void main(String[] args) {
		try {
			new UseFileOutputStream2();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
