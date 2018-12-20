package day1220;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author owner<br>
 *         FileReader : 16��Ʈ ��Ʈ�� ��� - ���� �б�.
 */
public class UseFileReader {

	public UseFileReader() throws IOException {

		/* ���۽�Ƽ�� ���� */
		BufferedReader br = null;

		try {
			File file = new File("c:/dev/temp/java_read.txt");
			/* �ٿ��� ���Ͽ� ��Ʈ�� ���� */
			FileReader fileReader = new FileReader(file);
			/* ���۽�Ʈ�� ���� has (fileReader) : �ٴ����� �о���� ��� */
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
