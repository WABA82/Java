package day1213;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         프레임 클래스에서 다이얼로그클래스를 Is a 관계로 사용
 */
@SuppressWarnings("serial")
/* 상속받기 */
public class UseDialogIsA extends Frame implements ActionListener {

	private Button btn1;// Frame에 배치

	/* 생성자 */
	public UseDialogIsA() {
		super("다이얼로그 만들고 사용하기");

		/* 일반 컴포넌트 생성 */
		btn1 = new Button("다이얼로그 사용 ");

		/* 배치 */
		Panel panel = new Panel();
		panel.add(btn1);
		add(panel);

		/* 이벤트등록 : btn1을 클릭하면 다이얼로그 창이 띄워진다. */
		btn1.addActionListener(this);

		/* 크기 설정 */
		setBounds(100, 100, 300, 400);

		/* 종료 이벤트 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});

		/* 가시화 */
		setVisible(true);

	}

	@Override
	/* ActionListener의 메소드 : */
	public void actionPerformed(ActionEvent e) {
		creatDialog();
	}

	public void creatDialog() {
		new DialogIsA(this);
	}

	public static void main(String[] args) {
		new UseDialogIsA();
	}

}
