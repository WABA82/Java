package day1212;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;

@SuppressWarnings("serial")
/* 윈도우컴포넌트 상속 */
public class FriendListHasA extends Frame {
	/* 컴포넌트 선언 */
	private Label lbl1, lbl2;
	private List listFriend, listBlockFriend;
	private Button btnToBlockAll, btnToFriendAll;

	public FriendListHasA() {
		super("친구관리");

		/* 컴포넌트 생성 */
		lbl1 = new Label("친구 목록");
		lbl2 = new Label("차단된 친구");

		listFriend = new List();
		listBlockFriend = new List();
		listFriend.add("이재찬");
		listFriend.add("정택성");
		listFriend.add("이재현");
		listFriend.add("정택성");

		btnToBlockAll = new Button(">>");
		btnToFriendAll = new Button("<<");

		/* 크기 및 위치 설정 */
		setLayout(null);
		lbl1.setBounds(80, 100, 150, 50);
		lbl2.setBounds(355, 100, 150, 50);
		listFriend.setBounds(30, 150, 150, 200);
		listBlockFriend.setBounds(320, 150, 150, 200);
		btnToBlockAll.setBounds(225, 200, 50, 30);
		btnToFriendAll.setBounds(225, 250, 50, 30);

		add(lbl1);
		add(lbl2);
		add(listFriend);
		add(listBlockFriend);
		add(btnToBlockAll);
		add(btnToFriendAll);

		/* 이벤트 등록 */
		// 디자인클래스와 이벤트처리 클래스는 has a관계 //
		EventFriendsListHasA fle = new EventFriendsListHasA(this);
		btnToBlockAll.addActionListener(fle);
		btnToFriendAll.addActionListener(fle);

		listBlockFriend.addItemListener(fle);
		listFriend.addItemListener(fle);

		/* 종료 활성화 : 이벤트클래스에서 만들기 */
		addWindowListener(fle);

		/* 프레임의 크기설정 */
		setBounds(200, 200, 500, 400);
		setResizable(false);

		/* 가시화 */
		setVisible(true);
	}

	public Label getLbl1() {
		return lbl1;
	}

	public Label getLbl2() {
		return lbl2;
	}

	public List getListFriend() {
		return listFriend;
	}

	public List getListBlockFriend() {
		return listBlockFriend;
	}

	public Button getBtnToBlockAll() {
		return btnToBlockAll;
	}

	public Button getBtnToFriendAll() {
		return btnToFriendAll;
	}

	public static void main(String[] args) {
		new FriendListHasA();
	}// main

}// class
