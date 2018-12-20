package day1220;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author owner<br>
 *         FileReader : 16비트 스트림 사용 - 파일 읽기.
 */
public class UseFileReader {

	public UseFileReader() throws IOException {

		/* 버퍼스티림 선언 */
		BufferedReader br = null;

		try {
			File file = new File("c:/dev/temp/java_read.txt");
			/* 근원지 파일에 스트림 연결 */
			FileReader fileReader = new FileReader(file);
			/* 버퍼스트림 생성 has (fileReader) : 줄단위로 읽어오는 기능 */
			br = new BufferedReader(fileReader);

			String readline = "";
			while ((readline = br.readLine()) != null) {
				System.out.println(readline);
			}
		} finally {
			if (br != null) {
				br.close();
			} // end if //
		} // finally //

	}

	public static void main(String[] args) {
		try {
			new UseFileReader();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
