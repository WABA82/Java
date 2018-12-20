package day1220;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * @author owner<br>
 *         JVM에서 발생한 데이터가 정수, byte[]인 경우 File로 저장하는 FileOutputStream의 사용.
 *
 */
public class UseFileOutputStream {

	public void useFileOutputStream() throws IOException {
		int i = 65;

		/* File 생성 */
		File file = new File("c:/dev/temp/java_write.txt");

		/* FileOutputStream 생성 : 입력된 경로에 파일이 생성 - 만약 같은 이름의 파일이 있다면 덮어쓴다. */
		FileOutputStream fos = null;

		try {
			boolean flag = false;

			if (file.exists()) {
				boolean[] temp = { false, true, true };
				int select = JOptionPane.showConfirmDialog(null, "덮어쓰시겠습니까?");
				flag = temp[select];
			}

			if (!flag) {
				fos = new FileOutputStream(file);
				fos.write(i); // 수의 문자가 출력된다.//
				fos.flush();
				System.out.println("파일기록완료!");
			}
	
		} finally {
			if (fos != null) {
				/* 스트림에 기록된 내용이 있다면, 분출하고 연결을 끊는다. */
				fos.close();
			}
		}
	}

	public static void main(String[] args) {
		UseFileOutputStream ufos = new UseFileOutputStream();
		try {
			ufos.useFileOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}// 메인 메소드 //

}// 클래스 //
