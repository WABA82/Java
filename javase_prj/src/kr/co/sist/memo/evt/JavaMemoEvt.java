package kr.co.sist.memo.evt;

import java.awt.FileDialog;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import kr.co.sist.memo.view.JavaMemo;
import kr.co.sist.memo.view.MemoFormat;
import kr.co.sist.memo.view.MemoHelp;

public class JavaMemoEvt extends WindowAdapter implements ActionListener {

	private JavaMemo javamemo;
	private String taNoteData; // TextArea의 내용을 저장할 변수 선언 //
	private String openPath; // 열었던 파일명을 저장 //

	/* 생성자 has a */
	public JavaMemoEvt(JavaMemo javamemo) {
		this.javamemo = javamemo;
		taNoteData = "";
		openPath = "";
	}

	/* 종료 활성화 */
	@Override
	public void windowClosing(WindowEvent e) {
		if (!taNoteData.equals(javamemo.getTaNote().getText())) {
			saveMemo();
		}
		javamemo.dispose();
	}

	/* 아이템에 대한 처리 메소드 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		// 1.miNew, 2.miOpen, 3.miSave, 4.miNewSave, 5.miEnd, 6.miFormat, 7.miHelp //

		// 1. 메뉴아이템_"새글" : 이벤트가 발생 했을 때 //
		if (ae.getSource() == javamemo.getMiNew()) {
			newMemo();
		}
		// 2. 메뉴아이템_"열기" : 이벤트가 발생 했을 때 //
		if (ae.getSource() == javamemo.getMiOpen()) {
			try {
				openMemo();
			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(javamemo, "선택한 파일을 읽을 수 없습니다.", "파일열기 에러", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(javamemo, "선택한 파일을 읽어들이는 중 문제가 발생.", "파일열기 에러",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
		// 3. 메뉴아이템_"저장" : 이벤트가 발생 했을 때 //
		if (ae.getSource() == javamemo.getMiSave()) {
			saveMemo();
		}
		// 4. 메뉴아이템_"다른 이름으로 저장" : 이벤트가 발생 했을 때 //
		if (ae.getSource() == javamemo.getMiNewSave()) {
			newSaveMemo();
		}
		// 5. 메뉴아이템_"종료" : 이벤트가 발생 했을 때 //
		if (ae.getSource() == javamemo.getMiEnd()) {
			// 저장되지 않은 내용이 있다면 저장하고 종료 //
			if (!taNoteData.equals(javamemo.getTaNote().getText())) {
				saveMemo();
			}
			javamemo.dispose();
		}
		// 6. 메뉴아이템_"서식" : 이벤트가 발생 했을 때 //
		if (ae.getSource() == javamemo.getMiFormat()) {
			formatDialog();
		}
		// 7. 메뉴아이템_"도움말" : 이벤트가 발생 했을 때 //
		if (ae.getSource() == javamemo.getMiHelp()) {
			helpDialog();
		}
	}

	/* "새글"버튼을 눌렀을 때(ActionEvent) = 호출 : 텍스트에리아 초기화 */
	public void newMemo() {
		TextArea tempTa = javamemo.getTaNote();
		boolean flagNew = false;
		// 저장여부 판단 //
		if (!taNoteData.equals(tempTa.getText())) {
			int flag = JOptionPane.showConfirmDialog(javamemo, "다른 이름으로 저장하시겠습니까?");
			switch (flag) {
			case JOptionPane.OK_OPTION:
				newSaveMemo();
			case JOptionPane.NO_OPTION:
				flagNew = false;
				break;
			default:
				flagNew = true;
			}
		}

		// 버그 : TA를 초기화 하기 위해서는 TA.getText()메소드를 한번 실행해야 합니다. //

		if (!flagNew) {
			tempTa.getText();
			tempTa.setText("");
			// 새글이 된 이후에는 내용과 경로 초기화 //
			taNoteData = tempTa.getText();
			openPath = "";
			javamemo.setTitle("메모장-새글");
		}
	}

