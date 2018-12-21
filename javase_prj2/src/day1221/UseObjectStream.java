package day1221;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author owner<br>
 *         오브젝스트림 : UseData 객체를 생성하고 출력스트림을 통해 하드디스크에 파일로 내보내고 읽어 들이는 일.
 */
public class UseObjectStream {

	public void UseObjectOutputStream() throws IOException {

		File file = new File("c:/dev/temp/obj_data.dat");
		// 객체를 (JVM)를 직렬화하여 목적지(HDD)로 내보내는 스트림 //
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			UserData ud = new UserData(26, 70.1, "이재현");
			/* 객체를 직렬화 하여 스트림에 쓴다 */
			oos.writeObject(ud);
			oos.flush();
			System.out.println("객체를 파일로 기록 성공!!!");
		} finally {
			if (oos != null) {
				oos.close();
			}
		} // try~finally //

	}// UseObjectOutputStream //

	public void UseObjectInputStream() throws IOException, ClassNotFoundException {

		/* 객체를 읽기위한 스트림 열기 */
		ObjectInputStream ois = null;
		try {

			File file = new File("c:/dev/temp/obj_data.dat");
			/* File에 저장된 객체를 읽기위한 스트림 */
			ois = new ObjectInputStream(new FileInputStream(file));
			/* 스트림을 통해 직렬화된 객체를 얻어 재조립 */
			UserData ud = (UserData) ois.readObject();
			System.out.println("읽어온 객체의 값 이름 : " + ud.getName() + " /나이 : " + ud.getAge() + " /체중 : " + ud.getWeight());

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
