package day1217;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class UseJTable extends JFrame implements ActionListener {

	private JButton jb = new JButton("추가");
	private DefaultTableModel dtm;
	private JTable jt;
	private UseJTable ujt;

	public UseJTable() {

		super("JTable 연습");
		ujt = this;
		/* 1.데이터를 관리하는 Model클래스 생성 */
		String[] coulmnNames = { "번호", "이름", "주소", "이메일" };
		String[][] rowData = { { "1", "이재찬", "인천시 소래동", "chan@test.com" },
				{ "2", "정택성", "서울시 구로동", "teack@sist.co.kr" }, { "3", "이재현", "경기도 안양시", "hyun@gmail.com" } };
		// 데이터를 추가하거나 삭제하기 위한 객체 : isCellEditable메소드를 사용하기 위해 AnonymousClass를 생성한다. //
		dtm = new DefaultTableModel(rowData, coulmnNames) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		/* 2.데이터를 보여주는 View 클래스 생성 */
		jt = new JTable(dtm);
		/* 테이블 컬럼의 크기 변경 */
		jt.getColumnModel().getColumn(0).setPreferredWidth(50);
		jt.getColumnModel().getColumn(1).setPreferredWidth(100);
		jt.getColumnModel().getColumn(2).setPreferredWidth(150);
		jt.getColumnModel().getColumn(3).setPreferredWidth(200);
		/* 테이블 행의 높이 */
		jt.setRowHeight(30);

		// 컬럼의 이름과 스크롤바를 사용할 수 있도록 JScrollPane에 배치 //
		JScrollPane scrollPane = new JScrollPane(jt);
		// 버튼배치를 위한 패널 생성하고 추가하기 //
		jb = new JButton("데이터 추가");
		JPanel jp = new JPanel();
		jp.add(jb);

		/* 이벤트 등록 */
		jb.addActionListener(this);

		UseJTable.TableEvt te = this.new TableEvt();
		jt.addMouseListener(te);

		/* 배치 */
		add("Center", scrollPane); // JTable 배치
		add("South", jp); // 버튼 배치
		setBounds(100, 100, 500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String inputData = JOptionPane.showInputDialog("데이터입력\n예)번호,이름,주소,이메일");

		// 유효성 검증 //
		String[] tempData = inputData.split(",");
		if (tempData.length != 4) {
			JOptionPane.showMessageDialog(this, "입력데이터의 형태는 \n 번호,이름,주소,이메일 입니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
			return;// 호출한 곳으로 돌아가기
		}

		// 입력된 데이터를 화면에 보여주기 위해 DefaultTableModel에 행 -추가 //
		dtm.addRow(tempData);
	}

	/* inner class */
	public class TableEvt extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("행 선택 : " + jt.getSelectedRow());
			System.out.println("열 선택 : " + jt.getSelectedColumn());
			System.out.println("값 선택 : " + jt.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn()));

			/* .getValueAt()은 Object객체를 반환하기 때문에 자식 클래스로 만들어 주기위해서는 캐스팅이 필요하다 */
//			String selectValue = (String) jt.getValueAt(jt.getSelectedRow(), jt.getSelectedColumn());

			StringBuilder veiwData = new StringBuilder();
			int selectedRow = jt.getSelectedRow();
			int columnCout = jt.getColumnCount();

			int flag = JOptionPane.showConfirmDialog(ujt, "예 : 조회, 아니오 : 삭제");

			switch (flag) {
			case JOptionPane.OK_OPTION:
				for (int i = 0; i < columnCout; i++) {
					veiwData.append(jt.getValueAt(selectedRow, i)).append("\n");
				}
				JOptionPane.showMessageDialog(ujt, veiwData);
				break;
			case JOptionPane.NO_OPTION:
				switch (JOptionPane.showConfirmDialog(ujt, "정말 삭제하시겠습니까?")) {
				case JOptionPane.OK_OPTION:
					dtm.removeRow(selectedRow);
				}
			}

		}
	}
	/* inner class */

	public static void main(String[] args) {
		// 객체 생성시 생성자호출 - 인스턴스 변수를 힙메모리에 올려놓습니다. //
		new UseJTable();
	}

}
