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
 * 1-1. 프로그램이 시작되면 메뉴 제공. j옵션팬(inputDialog)
 * 1-2. 1을 넣고 입력을 누르면 input Dialog를 누르면 inputDialog
 * 1-3. 출력을 누르면 List의 사이즈를 얻고 0이면 MessageDialog로 "데이터가 없습니다" 출력.
 * 
 */
@SuppressWarnings("serial")
public class Work1217 extends JFrame implements ActionListener {

	/* 인스턴스변수 선언 */
	JButton inputButton;

	public Work1217() {

	}

	/* 액션리스너 메소드 */
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
