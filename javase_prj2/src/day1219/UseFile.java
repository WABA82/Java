package day1219;

import java.io.File;
import java.io.IOException;

/**
 * @author owner<br>
 *         File 클래스 <br>
 *         -파일의 정보얻기<br>
 *         -디렉토리생성<br>
 *         -파일삭제<br>
 *
 */
public class UseFile {

	public UseFile() {
		String path = "c:/dev/temp/java_read.txt";

		/* 생성 */
		File file = new File(path);
		System.out.println(file);

		/* 파일존재 검증 */
		if (file.exists()) {
			System.out.println("절대경로 : " + file.getAbsolutePath());
			try {
				System.out.println("규범경로 : " + file.getCanonicalPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("일반경로 : " + file.getPath());
			System.out.println("폴더명 : " + file.getParent());
			System.out.println("파일명 : " + file.getName());
			System.out.println(file.isFile() ? "파일" : "디렉토리");
			System.out.println(file.isDirectory() ? "디렉토리" : "파일");
			System.out.println("파일의 길이 : " + file.length());
			System.out.println("실행가능 여부 : " + (file.canExecute() ? "실행가능" : "실행불가능"));
			System.out.println("읽기가능 여부 : " + (file.canRead() ? "실행가능" : "실행불가능"));
			System.out.println("쓰기가능 여부 : " + (file.canWrite() ? "실행가능" : "실행불가능"));
			System.out.println("파일숨김 여부 : " + (file.isHidden() ? "숨긴파일" : "일반파일"));
			System.out.println("마지막수정일 : " + file.lastModified());

		} else {
			System.out.println("경로를 확인해 주세요.");
		}
	}

	public static void main(String[] args) {
		new UseFile();
	}

}
