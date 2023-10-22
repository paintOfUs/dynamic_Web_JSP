package bean;

public class Orders_detail {
	private int orderID;
	private int productID;
	private int amountProduct;
	private int priceProduct;
	
	public Orders_detail(int orderID, int productID, int amountProduct, int priceProduct) {
		super();
		this.orderID = orderID;
		this.productID = productID;
		this.amountProduct = amountProduct;
		this.priceProduct = priceProduct;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getAmountProduct() {
		return amountProduct;
	}

	public void setAmountProduct(int amountProduct) {
		this.amountProduct = amountProduct;
	}

	public int getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(int priceProduct) {
		this.priceProduct = priceProduct;
	}
	
	
}
