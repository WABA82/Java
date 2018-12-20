package day1220;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * @author owner<br>
 *         JVM���� �߻��� �����Ͱ� ����, byte[]�� ��� File�� �����ϴ� FileOutputStream�� ���.
 *
 */
public class UseFileOutputStream {

	public void useFileOutputStream() throws IOException {
		int i = 65;

		/* File ���� */
		File file = new File("c:/dev/temp/java_write.txt");

		/* FileOutputStream ���� : �Էµ� ��ο� ������ ���� - ���� ���� �̸��� ������ �ִٸ� �����. */
		FileOutputStream fos = null;

		try {
			boolean flag = false;

			if (file.exists()) {
				boolean[] temp = { false, true, true };
				int select = JOptionPane.showConfirmDialog(null, "����ðڽ��ϱ�?");
				flag = temp[select];
			}

			if (!flag) {
				fos = new FileOutputStream(file);
				fos.write(i); // ���� ���ڰ� ��µȴ�.//
				fos.flush();
				System.out.println("���ϱ�ϿϷ�!");
			}
	
		} finally {
			if (fos != null) {
				/* ��Ʈ���� ��ϵ� ������ �ִٸ�, �����ϰ� ������ ���´�. */
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

	}// ���� �޼ҵ� //

}// Ŭ���� //
