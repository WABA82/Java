package day1119;


/**
 * switch ~ case : ������ ���� ��. ���ڿ��� �����ϴ�. <br>
 * ����) 
 * 		switch(������) {<br>
 * 			case ��� : ���๮��;<br>
 * 			case ��� : ���๮��;<br>
 * 			case ��� : ���๮��;<br>
 * 			case ��� : ���๮��;<br>
 * 							<br>
 * 			default : ��ġ�ϴ� ����� ���� �� ���๮��;<br>
 * 		}
 * 
 * @author owner
 */
public class TestSwitchCase {

	public static void main(String[] args) {
		

		String i = "1"; // JDK1.7 �̻󿡼��� String�� switch������ ����� �� �ֽ��ϴ�.

		//switch�� �ԷµǴ� ������ ���������� byte, short, int, char
		switch (i) {
		//case�� �ԷµǴ� ������ ���� �ٸ� ������ ������.
		case "0" :
			System.out.println("����");
			break;
		case "1":
			System.out.println("��ħ");
			break;
		case "2":
			System.out.println("����");
			break;
		default:
			System.out.println("����");
		}// end switch

	}// main

}// class
