package kr.co.sist.chat.client.evt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.co.sist.chat.client.view.MultiChatClientSelectRoomView;
import kr.co.sist.chat.client.view.MultiChatClientView;

public class MultiChatClientSelectRoomEvt extends WindowAdapter implements ActionListener {
	/* 인스턴스변수 */
	private MultiChatClientSelectRoomView srv;
	private int clientPort;

	public MultiChatClientSelectRoomEvt(MultiChatClientSelectRoomView srv) {
		this.srv = srv;
	}// 생성자

	@Override
	public void windowClosing(WindowEvent e) {
		srv.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == srv.getJrbtnteam1()) {
			clientPort = 36001;
		} else if (e.getSource() == srv.getJrbtnteam2()) {
			clientPort = 36002;
		} else if (e.getSource() == srv.getJrbtnteam3()) {
			clientPort = 36003;
		} else if (e.getSource() == srv.getJrbtnteam4()) {
			clientPort = 36004;
		}

		if (e.getSource() == srv.getBtnConnect()) {
			new MultiChatClientView(clientPort);
			srv.dispose();
		}
	}// actionPerformed

}// class
