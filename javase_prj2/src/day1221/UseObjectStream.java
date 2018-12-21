package day1221;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author owner<br>
 *         ��������Ʈ�� : UseData ��ü�� �����ϰ� ��½�Ʈ���� ���� �ϵ��ũ�� ���Ϸ� �������� �о� ���̴� ��.
 */
public class UseObjectStream {

	public void UseObjectOutputStream() throws IOException {

		File file = new File("c:/dev/temp/obj_data.dat");
		// ��ü�� (JVM)�� ����ȭ�Ͽ� ������(HDD)�� �������� ��Ʈ�� //
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			UserData ud = new UserData(26, 70.1, "������");
			/* ��ü�� ����ȭ �Ͽ� ��Ʈ���� ���� */
			oos.writeObject(ud);
			oos.flush();
			System.out.println("��ü�� ���Ϸ� ��� ����!!!");
		} finally {
			if (oos != null) {
				oos.close();
			}
		} // try~finally //

	}// UseObjectOutputStream //

	public void UseObjectInputStream() throws IOException, ClassNotFoundException {

		/* ��ü�� �б����� ��Ʈ�� ���� */
		ObjectInputStream ois = null;
		try {

			File file = new File("c:/dev/temp/obj_data.dat");
			/* File�� ����� ��ü�� �б����� ��Ʈ�� */
			ois = new ObjectInputStream(new FileInputStream(file));
			/* ��Ʈ���� ���� ����ȭ�� ��ü�� ��� ������ */
			UserData ud = (UserData) ois.readObject();
			System.out.println("�о�� ��ü�� �� �̸� : " + ud.getName() + " /���� : " + ud.getAge() + " /ü�� : " + ud.getWeight());

		} finally {
			if (ois != null) {
				ois.close();
			}
		}

	}// UseObjectInputStream //

	public static void main(String[] args) {

		UseObjectStream uos = new UseObjectStream();
		try {
			uos.UseObjectOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("----------------------------------");

		try {
			uos.UseObjectInputStream();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}// main //
}// class //
