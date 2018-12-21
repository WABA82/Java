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

	/* 생성자 */
	public FileCopy() {
		super("파일복사");
		jb = new JButton("파일선택");
		jpb = new JProgressBar(0, 100);
		jpb.setString("진척도");
		jpb.setValue(50);

		JPanel panel = new JPanel();
		panel.add(jb);

		add("Center", panel);
		add("South", jpb);

		jb.addActionListener(this);
		setBounds(100, 100, 500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}// 생성자 //

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
		FileDialog fd = new FileDialog(this, "파일선택", FileDialog.LOAD);
		fd.setVisible(true);

		String path = fd.getDirectory();
		String name = fd.getFile();

		if (path != null) {
			File file = new File(path + name);
			try {
				copy(file);
				JOptionPane.showMessageDialog(this, file + "복사성공");
			} catch (FileNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "파일이 존재하지 않습니다.");
				e1.printStackTrace();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(this, "입출력 작업에 문제 발생");
				e1.printStackTrace();
			} // try~catch //
		} // end if //
	}// actionPerformed //

	public void copy(File file) throws FileNotFoundException, IOException {

		int selectValue = JOptionPane.showConfirmDialog(this, "파일을 복사 하시겠습니까?");

		switch (selectValue) {
		case JOptionPane.OK_OPTION:
			StringBuilder copyFileName = new StringBuilder(file.getAbsolutePath());
			copyFileName.insert(copyFileName.lastIndexOf("."), "_bak");
			System.out.println(copyFileName);

			FileInputStream fis = null;
			FileOutputStream fos = null;

			try {

				fis = new FileInputStream(file);
				/* _back가 들어간 이름으로 파일 생성하기 */
				fos = new FileOutputStream(copyFileName.toString());

				int temp = 0;
				filelen = file.length();
				System.out.println(filelen);
				cnt = 0;
				Thread t = new Thread(this);
				t.start();

				/* 파일과 연결된 스트림에서 값 얻기 */
				while ((temp = fis.read()) != -1) {
					/* 파일 복사 하기 1번 */
					fos.write(temp);
					fos.flush();
//					jpb.setValue((int) ((i / (double) filelen) * 100));
//					System.out.println(jpb.getValue());
//					System.out.print((char) temp + " " + i);
					cnt++;
				}

				/* 파일 복사 하기 2번 : HDD가 한번에 읽어들이는 크기를 그대로 사용. */
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
