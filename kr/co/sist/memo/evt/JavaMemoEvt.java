package kr.co.sist.memo.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.memo.view.JavaMemo;

public class JavaMemoEvt extends WindowAdapter implements ActionListener {

	private JavaMemo javamemo;

	/* ������ has a */
	public JavaMemoEvt(JavaMemo javamemo) {
		this.javamemo = javamemo;
	}

	/* ���� Ȱ��ȭ */
	@Override
	public void windowClosing(WindowEvent e) {
		javamemo.dispose();
	}

	/*  */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	/* ���ۿ� ���� ó�� */
	public void newMemo() {

	}

	/* .txt ���� ���� */
	public void openMemo() {

	}

	/* �ۼ��� �޸� ���� : ������ ���ϸ��� �״�� �����ϴ� ���ϸ� �ݿ�. */
	public void saveMemo() {

	}

	/* ���ϸ��� �Է¹޾� ���̸����� �����ϴ� �� */
	public void newSaveMemo() {

	}

	/* �۲��� �����ϴ� ���̾�α׸� �����ϴ� �� */
	public void formatDialog() {

	}

	/* �޸��� ������ �����ϴ� ���̾�α� ���� */
	public void helpDialog() {

	}

}
