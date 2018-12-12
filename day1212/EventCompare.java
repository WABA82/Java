package day1212;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         컴포넌트의 주소를 비교하는 메소드 : getSource(); 컴포넌트의 라벨의 내용을 비교하는 메소드 :
 *         getActionCommand(); - action리스너에서만 사용할 수 있다.
 */
@SuppressWarnings("serial")
/* 윈도 컴포넌트 상속, 액션리스너 구현하기 */
public class EventCompare extends Frame implements ActionListener {

	/* 컴포넌트 선언 */
	private Button btnOpen;
	private Button btnSave;
	private Label lblOutput;

	public EventCompare() {

		super("파일다이얼로그 사용");

		/* 생성 */
		btnOpen = new Button("열기모드");
		btnSave = new Button("저장모드");
		lblOutput = new Label("출력창 : ");

		/* 배치 */
		Panel panel = new Panel(); // 컨테이너컴포넌트 생성 : 컴포넌트를 담을 수 있다.
		panel.add(btnOpen);
		panel.add(btnSave);

		add(BorderLayout.CENTER, panel);
		add(BorderLayout.SOUTH, lblOutput);

		/* 이벤트 등록 */
		btnOpen.addActionListener(this);
		btnSave.addActionListener(this);

		/* 크기설정 */
		setBounds(100, 100, 500, 100);

		/* 가시화 */
		setVisible(true);

		/* 종료버튼 활성화 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/* 주소로 비교하는 방법입니다. */
		System.out.println("컴포넌트의 주소" + e);
		// 스위치 케이스는 객체를 받지 못합니다. //
		if (e.getSource() == btnOpen) {
			System.out.println("열기" + e);
		}

		if (e.getSource() == btnSave) {
			System.out.println("저장" + e);
		}

		/* 라벨로 비교하기 */
		System.out.println("이벤트 발생 객체의 Label : " + e.getActionCommand());
		String label = e.getActionCommand();

		if (label.equals("열기모드")) {
			System.out.println("열기모드를 클릭했습니다.");

			/* 파일다이얼로그 생성 및 선언 */
			FileDialog fdOpen = new FileDialog(this, "열기", FileDialog.LOAD);
			/* 파일다이얼로그 가시화 */
			fdOpen.setVisible(true);

			/* 파일경로 와 타이틀 정보가져오기 */
			String path = fdOpen.getDirectory();
			String name = fdOpen.getFile();

			/* 선택한 파일이 있을 때만 아래의 코드 실행(주소와 타이틀 출력) */
			if (name != null) {
				lblOutput.setText("열기파일 : " + path + name);
				// 타이블바의 내용 변경.
				setTitle("파일다이얼로그 사용 - 열기 : " + name);
				lblOutput.setText("열기파일 : ");
			}
		}

		if (label.equals("저장모드")) {
			System.out.println("열기모드를 클릭했습니다.");
			/* 파일다이얼로그 생성 및 선언 */
			FileDialog fdSave = new FileDialog(this, "저장", FileDialog.SAVE);
			/* 파일다이얼로그 가시화 */
			fdSave.setVisible(true);

			/* 파일경로 와 타이틀 정보가져오기 */
			String path = fdSave.getDirectory();
			String name = fdSave.getFile();

			/* 선택한 파일이 있을 때만 아래의 코드 실행(주소와 타이틀 출력) */
			if (name != null) {
				lblOutput.setText("열기파일 : " + path + name);
				// 타이블바의 내용 변경.
				setTitle("파일다이얼로그 사용 - 열기 : " + name);
			}
		}
	}

	public static void main(String[] args) {
		new EventCompare();
	}

}
