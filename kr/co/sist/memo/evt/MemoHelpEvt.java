package kr.co.sist.memo.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.memo.view.MemoHelp;

/* WindowAdapter, ActionListener 상속 및 구현 */
public class MemoHelpEvt extends WindowAdapter implements ActionListener {

	MemoHelp memohelp;

	public MemoHelpEvt(MemoHelp memohelp) {
		this.memohelp = memohelp;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		memohelp.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		memohelp.dispose();
	}

}
