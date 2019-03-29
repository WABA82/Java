package day0327;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class AttParsing {

	public List<AttVO> personData(String lastName) throws MalformedURLException, JDOMException, IOException {
		List<AttVO> list = new ArrayList<>();

		// 1. Builder ����(Parser)
		SAXBuilder builder = new SAXBuilder();

		// 2. XML�б�
		Document doc = builder.build(new URL("http://localhost:8080/jsp_prj/xml0327/att.xml"));

		// 3. �ֻ��� ��� ���.
		Element rootNode = doc.getRootElement();

		// 4. �ֻ��� - �������� ���. (<person>)
		Iterator<Element> personNodes = rootNode.getChildren().iterator();

		// 5. �� ��� person node�� �ݺ�.
		Element personNode = null;
		Iterator<Element> personSubNodes = null;
		Element someNode = null; // <person>�� ���� ��� ����. - <name> �Ǵ� <address>
		Attribute lastAtt = null; // lastName �Ӽ��� ����.
		Attribute cityAtt = null; // city �Ӽ��� ����.
		Attribute zipcodeAtt = null; // zipcode �Ӽ��� ����.
		String lastNameAtt = "";
		AttVO a_vo = null;

		// <person>���� ��´�.
		while (personNodes.hasNext()) {

			// �ݺ����� personNode�ϳ� ���.
			personNode = personNodes.next();

			// <person>�� ���� ��� ���. - <name> �Ǵ� <address>
			personSubNodes = personNode.getChildren().iterator();
			while (personSubNodes.hasNext()) {
				someNode = personSubNodes.next();

				// �Էµ� ������ ���� �����ؾ��ϹǷ� ������ �ִ� <name>�� ��.
				if ("name".equals(someNode.getName())) {
					lastAtt = someNode.getAttribute("lastName"); // "��"
					lastNameAtt = lastAtt.getValue(); // "��"�� ��
					// �Ű����� ���� xml���� �о���� �±��� �Ӽ��� ���� ��.
					if (lastName.equals(lastNameAtt)) {
						a_vo = new AttVO();
						a_vo.setFirstName(someNode.getText());
						a_vo.setLastName(lastNameAtt);
					} // end if
				} // end if

				// <name> ������ ��
				if (lastName.equals(lastNameAtt)) {
					// <address> ���.
					if ("address".equals(someNode.getName())) {
						cityAtt = someNode.getAttribute("city");
						zipcodeAtt = someNode.getAttribute("zipcode");

						a_vo.setCity(cityAtt.getValue());
						a_vo.setZipcode(zipcodeAtt.getValue());
						a_vo.setAddress(someNode.getText());
						list.add(a_vo); // �Է��� ������ ��ġ�ϴ� ���� parsing�� ��ü�� list�� �߰�.
					} // end if
				} // end if

			} // end while

		} // end while

		return list;
	}// class

//	public static void main(String[] args) {
//
//		AttParsing a = new AttParsing();
//		try {
//
//			System.out.println(a.personData("��"));
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JDOMException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}// main

}// class
