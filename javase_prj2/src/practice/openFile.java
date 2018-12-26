//import java.awt.FileDialog;
//
//class open {
//	public void openFile() {
//		FileDialog fdOpen = new FileDialog(proView, "파일 열기", FileDialog.LOAD);
//		
//		// 가시화
//		fdOpen.setVisible(true);
//		
//		String path = fdOpen.getDirectory();
//		String name = fdOpen.getFile();
//		
//		if (path != null && name != null) { // 선택한 파일이 있을 때
//			proView.txtField.setText(path + name);
//			
//			// 타이틀바에 내용을 변경
//			proView.setTitle("Log분석 - 열기 " + name);
//			
//			// 선택한 파일로 파일 객체 생성
//			File file = new File(path + name);
//			
//			
//			
//		}// fileOpen
//}