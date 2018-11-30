package day1130;

import java.util.ArrayList;
import java.util.List;

/**
 * @author owner<br>
 * JDK1.5에서 부터 추가된 annotation의 사용.
 * Deprecated, Override, SuppressWarnings
 */
public class UseAnnotation {

	@Deprecated
	public void tess() {
		System.out.println("차후에 문제가 발생될 메소드");
	}
	
	@Override
	public String toString() {
		return "은뇨쇼초몬도";
	}
	
	public void temp() {
		//unused 변수를 사용하지 않을때 경고 무시
		@SuppressWarnings("unused")
		int i=0;
		
		//rawtype : 제네릭을 사용하지 않을 때 경고 무시
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
