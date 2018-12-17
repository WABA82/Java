package day1217;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JOptionInJTextArea {

	public static void main(String[] args) {
		/* 1.JTextArea생성(행수, 컬럼수) */
		JTextArea jta = new JTextArea(10, 40);
		/* 2. */
		JScrollPane jsp = new JScrollPane(jta);
		/* 3. MessageDialog의 두번째 매개에 컴포넌트를 할당 */
		JOptionPane.showMessageDialog(null, jsp);
	}

}
