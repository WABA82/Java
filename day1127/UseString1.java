package day1127;

public class UseString1 {
	// �̸����� �Է¹޾� �̸����� ��ȿ��(5�� �̻��̰� "@"�� "."�� �־�� �Ѵ�.)�� �����Ͽ� �Ҹ������� ����� ����� ��ȯ�ϴ� ���� �ϴ� �޼ҵ带 ����� ȣ���Ͽ� ����غ���.
	private boolean emailChecker(String email) {
		boolean flag;
		return  flag = (email.length() > 5 && email.contains("@") && email.contains("."));
	}// �̸���üĿ �޼ҵ� ����
	
	public static void main(String[] args) {
		//��üȭ
		UseString1 us1 = new UseString1();
		
		String email = "fkrkeifj@naver.com";
		
		//
		if (us1.emailChecker(email)) {
			System.out.println(email + "�� ��ȿ");
		}else
			System.out.println(email + "�� ��ȿ");
		
	}// ���� �޼ҵ�

}// Ŭ���� �ʵ�
