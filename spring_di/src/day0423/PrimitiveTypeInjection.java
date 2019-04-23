package day0423;

public class PrimitiveTypeInjection {

	public PrimitiveTypeInjection(int i) {
		System.out.println("기본형 데이터형을 매개변수 Injection i = " + i);
	}// PrimitiveTypeInjection

	public PrimitiveTypeInjection(long l) {
		System.out.println("기본형 long을 매개변수 Injection l = " + l);
	}// PrimitiveTypeInjection

	public PrimitiveTypeInjection(String str) {
		System.out.println("String을 매개변수 Injection str = " + str);
	}// PrimitiveTypeInjection

}// class
