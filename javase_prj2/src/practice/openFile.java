//import java.awt.FileDialog;
//
//class open {
//	public void openFile() {
//		FileDialog fdOpen = new FileDialog(proView, "���� ����", FileDialog.LOAD);
//		
//		// ����ȭ
//		fdOpen.setVisible(true);
//		
//		String path = fdOpen.getDirectory();
//		String name = fdOpen.getFile();
//		
//		if (path != null && name != null) { // ������ ������ ���� ��
//			proView.txtField.setText(path + name);
//			
//			// Ÿ��Ʋ�ٿ� ������ ����
//			proView.setTitle("Log�м� - ���� " + name);
//			
//			// ������ ���Ϸ� ���� ��ü ����
//			File file = new File(path + name);
//			
//			
//			
//		}// fileOpen
//}