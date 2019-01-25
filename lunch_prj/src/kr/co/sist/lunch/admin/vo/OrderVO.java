package kr.co.sist.lunch.admin.vo;

public class OrderVO {

	private String orderNum, lunchCode, lunchName, orderName, orderDate, phone, ipAddress, status, requests;
	private int quan, price;

	public OrderVO(String orderNum, String lunchCode, String lunchName, String orderName, String orderDate,
			String phone, String ipAddress, String status, String requests, int quan, int price) {
		this.orderNum = orderNum;
		this.lunchCode = lunchCode;
		this.lunchName = lunchName;
		this.orderName = orderName;
		this.orderDate = orderDate;
		this.phone = phone;
		this.ipAddress = ipAddress;
		this.status = status;
		this.requests = requests;
		this.quan = quan;
		this.price = price;
	}// 古鯵持失切

	public String getOrderNum() {
		return orderNum;
	}

	public String getLunchCode() {
		return lunchCode;
	}

	public String getLunchName() {
		return lunchName;
	}

	public String getOrderName() {
		return orderName;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public String getPhone() {
		return phone;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public String getStatus() {
		return status;
	}

	public String getRequests() {
		return requests;
	}

	public int getQuan() {
		return quan;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "OrderVO [orderNum=" + orderNum + ", lunchCode=" + lunchCode + ", lunchName=" + lunchName
				+ ", orderName=" + orderName + ", orderDate=" + orderDate + ", phone=" + phone + ", ipAddress="
				+ ipAddress + ", status=" + status + ", requests=" + requests + ", quan=" + quan + ", price=" + price
				+ "]";
	}

}// class
