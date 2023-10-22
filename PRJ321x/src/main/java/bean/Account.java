package bean;

public class Account {
	private String userEmail,pwd;
	private int role;
	private String name, address,phone;
	private int check;
	private String message = "";
	
	
	public Account(String user, String pwd) {
		super();
		this.userEmail = user;
		this.pwd = pwd;
	}
	
	
	public Account(String userEmail, String pwd, String name) {
		super();
		this.userEmail = userEmail;
		this.pwd = pwd;
		this.name = name;
	}



	public Account(String email, String pwd, String name, String address, String phone) {
		super();
		this.userEmail = email;
		this.pwd = pwd;
		this.name = name;
		this.address = address;
		this.phone = phone;

	}
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String user) {
		this.userEmail = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	
	//validate form
	public String validate() {
		
		if(this.userEmail.equals("")) {
			this.message = "No username set";
			return message;
		}else if(this.pwd.equals("")) {
			this.message = "No password set";
			return message;
		}else if(this.pwd.length() < 8) {
			this.message = "Password must be at least 8 characters.";
			return message;
		}
		else if(this.pwd.matches("\\w*\\s+\\w*")) {
			this.message = "Password cannot contain space";
			return message;
		}
		return message;
	}
	
	
}
