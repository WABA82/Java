//public void reportout() throws IOException {
//		// view 에 뿌려진 것들을bat 파일로 출력
//		// “report_생성날짜.dat” 파일을 c:/dev/report 폴더를
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
//		//입력 데이터 작성
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
//		boolean flagStatus=false;// 파일이 없을때
//		boolean[] temp= {true,false,false};//확인 ,취소,취소
////		checkpath=tempfilepath.exists();
//		
//		int flag = JOptionPane.showConfirmDialog(this, "파일을 생성 하시겠습니까??");
//
//		switch (flag) {
//		case JOptionPane.OK_OPTION:
//			////// 폴더 생성report폴더를 생성
//			System.out.println("asdasdasd------------"+chforder.exists()); //true 반환
//			if(chforder.exists()) {	//폴더가 있을시 그냥 중복 물어보고 생성
//				System.out.println(chforder.exists());
//				if(tempfilepath.exists()) {//파일이 존재할때
//					//	System.out.println("//파일 이 존재 할때");
//					flagStatus=temp[JOptionPane.showConfirmDialog(null, "덮어쓰는 부분 인정?")];
//					///이때 파일생성
//					if(flagStatus==true) {//
//						bw = new BufferedWriter(new FileWriter(tempfilepath));
//						bw.write(data);
//						bw.flush();
//						JOptionPane.showMessageDialog(this, "파일이 생성 되었습니다!");
//						
//					}
//					else if(!flagStatus) {///취소 누를시
//						JOptionPane.showMessageDialog(null, "취소","알림",JOptionPane.INFORMATION_MESSAGE);
//					}
//				}
//				if(!tempfilepath.exists()){	//파일 이 존재 하지 않을때
//					//		System.out.println("//파일 이 존재 하지 않을때");
//					bw = new BufferedWriter(new FileWriter(tempfilepath));
//					bw.write(data);
//					bw.flush();
//					JOptionPane.showMessageDialog(this, "파일이 생성 되었습니다!");	
//				}
//				
//				
//			}
//			//폳더가 없을시 폴더 생성후 만듬
//			if(!chforder.exists()) {
//				JOptionPane.showMessageDialog(null, "폴더 생성 후 만듬", "알림", JOptionPane.INFORMATION_MESSAGE);
//				System.out.println(chforder.exists());
//				chforder.mkdirs();// 폴더생성
//				if(!tempfilepath.exists()){	//파일 이 존재 하지 않을때
//					//		System.out.println("//파일 이 존재 하지 않을때");
//					bw = new BufferedWriter(new FileWriter(tempfilepath));
//					bw.write(data);
//					bw.flush();
//					JOptionPane.showMessageDialog(this, "파일이 생성 되었습니다!");	
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
//			JOptionPane.showMessageDialog(this, "취소");
//			break;
//		case JOptionPane.CANCEL_OPTION:
//			JOptionPane.showMessageDialog(this, "하기 싫으냐?");
//		}// switch case
//
//
//
//}