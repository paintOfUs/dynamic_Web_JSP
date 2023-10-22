package bean;

import java.sql.Date;

public class Orders {
	private String userEmail;
	private int orderId;
	private int orderStatus;
	private Date orderDate;
	private String orderDisCode;
	private String orderAddress;
	
	
	
	
	public Orders(String userEmail, Date orderDate, String orderAddress) {
		super();
		this.userEmail = userEmail;
		this.orderDate = orderDate;
		this.orderAddress = orderAddress;
	}


	public Orders(String userEmail, int orderId, int orderStatus, Date orderDate, String orderDisCode,
			String orderAddress) {
		super();
		this.userEmail = userEmail;
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.orderDisCode = orderDisCode;
		this.orderAddress = orderAddress;
	}
	

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderDisCode() {
		return orderDisCode;
	}

	public void setOrderDisCode(String orderDisCode) {
		this.orderDisCode = orderDisCode;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	
	
	
}
