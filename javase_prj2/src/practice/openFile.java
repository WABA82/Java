//public void reportout() throws IOException {
//		// view �� �ѷ��� �͵���bat ���Ϸ� ���
//		// ��report_������¥.dat�� ������ c:/dev/report ������
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		String outFilename = "C:\\dev\\report\\report_";
//		String checkforder="C:\\dev\\report";
//		
//		StringBuilder outPath = new StringBuilder(outFilename);
//		outPath.insert(outPath.length(), dateFormat.format(new Date()) + ".dat");
////		System.out.println(outPath);
//		String filePath = outPath.toString();
//		File tempfilepath = new File(filePath);
//		File chforder=new File(checkforder);
////		System.out.printf("%s\n", filePath);
//		//�Է� ������ �ۼ�
//		StringBuilder outdata=new StringBuilder();
//		outdata.append(pd.txtFlbl1.getText()+"\n"+pd.txtFlbl2.getText()
//					+"\n"+pd.txtFlbl3.getText()+"\n"+pd.txtFlbl4.getText()
//					+"\n"+pd.txtFlbl5.getText()+"\n"+pd.txtFlbl6.getText());
//		
//		
//		
//		String data = outdata.toString();
//
//
//		BufferedWriter bw = null;
//		
//		boolean flagStatus=false;// ������ ������
//		boolean[] temp= {true,false,false};//Ȯ�� ,���,���
////		checkpath=tempfilepath.exists();
//		
//		int flag = JOptionPane.showConfirmDialog(this, "������ ���� �Ͻðڽ��ϱ�??");
//
//		switch (flag) {
//		case JOptionPane.OK_OPTION:
//			////// ���� ����report������ ����
//			System.out.println("asdasdasd------------"+chforder.exists()); //true ��ȯ
//			if(chforder.exists()) {	//������ ������ �׳� �ߺ� ����� ����
//				System.out.println(chforder.exists());
//				if(tempfilepath.exists()) {//������ �����Ҷ�
//					//	System.out.println("//���� �� ���� �Ҷ�");
//					flagStatus=temp[JOptionPane.showConfirmDialog(null, "����� �κ� ����?")];
//					///�̶� ���ϻ���
//					if(flagStatus==true) {//
//						bw = new BufferedWriter(new FileWriter(tempfilepath));
//						bw.write(data);
//						bw.flush();
//						JOptionPane.showMessageDialog(this, "������ ���� �Ǿ����ϴ�!");
//						
//					}
//					else if(!flagStatus) {///��� ������
//						JOptionPane.showMessageDialog(null, "���","�˸�",JOptionPane.INFORMATION_MESSAGE);
//					}
//				}
//				if(!tempfilepath.exists()){	//���� �� ���� ���� ������
//					//		System.out.println("//���� �� ���� ���� ������");
//					bw = new BufferedWriter(new FileWriter(tempfilepath));
//					bw.write(data);
//					bw.flush();
//					JOptionPane.showMessageDialog(this, "������ ���� �Ǿ����ϴ�!");	
//				}
//				
//				
//			}
//			//�W���� ������ ���� ������ ����
//			if(!chforder.exists()) {
//				JOptionPane.showMessageDialog(null, "���� ���� �� ����", "�˸�", JOptionPane.INFORMATION_MESSAGE);
//				System.out.println(chforder.exists());
//				chforder.mkdirs();// ��������
//				if(!tempfilepath.exists()){	//���� �� ���� ���� ������
//					//		System.out.println("//���� �� ���� ���� ������");
//					bw = new BufferedWriter(new FileWriter(tempfilepath));
//					bw.write(data);
//					bw.flush();
//					JOptionPane.showMessageDialog(this, "������ ���� �Ǿ����ϴ�!");	
//				}
//				
//				
//			}
//			///////
//			if (bw != null) {
//				bw.close();
//			} // end if
//			
//			break;
//		case JOptionPane.NO_OPTION:
//			JOptionPane.showMessageDialog(this, "���");
//			break;
//		case JOptionPane.CANCEL_OPTION:
//			JOptionPane.showMessageDialog(this, "�ϱ� ������?");
//		}// switch case
//
//
//
//}