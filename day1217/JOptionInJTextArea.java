package day1217;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JOptionInJTextArea {

	public static void main(String[] args) {
		/* 1.JTextArea����(���, �÷���) */
		JTextArea jta = new JTextArea(10, 40);
		/* 2. */
		JScrollPane jsp = new JScrollPane(jta);
		/* 3. MessageDialog�� �ι�° �Ű��� ������Ʈ�� �Ҵ� */
		JOptionPane.showMessageDialog(null, jsp);
	}

}
