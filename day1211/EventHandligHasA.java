package day1211;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author owner<br>
 *         Has a����� �̺�Ʈ ó��<br>
 *
 */

// 1. �̺�Ʈ ó�� ��ü ����
public class EventHandligHasA implements ActionListener {

	// EventHandligHasA�� DesignHasA�� ������ �ִ�.
	private DesignHasA designHasA;

	public EventHandligHasA(DesignHasA designHasA) {
		this.designHasA = designHasA;
	}

	@Override
	// 3. �߻� �޼ҵ� �������̵�
	public void actionPerformed(ActionEvent e) {
		// 4. �̺�Ʈ�� �߻����� �� ó���� �ڵ�
		System.out.println("���޹��� Design��ü : " + designHasA);
		designHasA.dispose();
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
