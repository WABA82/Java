package day1120;


/**
 * switch ~ case�� �̿��� ���� ���ϱ�
 * @author owner
 */
public class TestSwitchCase {
	
	public static final int GRADE_A_PLUS = 10;
	public static final int GRADE_A = 9;
	public static final int GRADE_B = 8;
	public static final int GRADE_C = 7;
	public static final int GRADE_D = 6;
	
	public static void main(String[] args) {
		
		int score = 40;
//		char grade = ' ';
		char grade = 64;
		
		if ( score >= 0 && score <= 100) {
			switch ( score / 10 ) {

			case TestSwitchCase.GRADE_D : grade++;
			case TestSwitchCase.GRADE_C : grade++;
			case TestSwitchCase.GRADE_B : grade++;
			case TestSwitchCase.GRADE_A :
			case TestSwitchCase.GRADE_A_PLUS : grade++; break;
			default : grade += 6;
		
			/* case�� ����� �������� �������� ������ Constant�� ���.
			 * case 6 : 
				grade++;
			case 7 : 
				grade++;
			case 8 : 
				grade++;
			case 9 : 
			case 10 :
				grade++;
				break;
			default :
				grade += 6;*/
			
//			case 10:
//			case 9 :
//				grade = 'A';
//				break;
//			case 8 :
//				grade = 'B';
//				break;
//			case 7 :
//				grade = 'C';
//				break;
//			case 6 :
//				grade = 'D';
//				break;
//			default : 
//				grade = 'F';

			}//end switch
			System.out.println(score + " ���� ������ " + grade);
		} else {
			System.out.println("������ 0 ~ 100�� ���̸� �Է� ���� �մϴ�.");
		}// end if

	}//main

}//class
