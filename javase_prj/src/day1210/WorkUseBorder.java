package day1210;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class WorkUseBorder extends Frame {

	public WorkUseBorder() {
		super("자동배치 숙제 입니다.");

		/* 일반구성 생성 */
		// 북쪽 - 판넬 //
		Label titleLabel = new Label("학생 관리");

		// 센터 - 왼쪽 - 판넬 //
		Label nameLabel = new Label("이름");
		TextField nameField = new TextField();
		Label ageLabel = new Label("나이");
		TextField ageField = new TextField();
		Label telLabel = new Label("전화번호");
		TextField telField = new TextField();
		Label genderlabel = new Label("성별");
		CheckboxGroup gender = new CheckboxGroup();
		Checkbox maleChbox = new Checkbox("남자", true, gender);
		Checkbox femaleChbox = new Checkbox("여자", true, gender);
		Panel genderBoxpanel = new Panel(); // 라디오체크박스 판넬에 담기
		genderBoxpanel.add(maleChbox);
		genderBoxpanel.add(femaleChbox);

		// 센터 - 오른쪽 - 판넬 //
		TextArea textArea = new TextArea();

		// 남쪽 - 판넬 //
		Button button1 = new Button("추가");
		Button button2 = new Button("변경");
		Button button3 = new Button("삭제");
		Button button4 = new Button("종료");

		/* 컨테이너구성 생성 및 컴포넌트 추가 */
		// 맨위쪽 //
		Panel northPanel = new Panel();
		northPanel.add(titleLabel);

		// 센터 - 왼쪽 //
		Panel leftCenterPanel = new Panel();
		leftCenterPanel.setLayout(new GridLayout(4, 2));
		leftCenterPanel.add(nameLabel);
		leftCenterPanel.add(nameField);
		leftCenterPanel.add(ageLabel);
		leftCenterPanel.add(ageField);
		leftCenterPanel.add(telLabel);
		leftCenterPanel.add(telField);
		leftCenterPanel.add(genderlabel);
		leftCenterPanel.add(genderBoxpanel);

		// 센터 - 오른쪽 //
//		Panel rightCenterPanel = new Panel();
//		rightCenterPanel.add(textArea);
//		rightCenterPanel.setLayout(new FlowLayout());

		Panel centerGridPanel = new Panel();
		centerGridPanel.setLayout(new GridLayout(1, 2));
		centerGridPanel.add(leftCenterPanel);
		centerGridPanel.add(textArea);

		// 아래쪽 //
		Panel southPanel = new Panel();
		southPanel.add(button1);
		southPanel.add(button2);
		southPanel.add(button3);
		southPanel.add(button4);

		/* 배치매니저 설정 */
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, northPanel);
		add(BorderLayout.CENTER, centerGridPanel);
		add(BorderLayout.SOUTH, southPanel);

		/* 크기 및 위치 설정 */
		setSize(250, 250);
//		setBounds(x, y, width, height);

		/* 가시화 */
		setVisible(true);

		/* 종료 활성화 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		new WorkUseBorder();
	}

}
