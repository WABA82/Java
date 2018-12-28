package day1219;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/*
 * ���α׷��� ����Ǹ� "���丮�� �Է� : " �޼����� ��µ˴ϴ�. 
 * ����ڰ� ���丮 "��) c:/dev" �� �Է����� �� 
 * ���丮���  �ش� ���丮�� ���� ������ JOptionPane.showMessageDioalog�� ��� �ϴ� ���α׷� �ۼ�
 * ��� 
 * �̸�           ����   ũ��        ���������� �����ѳ�¥
 * apis           ����    
 * test.java     ����   164byte    yyyy-MM-dd a hh:mm
 * ���丮�� �ƴ϶�� "������ ������� �ʽ��ϴ�." console���
*/
public class Wk1FileFinder {

	/* �ν��Ͻ� ���� ���� */
	String inputPath; // �Է°��� ������ ���� : BufferedReader�� �� ����

	/* ������ */
	public Wk1FileFinder() {
		/* �޽��� ��� */
		System.out.println("���丮 �Է� : ex) c:/dev/temp");
		try { // try~catch ���� //

			/* IO��Ʈ�� ���� */
			BufferedReader bufferedR = new BufferedReader(new InputStreamReader(System.in));
			inputPath = bufferedR.readLine(); // ���� : �Էµ� ��(�������) ���� //
			bufferedR.close(); // ��Ʈ�� �ݱ� //

			/* File�� ��ü ����(inputPath) */
			File file = new File(inputPath);

			/* StringBuilder ���� */
			StringBuilder view = new StringBuilder();
			view.append("���\n[�̸�]\t [����]\t [ũ��]\t [������¥]\n")
					.append("-------------------------------------------------------------------------------");

			/* if�� : ���ϰ�ü ���� �˻� (���� or ���丮) */
			if (file.isDirectory()) {

				JTextArea printTextArea = new JTextArea(10, 50);
				printTextArea.append(view.toString());
				JScrollPane hasPrintTextArea = new JScrollPane(printTextArea);
				JOptionPane.showMessageDialog(null, hasPrintTextArea);

			} else {
				System.out.println("���丮�� �Է� �����մϴ�.");
			} // end if //

		} catch (IOException e) {
			e.printStackTrace();
		} // try~catch ���� //
	} // ������ ���� //

	public static void main(String[] args) {
		new Wk1FileFinder();
	}

}