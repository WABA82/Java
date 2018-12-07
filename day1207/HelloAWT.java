package day1207;

import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author owner<br>
 *         window Application �ۼ� :
 *
 */
//1. Window Component���
@SuppressWarnings("serial")
public class HelloAWT extends Frame {

	public HelloAWT() {
		super("AWT ����");

		// 2. ����� �Ϲ�������Ʈ ����.
		Label lblTitle = new Label("���� ����Ʈ ���ڼ���");
		TextArea ta = new TextArea("���ü���\n���� 1���� �ڶ�");

		// 3.��ġ�����ڸ� ����Ͽ� ������Ʈ�� ��ġ.
		add("North", lblTitle);
		add("Center", ta);

		// 4. �������� ũ�� ����
		setSize(400, 270);

		// 5. ����ڿ��� �����ֱ�
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}

	public static void main(String[] args) {
		new HelloAWT();
	}// main

}// class