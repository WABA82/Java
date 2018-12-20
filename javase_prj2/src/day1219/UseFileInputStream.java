package day1219;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author owner �ϵ� ��ũ�� �����ϴ� ���ϰ� �����Ͽ� �� ������ �о���϶� ����ϴ� Ŭ����
 */
public class UseFileInputStream {

	public UseFileInputStream() throws IOException {
		File file = new File("c:/dev/temp/java_read.txt");

		if (file.exists()) {
			BufferedReader br = null;
			try {

				/**** 12-19-2018 : 8��Ʈ�� ��� - �ѱ� ���� ****/

//				/* ��Ʈ�� ���� : JVM���� HDD�� ���ϰ� ���� */
//				FileInputStream fis = new FileInputStream(file);
//				int temp = 0;
//
//				/* �о� */
//				while ((temp = fis.read()) != -1) {
//					System.out.print((char) temp);
//				}
//				// ��Ʈ�� �ݱ� //
//				fis.close();

				/**** 12-20-2018 �ڵ��߰� : 8��Ʈ+16��Ʈ ��� - �ѱ� ���� ****/

				// 8��Ʈ 16��Ʈ ���� : �ѱ��� ������ ���� �ذ� //
//				FileInputStream fis = new FileInputStream(file); // ���� ����
//				InputStreamReader isr = new InputStreamReader(fis); // 8��Ʈ 16��Ʈ ����
//				br = new BufferedReader(isr); // �ӵ� ������ �ٴ����� �о�帮�� ��� ���

				br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				String temp = "";
				while ((temp = br.readLine()) != null) { // �ٴ���(\n������)�� �а� ������ �ִٸ� ��� //
					System.out.println(temp);
				}

			} finally {
				/* br��ü�� ������ �Ǿ� ���� ���� ���� */
				if (br != null) {
					br.close();
				}
			} // �ݵ�� ���� ���� //

		} else {
			System.out.println("��γ� ���ϸ��� Ȯ���ϼ���.");
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
