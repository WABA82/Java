package day1217;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/* 
 * 1-1. ���α׷��� ���۵Ǹ� �޴� ����. j�ɼ���(inputDialog)
 * 1-2. 1�� �ְ� �Է��� ������ input Dialog�� ������ inputDialog
 * 1-3. ����� ������ List�� ����� ��� 0�̸� MessageDialog�� "�����Ͱ� �����ϴ�" ���.
 * 
 */
@SuppressWarnings("serial")
public class Work1217 extends JFrame implements ActionListener {

	/* �ν��Ͻ����� ���� */
	JButton inputButton;

	public Work1217() {

	}

	/* �׼Ǹ����� �޼ҵ� */
	@Override
	public void actionPerformed(ActionEvent e) {
	}

	/* inner class */
	public class Evt extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {

		}
	}
	/* inner class */

	public static void main(String[] args) {
		new Work1217();
	}

}
