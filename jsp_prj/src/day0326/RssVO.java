package day0326;

public class RssVO {

	private String title, link, description, pubDate;

	public RssVO() {
	}// 奄沙持失切

	public RssVO(String title, String link, String description, String pubDate) {
		this.title = title;
		this.link = link;
		this.description = description;
		this.pubDate = pubDate;
	}// 持失切.

	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}

	public String getDescription() {
		return description;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	/** setter **/
	
	@Override
	public String toString() {
		return "RssVO [title=" + title + ", link=" + link + ", description=" + description + ", pubDate=" + pubDate + "]";
	}// toString

}// class
