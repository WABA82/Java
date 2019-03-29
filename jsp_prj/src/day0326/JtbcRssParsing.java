package day0326;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class JtbcRssParsing {

	private static JtbcRssParsing jrp;

	private JtbcRssParsing() {
	}// private ������

	public static JtbcRssParsing getInstance() {
		if (jrp == null) {
			jrp = new JtbcRssParsing();
		} // end if
		return jrp;
	}// getInstance

	public List<RssVO> getNews(String rssName) throws IOException, JDOMException {
		List<RssVO> list = new ArrayList<RssVO>();

		// 1.���� ����.
		SAXBuilder builder = new SAXBuilder();

		// 2. URL�� ����Ͽ� �ܺ� RSS ���� ��ü ���.
		Document doc = builder.build(new URL("http://fs.jtbc.joins.com//RSS/" + rssName + ".xml"));

		// 3. �ֻ��� �θ��� ���.<rss>
		Element rootNode = doc.getRootElement();

		// 4. �ڽ� ���(<channel>) ���.
		Element channelNode = rootNode.getChild("channel");

		// 5. <channel>�� �ڽ� ���(�±�)�� ���.
		Iterator<Element> someNodes = channelNode.getChildren().iterator();

		Element someNode = null;
		Iterator<Element> itemSubNodes = null;
		Element itemSubNode = null;

		RssVO r_vo = null;

		while (someNodes.hasNext()) {
			someNode = someNodes.next();

			if ("item".equals(someNode.getName())) {
				// <item>�� ��� �ڽĵ� ���.
				itemSubNodes = someNode.getChildren().iterator();
				// list�� ���� VO����.
				r_vo = new RssVO();
				while (itemSubNodes.hasNext()) {
					itemSubNode = itemSubNodes.next();

					// <title>�� �� ���.
					if ("title".equals(itemSubNode.getName())) {
						r_vo.setTitle(itemSubNode.getText());
					} // end if

					// <link>�� �� ���.
					if ("link".equals(itemSubNode.getName())) {
						r_vo.setLink(itemSubNode.getText());
					} // end if

					// <description>�� �� ���.
					if ("description".equals(itemSubNode.getName())) {
						r_vo.setDescription(itemSubNode.getText());
					} // end if

					// <pubDate>�� �� ���.
					if ("pubDate".equals(itemSubNode.getName())) {
						r_vo.setPubDate(itemSubNode.getText());
					} // end if

				} // end while

				// list�� VO���.
				list.add(r_vo);
			} // end if
		} // end while

		return list;
	}// getNews

	public static void main(String[] args) {
		JtbcRssParsing jrp = JtbcRssParsing.getInstance();
		try {
			System.out.println(jrp.getNews("newsflash"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		}
	}// main

}// class
