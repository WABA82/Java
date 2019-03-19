<%@page import="org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException"%>
<%@page import="kr.co.sist.util.HangeulConv"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CSS 디자인 틀</title>
<link rel="stylesheet" type="text/css" href="http://localhost:8080/jsp_prj/common/css/main_v20190130.css">
<style type="text/css">
#wrap {
	margin: 0px auto; /* 가운데 정렬  */
	width: 800px;
	height: 860px;
	/* background-color: #ff0000; */
}

#header {
	width: 800px;
	height: 140px;
	background: #e5c3ef
		url("http://localhost:8080/jsp_prj/common/images/header_bg.png");
	position: relative;
}

#headerTitle {
	font-family: HY견고딕, 고딕;
	font-size: 30px;
	font-weight: bold;
	text-align: center;
	/* 위치 조정 */
	position: absolute;
	top: 30px;
	left: 290px;
}

#container {
	width: 800px;
	height: 600px;
	background-color: #3cff15;
}

#footer {
	width: 800px;
	height: 120px;
	background-color: #3ceff8;
}

#footerTitle {
	float: right;
	font-size: 15px;
	padding-top: 20px;
	padding-right: 20px;
}
</style>
</head>
<body>
	<div id="wrap">
		<div id="header">
			<div id="headerTitle">SIST Class4</div>
		</div>

		<div id="container">
			<!-- enctype="multipart/form-data인 경우 request에서 파라미터를 가져올 수 없다." -->
			<%-- 
				이름 : <%=request.getParameter("uploader")%>
				<br>
				나이 : <%=request.getParameter("age")%>
			--%>

			<%
				//파일명 인코딩 설정. - 
				request.setCharacterEncoding("UTF-8");

				//파일 업로드 에 적합한 요청인지 얻는다.
				boolean isMultipart = ServletFileUpload.isMultipartContent(request);
				if (isMultipart) { // 파일업로드에 적합한 요청일 때.

					File repository = new File("C:/dev/workspace/jsp_prj/WebContent/upload");

					// Create a factory for disk-based file items
					DiskFileItemFactory factory = new DiskFileItemFactory();

					// 업로드하는 파일이 메모리에 저장되는 최대 크기.
					// 1mb = 1024*1024*1
					factory.setSizeThreshold(1024 * 1024 * 1);
					factory.setRepository(repository);

					// Create a new file upload handler
					ServletFileUpload upload = new ServletFileUpload(factory);

					// 업로드할 파일의 최대크기 설정.
					upload.setSizeMax(1024 * 1024 * 5);

					try {
						// Parse the request
						List<FileItem> items = upload.parseRequest(request);

						// Process the uploaded items
						Iterator<FileItem> iter = items.iterator();

						// local Variable
						String uploader = "", age = "";
						String fieldName = "", fileName = "", contentType = "";
						long sizeInBytes = 0;

						while (iter.hasNext()) {
							FileItem item = iter.next();

							if (item.isFormField()) { //일반 HTML Form Control일 때. - <input type="button/text/........">
								String controlName = item.getFieldName();
								String controlValue = item.getString();

								if ("uploader".equals(controlName)) {
									uploader = HangeulConv.toUTF(controlValue);
								} // end if

								if ("age".equals(controlName)) {
									age = controlValue; // int이기 때문에 인코딩 변환을 할 필요가 없다.
								} // end if

							} else {//File Upload Control일 때. - <inpt type="file">
								fieldName = item.getFieldName(); // 파일 컨트롤의 name. - 파일 컨트롤이 여러개일 경우 식별하기 위해.
								fileName = item.getName(); // 파일 컨트롤의 value - 파일명.
								contentType = item.getContentType(); //ContentType.
								sizeInBytes = item.getSize(); // 업로드할 파일의 크기.

								// System.out.println("------- 파일명 : " + fileName);
								File selectFile = new File(fileName);

								File uploadedFile = new File(repository.getAbsolutePath() + "/" + selectFile.getName()); // 업로드 파일의 저장 경로와 파일명을 설정.
								item.write(uploadedFile); //설정된 파일을 업로드.

							} // end else
						} // end while
			%>
			파일 업로드 성공
			<br>
			업로더명 :
			<%=uploader%><br>
			연령대 :
			<%=age%><br>
			업로드 파일명 :
			<%=fileName%><br>
			파일 크기 =
			<%=sizeInBytes%>byte
			<br>
			<a href="upload_form.jsp">업로드</a>
			<a href="file_list.jsp">파일리스트</a>


			<%
				} catch (SizeLimitExceededException slee) {
						// SizeLimitExceededException예외는 브라우저에 출력되지 않는다.
						out.println("예외 브라우저에 찍기");
				}// end catch
				} else { // 파일업로드에 부적합 요청일 때.
					response.sendRedirect("upload_form.jsp");
				} // end else
			%>


		</div>

		<div id="footer">
			<div id="footerTitle">copyright&copy; all right reserved. class 4</div>
		</div>
	</div>

</body>
</html>

