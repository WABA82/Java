package day1214;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/* JFrame 상속 및 ActionListener 구현 */
@SuppressWarnings("serial")
public class UseLineBorder extends JFrame implements ActionListener {

	/* 컴포넌트 선언 */
	private JButton jbutton1, jbutton2;

	public UseLineBorder() {

		super("LineBorder");

		/* 컴포넌트 생성 */
		jbutton1 = new JButton("확인");
		jbutton2 = new JButton("취소");

		/* 컨테이너컴포넌트 선언 및 생성 */
		JPanel panel = new JPanel();
		panel.add(jbutton1);
		panel.add(jbutton2);

		/* 라인보더 사용 */
		panel.setBorder(new LineBorder(Color.RED));

		/* 수동 배치 */
		setLayout(null);
		panel.setBounds(200, 350, 135, 40);
		add(panel);

		/* 이벤트 등록 */
		jbutton1.addActionListener(this);
		jbutton2.addActionListener(this);

		/* 프레임 크기설정 */
		setBounds(100, 100, 410, 450);
		setResizable(true);

		/* 종료활성화 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* 가시화 */
		setVisible(true);

	}

	/* ActionListener클래스 메소드 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbutton1) {
			new UseTitledBorder();
		}

		if (e.getSource() == jbutton2) {
			dispose();
		}
	}

	public static void main(String[] args) {
		new UseLineBorder();
	}

}
