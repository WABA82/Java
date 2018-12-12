package day1212;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         ������ Ŭ������ Has a����� ������ �̺�Ʈ ó�� Ŭ����
 */
public class EventFriendsListHasA extends WindowAdapter implements ActionListener, ItemListener {

	private FriendListHasA fl; // �̺�Ʈ�� ó���ϱ� ���� ���Ǵ� ��� ������Ʈ�� Has a ������ ��ü�� ����Ͽ� ó���Ѵ�. //

	/* ������ : has a */
	public EventFriendsListHasA(FriendListHasA fl) {
		this.fl = fl;
	}

	@Override
	/* ����ó���޼ҵ� */
	public void windowClosing(WindowEvent we) {
		fl.dispose();
	}

	@Override
	/* ����Ʈ�� �̺�Ʈ ó�� */
	public void itemStateChanged(ItemEvent ie) {
		// ģ������Ʈ���� Ŭ���Ǹ� �ش� �������� ���ܵ� ģ���� ������.
		if (ie.getSource() == fl.getListFriend()) {
			System.out.println("ģ��");
			blockFriend();
		}
		// ���ܵ� ģ������Ʈ���� Ŭ���Ǹ� �ش� �������� ģ�� ������� ������.
		if (ie.getSource() == fl.getListBlockFriend()) {
			System.out.println("���ܵ�ģ��");
			unblockFriend();
		}
	}

	@Override
	/* ��ư�� �̺�Ʈ ó�� */
	public void actionPerformed(ActionEvent ae) {
		// >> : ��� ģ�� ���ܸ������ �̵�.
		if (ae.getSource() == fl.getBtnToBlockAll()) {
			allBlock();
		}
		// << : ���ܵ� ��� ģ���� ģ��������� �̵�.
		if (ae.getSource() == fl.getBtnToFriendAll()) {
			allUnBlock();
		}
	}

	/* ģ�� ����Ʈ���� ���ܸ������ */
	private void blockFriend() {
		List tempFriend = fl.getListFriend();
		String name = tempFriend.getSelectedItem();
		// �������� ������.
		fl.getListBlockFriend().add(name);
		// ������ ģ���� ����
		tempFriend.remove(name);
	}

	/* ģ�� ����Ʈ���� ���ܸ������ */
	private void unblockFriend() {
		List tempList = fl.getListBlockFriend();
		int selectedIndex = tempList.getSelectedIndex();

		fl.getListFriend().add(tempList.getItem(selectedIndex));

		tempList.remove(selectedIndex);
	}

	/* &gt,&gt ��ư�� Ŭ���ϸ� ��� ģ�� ���� */
	private void allBlock() {
		// ����Ʈ ��� �������� �޾ƿͼ�
		String[] allFriends = fl.getListFriend().getItems();
		// ���� ����Ʈ�� ������.
		for (int i = 0; i < allFriends.length; i++) {
			fl.getListBlockFriend().add(allFriends[i]);

		}
		// ģ�� ����Ʈ�� ��� ������ ����.
		fl.getListFriend().removeAll();
	}

	/* &lt,&lt ��ư�� Ŭ���ϸ� ��� ���� ģ���� */
	private void allUnBlock() {
		// ���� ����Ʈ�� ��� ������ �޾ƿ���.
		String[] allBlocks = fl.getListBlockFriend().getItems();

		// ģ��������� ������.
		for (String blocked : allBlocks) {
			fl.getListFriend().add(blocked);
		}
		
		fl.getListBlockFriend().removeAll();

	}
}
