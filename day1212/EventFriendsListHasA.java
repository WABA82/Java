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
 *         디자인 클래스와 Has a관계로 설정된 이벤트 처리 클래스
 */
public class EventFriendsListHasA extends WindowAdapter implements ActionListener, ItemListener {

	private FriendListHasA fl; // 이벤트를 처리하기 위해 사용되는 모든 컴포넌트는 Has a 관계의 객체를 사용하여 처리한다. //

	/* 생성자 : has a */
	public EventFriendsListHasA(FriendListHasA fl) {
		this.fl = fl;
	}

	@Override
	/* 종료처리메소드 */
	public void windowClosing(WindowEvent we) {
		fl.dispose();
	}

	@Override
	/* 리스트의 이벤트 처리 */
	public void itemStateChanged(ItemEvent ie) {
		// 친구리스트에서 클릭되면 해당 아이템을 차단된 친구로 보낸다.
		if (ie.getSource() == fl.getListFriend()) {
			System.out.println("친구");
			blockFriend();
		}
		// 차단된 친구리스트에서 클릭되면 해당 아이템을 친구 목록으로 보낸다.
		if (ie.getSource() == fl.getListBlockFriend()) {
			System.out.println("차단된친구");
			unblockFriend();
		}
	}

	@Override
	/* 버튼의 이벤트 처리 */
	public void actionPerformed(ActionEvent ae) {
		// >> : 모든 친구 차단목록으로 이동.
		if (ae.getSource() == fl.getBtnToBlockAll()) {
			allBlock();
		}
		// << : 차단된 모든 친구를 친구목록으로 이동.
		if (ae.getSource() == fl.getBtnToFriendAll()) {
			allUnBlock();
		}
	}

	/* 친구 리스트에서 차단목록으로 */
	private void blockFriend() {
		List tempFriend = fl.getListFriend();
		String name = tempFriend.getSelectedItem();
		// 차단으로 보낸다.
		fl.getListBlockFriend().add(name);
		// 선택한 친구를 삭제
		tempFriend.remove(name);
	}

	/* 친구 리스트에서 차단목록으로 */
	private void unblockFriend() {
		List tempList = fl.getListBlockFriend();
		int selectedIndex = tempList.getSelectedIndex();

		fl.getListFriend().add(tempList.getItem(selectedIndex));

		tempList.remove(selectedIndex);
	}

	/* &gt,&gt 버튼을 클릭하면 모든 친구 차단 */
	private void allBlock() {
		// 리스트 모든 아이템을 받아와서
		String[] allFriends = fl.getListFriend().getItems();
		// 차단 리스트로 보내기.
		for (int i = 0; i < allFriends.length; i++) {
			fl.getListBlockFriend().add(allFriends[i]);

		}
		// 친구 리스트의 모든 아이템 삭제.
		fl.getListFriend().removeAll();
	}

	/* &lt,&lt 버튼을 클릭하면 모든 차단 친구로 */
	private void allUnBlock() {
		// 차단 리스트의 모든 아이템 받아오기.
		String[] allBlocks = fl.getListBlockFriend().getItems();

		// 친구목록으로 보내기.
		for (String blocked : allBlocks) {
			fl.getListFriend().add(blocked);
		}
		
		fl.getListBlockFriend().removeAll();

	}
}
