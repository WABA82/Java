package day1121.sub;

/**
 * Instance Variable�� Access Modifier ���
 * public : Ŭ���� �ܺο��� ���ٰ��� 
 * protected : ���� ��Ű������ ���ٰ���, ��Ű���� �ٸ��� ��Ӱ�����
 * 				  �ڽ� Ŭ������ ���ٰ���
 * privat : Ŭ���� �ȿ����� ���ٰ���
 * default : ���� ��Ű������ ���ٰ���, ��Ű���� �ٸ��� ���ٺҰ�
 *  
 * @author Owner
 */
public class InstAccModifi {
	public int pub_i;
	protected int pro_i;
//	private int pri_i;
	int def_i; 
	
	public static void main(String[] args) {
		//��üȭ
		InstAccModifi ivam=new InstAccModifi();
		//������ ������ �ִ� Ŭ���� �ȿ��� ��üȭ�� �Ǹ� ���������ڿ�
		//������� ��λ��
		System.out.println("public : "+ ivam.pub_i);
		System.out.println("protected : "+ ivam.pro_i);
//		System.out.println("private : "+ ivam.pri_i);
//		System.out.println("default : "+ ivam.def_i);
		
		
	}//main

}//class
