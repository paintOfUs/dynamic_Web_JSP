package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import bean.Orders_detail;
import database.ConnectJDBC;
public class Order_detailDAO implements DAOInterface<Orders_detail> {

	public static Order_detailDAO getInstance() {
		return new Order_detailDAO();
	}
	
	@Override
	public int insert(Orders_detail t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectJDBC.getConnection();
			
			String sql = "INSERT INTO Orders_detail(order_id, product_id, amount_product, price_product) VALUES (?, ?, ?, ?)";
			
			System.out.println(sql);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1,t.getOrderID());
			st.setInt(2,t.getProductID());
			st.setInt(3,t.getAmountProduct());
			st.setInt(4,t.getPriceProduct());

			System.out.println("After : " + st.toString());
			st.executeUpdate(); 
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return 0;
	}

	@Override
	public int update(Orders_detail t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Orders_detail t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Orders_detail> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders_detail selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Orders_detail> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders_detail selectByCondition(String condition1, String condition2) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
