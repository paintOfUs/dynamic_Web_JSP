package bean;

public class Products {
	private int productId;
	private String name,des,type,brand;
	private double price;
	private String productImg;
	private int num;

	public Products(int productId, String name, String des, double price, 
			String productImg,
			String type, String brand) {
		super();
		this.productId = productId;
		this.name = name;
		this.des = des;
		this.price = price;
		this.type = type;
		this.brand = brand;
		this.productImg = productImg;
		
	}	

	public Products(int productId, String name, double price, String productImg, int num) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.productImg = productImg;
		this.num = num;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDes() {
		return des;
	}


	public void setDes(String des) {
		this.des = des;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getProductImg() {
		return productImg;
	}


	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	
	

}
