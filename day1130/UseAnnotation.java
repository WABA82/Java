package day1130;


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
	
	public static void main(String[] args) {
		UseAnnotation ua = new UseAnnotation();
		ua.tess();
	}

}
