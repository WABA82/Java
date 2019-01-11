package day0111;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class NamecardViewController extends WindowAdapter implements ActionListener {

	private NamecardView nv;
	private NamecardDAO n_dao;
	private String imgPath;

	public NamecardViewController(NamecardView nv) {
		this.nv = nv;
		imgPath = "";
		n_dao = NamecardDAO.getInstance();
		setAllNamecard();/* ���̺� �����͸� �߰��Ѵ�. */
	}// ������

	@Override
	public void windowClosing(WindowEvent e) {
		nv.dispose();
	}// windowClosing

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nv.getJbtAdd()) {
			addNamecard();
		} // end if

		if (e.getSource() == nv.getJbtImg()) {
			selectFile();
		} // end if
	}// actionPerformed

	private void selectFile() {
		FileDialog fd_Open = new FileDialog(nv, "�̹�������", FileDialog.LOAD);
		fd_Open.setVisible(true);

		String path = fd_Open.getDirectory();
		String name = fd_Open.getFile();

		if (path != null) {
			imgPath = path + "/" + name;
			JLabel jl = nv.getJlPreview();
			jl.setIcon(new ImageIcon(imgPath));
		} // end if

	}// selectFile

	private void addNamecard() {
		JTextField jtfName = nv.getJtfName();
		JTextField jtfAddr = nv.getJtfAddr();

		String name = jtfName.getText().trim();
		if (name.equals("")) {
			JOptionPane.showMessageDialog(nv, "�̸��� �ʼ� �Է�!!");
			jtfName.requestFocus();
			return;
		} // end if

		String addr = jtfAddr.getText().trim();
		if (addr.equals("")) {
			JOptionPane.showMessageDialog(nv, "�ּҴ� �ʼ� �Է�!!");
			jtfAddr.requestFocus();
			return;
		} // end if

		boolean insertFlag = false;
		if (imgPath.equals("")) { // �̹����� �������� �ʾ��� ��
			insertFlag = JOptionPane.showConfirmDialog(nv, "�⺻ �̹����� ����Ͻðڽ��ϱ�?") == JOptionPane.OK_OPTION;
		} else { // �̹����� �������� ��
			insertFlag = true;
		} // end if

		if (insertFlag) {
			/* DB�� �߰� */
			// ����� ���ϸ����� ������ ��ġ�� ���ε带 ������ �� DB�� �߰��Ѵ�. //
			StringBuilder filePath = new StringBuilder();
			filePath.append(System.currentTimeMillis()).append(imgPath.substring(imgPath.lastIndexOf(".")));
			try {
				if (!imgPath.equals("no_image.png")) { // �⺻ �̹����� �ƴ϶�� ���ε带 �����Ѵ�.
					uploadImg(filePath.toString());
				} // end if

				// DB�� �߰�
				NamecardVO n_vo = new NamecardVO(name, addr,
						!imgPath.equals("no_image.png") ? filePath.toString() : "no_image.png");
				n_dao.insertNamecard(n_vo);

				JOptionPane.showMessageDialog(nv, "������ �߰��Ǿ����ϴ�.");
				jtfName.setText("");
				jtfAddr.setText("");
				jtfName.requestFocus();
				nv.getJlPreview()
						.setIcon(new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/upload/no_image.png"));
				setAllNamecard(); // �߰��� ������ �������ش�.

			} catch (SQLException se) {
				JOptionPane.showMessageDialog(nv, "���� �߰� �� �����߻�!!");
			} catch (IOException ie) {
				JOptionPane.showMessageDialog(nv, "�̹��� ���ε� �� �����߻�!!");
			} // end if
			imgPath = "";
		} // end if

	}// addNamecard

	/**
	 * ��ȸ�� ���������� JTable�� �߰�
	 */
	private void setAllNamecard() {
		try {
			List<NamecardVO> list = n_dao.selectNamecard();

			DefaultTableModel dtm = nv.getDtm_Namecard();
			/* �����͸� ����ϱ����� �ʱ�ȭ */
			dtm.removeRow(0);

			Object[] rowData = null;

			NamecardVO n_vo = null;
			for (int i = 0; i < list.size(); i++) {
				n_vo = list.get(i);
				rowData = new Object[4];
				rowData[0] = new Integer(i + 1);
				rowData[1] = new ImageIcon("C:/dev/workspace/javase_prj2/src/day0111/upload/" + n_vo.getImg());
				rowData[2] = n_vo.getName();
				rowData[3] = n_vo.getAddr();

				/* VO���� ������ ��ü�� ������ rowData�� ��� dtm�� �����Ѵ�. */
				dtm.addRow(rowData);
			} // end for i

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(nv, "�����͸� �������� �� ������ �߻��߽��ϴ�.");
			e.printStackTrace();
		} // end catch
	}// setAllNamecard

	private boolean uploadImg(String filePath) throws IOException {
		boolean flag = false;

		/* ���������� �����Ͽ� ������ ��ġ�� �����Ѵ�. */
		FileInputStream fis = new FileInputStream(imgPath);
		FileOutputStream fos = new FileOutputStream("C:/dev/workspace/javase_prj2/src/day0111/upload/" + filePath);

		try {
			/* ���� �а� ��������(���Ϻ���) */
			byte[] readData = new byte[512];
			int byteSize = 0;

			while ((byteSize = fis.read(readData)) != -1) {
				fos.write(readData, 0, byteSize);
				fos.flush();
			} // end while

		} finally {
			if (fos != null) {
				fos.close();
			} // end if
			if (fis != null) {
				fis.close();
			} // end if
		} // end finally

		return flag;
	}// uploadImg

}// class
