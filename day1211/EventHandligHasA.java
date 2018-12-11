package day1211;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author owner<br>
 *         Has a관계로 이벤트 처리<br>
 *
 */

// 1. 이벤트 처리 객체 구현
public class EventHandligHasA implements ActionListener {

	// EventHandligHasA은 DesignHasA를 가지고 있다.
	private DesignHasA designHasA;

	public EventHandligHasA(DesignHasA designHasA) {
		this.designHasA = designHasA;
	}

	@Override
	// 3. 추상 메소드 오버라이딩
	public void actionPerformed(ActionEvent e) {
		// 4. 이벤트가 발생했을 떄 처리할 코드
		System.out.println("전달받은 Design객체 : " + designHasA);
		designHasA.dispose();
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
