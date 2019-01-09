package day0107homwork;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * @author owner<br>
 *         테이블 선택 접속한 계정의 모든 Table명을 JComboBox에 출력
 */
@SuppressWarnings("serial")
public class View extends JFrame {

	private JComboBox<String> jcb_tablelist;
	private JButton jbt_select;
	private DefaultTableModel dtm;

	public View() throws SQLException {
		super("접속계정의 Table목록 보기");

		JLabel jlb = new JLabel("테이블선택");
		jcb_tablelist = new JComboBox<>();

		jbt_select = new JButton("선택버튼");

		String[] names = { "컬럼명", "데이터형", "크기", "제약사항" };
		dtm = new DefaultTableModel(names, 5);
		JTable jtable = new JTable(dtm);
		jtable.setRowHeight(30);
		JScrollPane jsp = new JScrollPane(jtable);

		/* 배치 */
		JPanel panel = new JPanel();
		panel.add(jlb);
		panel.add(jcb_tablelist);
		panel.add(jbt_select);

		/* 위치 */
		add(BorderLayout.NORTH, panel);
		add(BorderLayout.CENTER, jsp);

		/* 이벤트 등록 */
		Evt evt = new Evt(this);
		addWindowListener(evt);
		jcb_tablelist.addActionListener(evt);
		jbt_select.addActionListener(evt);

		/* 크기설정 및 가시화 */
		setBounds(100, 100, 350, 400);
		setVisible(true);

	}// 생성자

	public JComboBox<String> getJcb_tablelist() {
		return jcb_tablelist;
	}

	public JButton getJbt_select() {
		return jbt_select;
	}

	/* 이하 메인메소드 */
	public static void main(String[] args) {
		try {
			new View();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// mains

}// class
