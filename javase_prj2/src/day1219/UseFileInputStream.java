package day1219;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author owner 하드 디스크에 존재하는 파일과 연결하여 그 내용을 읽어들일때 사용하는 클래스
 */
public class UseFileInputStream {

	public UseFileInputStream() throws IOException {
		File file = new File("c:/dev/temp/java_read.txt");

		if (file.exists()) {
			BufferedReader br = null;
			try {

				/**** 12-19-2018 : 8비트만 사용 - 한글 깨짐 ****/

//				/* 스트림 생성 : JVM에서 HDD의 파일과 연결 */
//				FileInputStream fis = new FileInputStream(file);
//				int temp = 0;
//
//				/* 읽어 */
//				while ((temp = fis.read()) != -1) {
//					System.out.print((char) temp);
//				}
//				// 스트림 닫기 //
//				fis.close();

				/**** 12-20-2018 코드추가 : 8비트+16비트 사용 - 한글 보기 ****/

				// 8비트 16비트 연결 : 한글이 깨지는 문제 해결 //
//				FileInputStream fis = new FileInputStream(file); // 파일 연결
//				InputStreamReader isr = new InputStreamReader(fis); // 8비트 16비트 연결
//				br = new BufferedReader(isr); // 속도 개선과 줄단위로 읽어드리는 기능 사용

				br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				String temp = "";
				while ((temp = br.readLine()) != null) { // 줄단위(\n전까지)로 읽고 내용이 있다면 출력 //
					System.out.println(temp);
				}

			} finally {
				/* br객체가 생성이 되어 있을 때만 실행 */
				if (br != null) {
					br.close();
				}
			} // 반드시 연결 종료 //

		} else {
			System.out.println("경로나 파일명을 확인하세요.");
		} // end if //
	}

	public static void main(String[] args) {
		try {
			new UseFileInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