	/* 파일 열기 */
	public void openMemo() throws IOException, FileNotFoundException {

		// TextArea의 내용과 읽어들였던 내용이 다르다면 저장여부를 물어보기 //
		TextArea tempTa = javamemo.getTaNote();
		boolean flagOpen = false;
		if (!taNoteData.equals(tempTa.getText())) {
			int flag = JOptionPane.showConfirmDialog(javamemo, openPath + "\n 저장하시겠습니까?");
			switch (flag) {
			case JOptionPane.OK_OPTION:
				if (!openPath.equals("")) {
					if (flag == JOptionPane.OK_OPTION) {
						// 기존의 이름에 저장 //
						saveMemo();
					}
				} else {
					// 다른 이름으로 저장 //
					newSaveMemo();
				}
			case JOptionPane.NO_OPTION:
				flagOpen = false;
				break;
			default:
				flagOpen = true;
			}
		} // endif//

		if (!flagOpen) {
			// 파일다이얼로그 객체 생성 : (파일다이얼로그가 열리는 객체, 다이얼로그의 이름(제목), 다이얼로그 형식) //
			FileDialog fdOpen = new FileDialog(javamemo, "문서열기", FileDialog.LOAD);
			fdOpen.setVisible(true); // 가시화

			// 다이얼로그의 메소드 //
			String filePath = fdOpen.getDirectory(); // 선택한 파일의 경로찾는 메소드
			String fileName = fdOpen.getFile(); // 선택한 파일의 이름

			// 선택한 파일이 존재한다면 //
			if (filePath != null) {
				// 선택된 파일로 파일객체 생성 //
				File file = new File(filePath + fileName);
				BufferedReader br = null;

				try {

					br = new BufferedReader(new FileReader(file));
					String temp = "";
					// textArea 초기화 //
					javamemo.getTaNote().setText("");
					while ((temp = br.readLine()) != null) {
						tempTa.append(temp + "\n");
					}
					// taNoteData 변수에 읽어 들인 내용을 저장 //
					taNoteData = tempTa.getText();
					// 열었던 파일명을 저장 //
					openPath = file.getAbsolutePath();
				} finally {
					/* nullPoint예외 예방 */
					if (br != null) {
						br.close();
					}
				}
				// 파일의 경로와 이름을 Frame의 TitleBar에 설정 //
				javamemo.setTitle("메모장-열기 " + filePath + fileName);
			} // end if
		}
	}// openMemo 메소드 종료 //

	/* 작성한 메모를 저장 : 기존의 파일명을 그대로 저장하는 파일명에 반영. */
	public void saveMemo() {
		try {
			if (!openPath.equals("")) {
				createFile(openPath);
			} else {
				newSaveMemo();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createFile(String pathName) throws IOException {
		BufferedWriter bw = null;
		try {

			/* 사용자가 디렉토리명을 마음대로 변경할 수 없기 때문에 File클래스를 사용할 필요가 없다. */
			bw = new BufferedWriter(new FileWriter(pathName));
			bw.write(javamemo.getTaNote().getText());
			bw.flush();

			openPath = pathName;
			taNoteData = javamemo.getTaNote().getText();
		} finally {
			if (bw != null) {
				bw.close();
			}
		}
	}

	/* 파일명을 입력받아 새이름으로 저장하는 일 */
	public void newSaveMemo() {
		// 파일다이얼로그 객체 생성 : (파일다이얼로그가 열리는 객체, 다이얼로그의 이름(제목), 다이얼로그 형식) //
		FileDialog fdSave = new FileDialog(javamemo, "문서저장", FileDialog.SAVE);
		fdSave.setVisible(true); // 가시화

		// 다이얼로그의 메소드 //
		String filePath = fdSave.getDirectory(); // 선택한 파일의 경로찾는 메소드
		String fileName = fdSave.getFile(); // 선택한 파일의 이름

		if (filePath != null) { // 저장버튼이 눌렸을 때 동작 //
			try {
				createFile(filePath + fileName);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(javamemo, "저장중 문제 발생", "문제발생", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			javamemo.setTitle("메모장-저장 " + filePath + fileName);
		} // end if
	}// newSaveMemo 메소드 종료 //

	/* 글꼴을 설정하는 다이얼로그를 실행하는 일 */
	public void formatDialog() {
		new MemoFormat(javamemo);
	}

	/* 메모장 정보를 제공하는 다이얼로그 실행 */
	public void helpDialog() {
		new MemoHelp(javamemo);
	}

}
