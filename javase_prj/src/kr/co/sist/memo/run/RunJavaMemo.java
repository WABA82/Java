package kr.co.sist.memo.run;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;

import kr.co.sist.memo.view.JavaMemo;

/**
 * @author owner<br>
 *         메모장 클래스를 실행하는 일.
 */
public class RunJavaMemo {

	public Font readFontInfo() throws IOException, ClassNotFoundException {
//		BufferedReader br = null;
		Font font = null;
		ObjectInputStream ois = null;

		try {
			ois = new ObjectInputStream(new FileInputStream("c:/dev/temp/memo.dat"));
			font = (Font) ois.readObject();
//			br = new BufferedReader(new FileReader("c:/dev/temp/memo.dat"));
//			String readFont = br.readLine();
//			String[] readFontArr = readFont.split(",");
//			font = new Font(readFontArr[0], Integer.parseInt(readFontArr[1]), Integer.parseInt(readFontArr[2]));
		} finally {
			if (ois != null) {
				ois.close();
			}
//			if (br != null) {
//				br.close();
//			}
		}

		return font;
	}

	/**
	 * @param args<br>
	 *        자바클래스를 실행하는 일 : Java Application
	 */
	public static void main(String[] args) {
		RunJavaMemo rjm = new RunJavaMemo();
		Font font = null;
		try {
			font = rjm.readFontInfo();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		new JavaMemo(font);
	}// main

}// class
