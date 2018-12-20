package day1210;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author owner<br>
 *         플로우 레이아웃과 컴포넌트의 사용.
 *
 */
//1.윈도우 컴포너트 상속. 

@SuppressWarnings("serial")
public class UseFlowLayout extends Frame {

	public UseFlowLayout() {

		super("FlowLayout 연습");
		// 2.일반컴포넌트의 생성.
		Label lblName = new Label("이름");
		TextField tfName = new TextField(10);
		Button btn = new Button("입력");
		List list = new List();
		list.add("정택성");
		list.add("이재현");
		list.add("김정운");
		list.add("김정윤");
		list.add("이재찬");

		Checkbox checkbox1 = new Checkbox("등산", false);
		Checkbox checkbox2 = new Checkbox("댄스", false);
		Checkbox checkbox3 = new Checkbox("게임", false);

		// 라디오 버튼
		CheckboxGroup cg = new CheckboxGroup();
		Checkbox rb1 = new Checkbox("남자", true, cg);
		Checkbox rb2 = new Checkbox("여자", false, cg);

		// 3. 레이아웃변경;
		setLayout(new FlowLayout());

		// 4. 일반컨포넌트 배치
		add(lblName);
		add(tfName);
		add(btn);
		add(list);
		add(checkbox1);
		add(checkbox2);
		add(checkbox3);
		add(rb1);
		add(rb2);

		// 5. 윈도우의 크기 설정
		setSize(400, 300);

		// 6. 가시화
		setVisible(true);

		// 7. 종료 활성화
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		new UseFlowLayout();
	}

}
