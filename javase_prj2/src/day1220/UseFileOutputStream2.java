package day1220;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

/**
 * @author owner<br>
 *         8��Ʈ ��Ʈ���� 16��Ʈ ��Ʈ���� ����Ͽ� ���ڿ� �����͸� ���Ͽ� ����մϴ�.
 */
public class UseFileOutputStream2 {

	public UseFileOutputStream2() throws IOException {
		String data = "������� ������� ����� ����� ���̰��.";

		/* File��ü ���� : ������ �����Ѵٸ� ���� �� ������ �Ǵ��ϱ� ���� �뵵. */
		File file = new File("c:/dev/temp/java_write2.txt");

		boolean flag = false;
		if (file.exists()) { // ������ �����Ҷ� //
			boolean[] temp = { false, true, true }; // ��, �ƴϿ�, ��� //
			flag = temp[JOptionPane.showConfirmDialog(null, "����ðڽ��ϱ�?")];
		}
		/* ��Ʈ�� ���� */
		if (!flag) {
			BufferedWriter bw = null;
			try {
				/* ������ �����ϴ� ��Ʈ�� : ������ ���� �� FileNotFound���� �߻� */
				FileOutputStream fos = new FileOutputStream(file);
				/* ���ڿ��� ���� ���� ��Ʈ������ */
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				/* �ӵ� ������ ���� ��Ʈ������ */
				bw = new BufferedWriter(osw);
				bw.write(data);
				bw.flush();
				System.out.println("���Ͽ� ��ϿϷ�");
			} finally {
				/* ��Ʈ����ü�� ���� �Ǿ����� �� */
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
