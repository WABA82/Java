package day1130;

import java.util.ArrayList;
import java.util.List;

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
	
	public void temp() {
		//unused ������ ������� ������ ��� ����
		@SuppressWarnings("unused")
		int i=0;
		
		//rawtype : ���׸��� ������� ���� �� ��� ����
		@SuppressWarnings({"rawtypes", "unused"})
		List l = new ArrayList();
		
		int j=0;
		System.out.println("temp j = " + j);
	}
	
	public static void main(String[] args) {
		UseAnnotation ua = new UseAnnotation();
		ua.tess();
	}

}
