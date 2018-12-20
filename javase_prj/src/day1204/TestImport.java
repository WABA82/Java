package day1204;

import java.util.Date;
import java.util.List;
//import java.awt.List; 패키지는 다르나 이름이 같은 클래스는 둘중 하나만 import받을 수 있습니다.
import java.util.Random;

/**
 * @author owner<br>
 *         import : 다른 패키지의 클래스를 참조하여 사용할 때.
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

		// awtl패키지 full path로 작성한다.
		java.awt.List list = null;
		// util패키지
		List list1 = null;

	}

}
