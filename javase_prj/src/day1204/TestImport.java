package day1204;

import java.util.Date;
import java.util.List;
//import java.awt.List; ��Ű���� �ٸ��� �̸��� ���� Ŭ������ ���� �ϳ��� import���� �� �ֽ��ϴ�.
import java.util.Random;

/**
 * @author owner<br>
 *         import : �ٸ� ��Ű���� Ŭ������ �����Ͽ� ����� ��.
 */
public class TestImport {

	public static void main(String[] args) {
		Random r = new Random();
		Random r1 = new Random();
		Random r2 = new Random();
		Random r3 = new Random();

		System.out.println(r.nextInt(15));
		System.out.println(r1.nextInt(15));
		System.out.println(r2.nextInt(15));
		System.out.println(r3.nextInt(15));

		Date d = new Date();

		System.out.println(d.getTime());

		// awtl��Ű�� full path�� �ۼ��Ѵ�.
		java.awt.List list = null;
		// util��Ű��
		List list1 = null;

	}

}
