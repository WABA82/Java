package day1121;

/**
 * @author owner �޼ҵ� : �ߺ��ڵ带 �ּ�ȭ �Ҷ� ���
 */
public class UseMethod {

	// �ν��Ͻ� �޼ҵ� : �ν��Ͻ� ������ ����� �� ���.
	public void instMethod() {
		System.out.println("instance : ��üȭ�Ͽ� ����ϴ� method");
	}// instmethod

	// ����ƽ �޼ҵ� : �ν��Ͻ� ������ ������� ���� �� ���.
	public static void staticMethod() {
		System.out.println("static : ��üȭ ���� ���� ȣ���Ͽ� ����ϴ� method");
	}// static Method

	public static void main(String[] args) {
		// instMethod(); -- ��üȭ ���Ŀ� ��ü������ ȣ���� �� �ִ�.
		
		UseMethod um = new UseMethod(); //��Ʈ�Ͻ� �޼ҵ带 ����ϱ� ���� Ŭ������ ��üȭ
		um.instMethod();
		
//		um.staticMethod(); -- ����ƽ �޼ҵ�� Ư�� ��ü�� �����ִ� �޼ҵ尡 �ƴϹǷ� ��ü������ ȣ������ �ʴ´�.
		UseMethod.staticMethod();
		
		
		
	}

}
