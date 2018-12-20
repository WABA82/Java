package day1212;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         1. 추가를 누르면 이름, 나이, 주소를 List에 추가하고 텍스트필드를 초기화한다.<br>
 *         2. 리스트의 아이템을 클릭하면 선택한 값이 텍스트필드에 입력되어야 한다.<br>
 *         3. 변경을 누르면<br>
 *         리스트의 아이템이 텍스트 필드에 각각 나타나고(확인되고)<br>
 *         텍스트 필드의 값으로 해당 값을 수정한다.<br>
 *         4. 삭제를 누르면<br>
 *         리스트의 아이템이 텍스트 필드에 각각 나타나고(확인되고)<br>
 *         텍스트 필드의 값과 일치하는 아이템을 삭제한다.<br>
 *         5. 닫기를 누르면<br>
 *         프로그램 종료.<br>
 */

@SuppressWarnings("serial")
/* 윈도우 컴포넌트 상속받기 */
public class Work1212Design extends Frame {

	/* 일반 컴포넌트 선언 */
	Label nameLabel, ageLabel, addressLabel;
	TextField nameTextField, ageTextField, addressTextField;
	Button addButton, deleteButton, changeButton, closeButton;
	List dataList;

	/** 생성자 입니다 **/
	public Work1212Design() {

		super("1212숙제 입니다.");

		/* 컴포넌트 생성 */
		// 라벨 + 텍스트 필드
		nameLabel = new Label("이름", Label.CENTER);
		nameTextField = new TextField("이름텍스트필드");
		ageLabel = new Label("나이", Label.CENTER);
		ageTextField = new TextField("나이텍스트필드");
		addressLabel = new Label("주소", Label.CENTER);
		addressTextField = new TextField("주소텍스트필드");

		// 버튼
		addButton = new Button("추가");
		deleteButton = new Button("삭제");
		changeButton = new Button("변경");
		closeButton = new Button("닫기");

		// 리스트
		dataList = new List();

		/* 패널 선언 및 생성 */

		// 센터_왼쪽_그리드레이아웃 패널 : 라벨 + 텍스트필드 //
		Panel cenLeftPanel = new Panel();
		cenLeftPanel.setLayout(new GridLayout(3, 2));
		// 이름 컴포넌트 //
		cenLeftPanel.add(nameLabel);
		cenLeftPanel.add(nameTextField);
		// 나이 컴포넌트 //
		cenLeftPanel.add(ageLabel);
		cenLeftPanel.add(ageTextField);
		// 주소 컴포넌트 //
		cenLeftPanel.add(addressLabel);
		cenLeftPanel.add(addressTextField);

		// 센터를 이등분하는 그리드레이아웃의 패널 //
		Panel cenGridPanel = new Panel();
		cenGridPanel.setLayout(new GridLayout(1, 2));
		cenGridPanel.add(cenLeftPanel);
		cenGridPanel.add(dataList);

		// 아래_일반 패널 : 버튼 //
		Panel southPanel = new Panel();
		southPanel.add(addButton);
		southPanel.add(deleteButton);
		southPanel.add(changeButton);
		southPanel.add(closeButton);

		/* 배치 */
		add(BorderLayout.CENTER, cenGridPanel);
		add(BorderLayout.SOUTH, southPanel);

		/* 크기 설정 */
		setBounds(100, 100, 300, 150);

		/* 가시화 */
		setVisible(true);

		/* 종료 활성화 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		new Work1212Design();
	}

}
