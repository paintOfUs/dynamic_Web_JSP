package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Orders;
import bean.Products;
import database.ConnectJDBC;
public class OrdersDAO implements DAOInterface<Orders> {
	
	public static OrdersDAO getInstance() {
		return new OrdersDAO();
	}

	@Override
	public int insert(Orders t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectJDBC.getConnection();
			
			String sql = "INSERT INTO Orders(user_mail, order_status, order_date, order_address) VALUES (?, 1, ?, ?)";
			
			System.out.println(sql);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,t.getUserEmail());
			st.setDate(2,t.getOrderDate());
			st.setNString(3, t.getOrderAddress());

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
	public int update(Orders t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Orders t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Orders> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders selectById(String t) {
		try {
			Connection con = ConnectJDBC.getConnection();

			String sql = "select * from Orders\n" + "where user_mail = ?";
			System.out.println(sql);
			PreparedStatement st = con.prepareStatement(sql);
			
			
			st.setString(1,t);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				return new Orders(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getNString(5),
						rs.getNString(6));
			}

			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public ArrayList<Orders> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders selectByCondition(String condition1, String condition2) {
		// TODO Auto-generated method stub
		return null;
	}

}
