package day1130;


/**
 * @author owner<br>
 * JDK1.5���� ���� �߰��� annotation�� ���.
 * Deprecated, Override, SuppressWarnings
 */
public class UseAnnotation {

	@Deprecated
	public void tess() {
		System.out.println("���Ŀ� ������ �߻��� �޼ҵ�");
	}
	
	@Override
	public String toString() {
		return "�������ʸ�";
	}
	
	public static void main(String[] args) {
		UseAnnotation ua = new UseAnnotation();
		ua.tess();
	}

}
