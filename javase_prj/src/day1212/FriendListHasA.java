package day1212;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;

@SuppressWarnings("serial")
/* ������������Ʈ ��� */
public class FriendListHasA extends Frame {
	/* ������Ʈ ���� */
	private Label lbl1, lbl2;
	private List listFriend, listBlockFriend;
	private Button btnToBlockAll, btnToFriendAll;

	public FriendListHasA() {
		super("ģ������");

		/* ������Ʈ ���� */
		lbl1 = new Label("ģ�� ���");
		lbl2 = new Label("���ܵ� ģ��");

		listFriend = new List();
		listBlockFriend = new List();
		listFriend.add("������");
		listFriend.add("���ü�");
		listFriend.add("������");
		listFriend.add("���ü�");

		btnToBlockAll = new Button(">>");
		btnToFriendAll = new Button("<<");

		/* ũ�� �� ��ġ ���� */
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

		/* �̺�Ʈ ��� */
		// ������Ŭ������ �̺�Ʈó�� Ŭ������ has a���� //
		EventFriendsListHasA fle = new EventFriendsListHasA(this);
		btnToBlockAll.addActionListener(fle);
		btnToFriendAll.addActionListener(fle);

		listBlockFriend.addItemListener(fle);
		listFriend.addItemListener(fle);

		/* ���� Ȱ��ȭ : �̺�ƮŬ�������� ����� */
		addWindowListener(fle);

		/* �������� ũ�⼳�� */
		setBounds(200, 200, 500, 400);
		setResizable(false);

		/* ����ȭ */
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
