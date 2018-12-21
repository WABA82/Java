package day1221;

import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class FileCopy extends JFrame implements ActionListener, Runnable {

	private JButton jb;
	private JProgressBar jpb;
	private long filelen;
	private int cnt;

	/* ������ */
	public FileCopy() {
		super("���Ϻ���");
		jb = new JButton("���ϼ���");
		jpb = new JProgressBar(0, 100);
		jpb.setString("��ô��");
		jpb.setValue(50);

		JPanel panel = new JPanel();
		panel.add(jb);

		add("Center", panel);
		add("South", jpb);

		jb.addActionListener(this);
		setBounds(100, 100, 500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}// ������ //

	@Override
	public void run() {
		for (int i = 0; i < filelen; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			jpb.setValue((int) ((cnt / (double) filelen) * 100));
		}
	}// run //

	@Override
	public void actionPerformed(ActionEvent e) {
		FileDialog fd = new FileDialog(this, "���ϼ���", FileDialog.LOAD);
		fd.setVisible(true);

		String path = fd.getDirectory();
		String name = fd.getFile();

		if (path != null) {
			File file = new File(path + name);
			try {
				copy(file);
				JOptionPane.showMessageDialog(this, file + "���缺��");
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "������ �������� �ʽ��ϴ�.");
				e1.printStackTrace();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, "����� �۾��� ���� �߻�");
				e1.printStackTrace();
			} // try~catch //
		} // end if //
	}// actionPerformed //

	public void copy(File file) throws FileNotFoundException, IOException {

		int selectValue = JOptionPane.showConfirmDialog(this, "������ ���� �Ͻðڽ��ϱ�?");

		switch (selectValue) {
		case JOptionPane.OK_OPTION:
			StringBuilder copyFileName = new StringBuilder(file.getAbsolutePath());
			copyFileName.insert(copyFileName.lastIndexOf("."), "_bak");
			System.out.println(copyFileName);

			FileInputStream fis = null;
			FileOutputStream fos = null;

			try {

				fis = new FileInputStream(file);
				/* _back�� �� �̸����� ���� �����ϱ� */
				fos = new FileOutputStream(copyFileName.toString());

				int temp = 0;
				filelen = file.length();
				System.out.println(filelen);
				cnt = 0;
				Thread t = new Thread(this);
				t.start();

				/* ���ϰ� ����� ��Ʈ������ �� ��� */
				while ((temp = fis.read()) != -1) {
					/* ���� ���� �ϱ� 1�� */
					fos.write(temp);
					fos.flush();
//					jpb.setValue((int) ((i / (double) filelen) * 100));
//					System.out.println(jpb.getValue());
//					System.out.print((char) temp + " " + i);
					cnt++;
				}

				/* ���� ���� �ϱ� 2�� : HDD�� �ѹ��� �о���̴� ũ�⸦ �״�� ���. */
//				byte[] temp = new byte[512];
//				int length = 0;
//				while ((length = fis.read(temp)) != -1) {
//					fos.write(temp, 0, length);
//					fos.flush();
//				} // while //

			} finally {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			} // try~finally //
		}

	}

	public static void main(String[] args) {
		new FileCopy();
	}// main //

}// class //
