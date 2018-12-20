package day1218;

/**
 * @author owner<br>
 *         객체 복제 : 복제되는 객체는 Cloneable인터페이스를 반드시 구현해야 합니다.
 *
 */
public class ObjectClone implements Cloneable {

	private int i;

	public static void main(String[] args) {
		ObjectClone oc = new ObjectClone();
		oc.i = 100;

		try {
			ObjectClone oc1 = (ObjectClone) oc.clone();
			System.out.println("복제 성공");
			System.out.println("원본 : " + oc + "/ 복제본 : " + oc1);
			oc.i = 200;
			System.out.println("원본 : " + oc.i + "/ 복제본" + oc1.i);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

	} // 메인 메소드 //

} // 클래스 //
