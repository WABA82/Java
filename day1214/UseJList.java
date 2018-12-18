package day1214;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 * MVC Pattern을 기반으로한 Component의 사용
 * 
 * @author owner
 */
@SuppressWarnings("serial")
public class UseJList extends JFrame implements ActionListener, MouseListener /* ListSelectionListener */ {

	private JList<String> jl; // View
	private DefaultListModel<String> dlm; // Model

	private JLabel jlOutput;

	private JButton jb;

	public UseJList() {
		super("JList");

		dlm = new DefaultListModel<String>();
		dlm.addElement("Java SE");
		dlm.addElement("Oracle");
		dlm.addElement("JDBC");
		dlm.addElement("HTML");
		dlm.addElement("JavaScript");
		dlm.addElement("CSS");

		jl = new JList<String>(dlm);

		// ScrollBar가 없는 JList에게 ScrollBar 설정
		JScrollPane jsp = new JScrollPane(jl);

		jlOutput = new JLabel("출력");

		jlOutput.setBorder(new TitledBorder("선택아이템"));

		jb = new JButton("입력");

		add("North", jb);
		add("Center", jsp); // 컴포넌트를 가진 스트콜바 객체를 배치
		add("South", jlOutput);

		jb.addActionListener(this);
//		jl.addListSelectionListener(this);
		jl.addMouseListener(this);

		setBounds(100, 100, 300, 400);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}// 생성자

	@Override
	public void actionPerformed(ActionEvent ae) {

		String lang = JOptionPane.showInputDialog("컴퓨터 개발관련 언어를 입력해주세요.");
		System.out.println("---" + lang);

		// 입력데이터이므로 Model 객체를 사용한다.
		if (lang != null && !lang.equals("")) {
			dlm.addElement(lang);
		} // end if

	}// actionPerformed

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int idx = jl.getSelectedIndex();
		String value = dlm.get(idx);
		// JLabel에 추가
		jlOutput.setText(value);
		// 선택된 값을 삭제.
		dlm.remove(idx);
		System.out.println("삭제");
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

//	private boolean flag;
//
//	@Override
//	public void valueChanged(ListSelectionEvent lse) {
//		// 선택된 아이템(JList)의 값(DefaultListModel)을 얻어와서
//		System.out.println(flag);
//		if (flag) {
//			int idx = jl.getSelectedIndex();
//			String value = dlm.get(idx);
//			// JLabel에 추가
//			jlOutput.setText(value);
//			// 선택된 값을 삭제.
//			dlm.remove(idx);
//			System.out.println(flag);
//		}
//		flag = !flag;
//	}

	public static void main(String[] args) {

		new UseJList();

	}// main

}// class