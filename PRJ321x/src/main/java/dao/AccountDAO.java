package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.Account;
import database.ConnectJDBC;

public class AccountDAO implements DAOInterface<Account> {
	
	public static AccountDAO getInstance() {	
		return new AccountDAO();	
	}

	@Override
	public int insert(Account t) {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectJDBC.getConnection();
			
			String sql = "INSERT INTO Account(user_mail, password, account_role, user_name) VALUES (?, ?, 1, ?)";
			
			System.out.println(sql);
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,t.getUserEmail());
			st.setString(2,t.getPwd());
			st.setString(3, t.getName());
			System.out.println("statement");
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
	public int update(Account t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Account t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Account> selectAll() {
		// TODO Auto-generated method stub
		try {
			Connection con = ConnectJDBC.getConnection();
			
			String sql = "select * from Account";
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
            System.out.println(rs.getString(1) + "  " + rs.getString(2) 
                      + "  " + rs.getInt(3) + "  " + rs.getString(4)
                      + "  " + rs.getString(5) + "  " + rs.getString(6));
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public Account selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Account> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		AccountDAO ne;
		ne = AccountDAO.getInstance();
		ne.selectAll();
	}

	@Override
	public Account selectByCondition(String condition1, String condition2) {
		try {
			Connection con = ConnectJDBC.getConnection();
			
			String sql = "select * from Account "
					+ "where user_mail = ? and password = ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1,condition1);
			st.setString(2,condition2);
			System.out.println("After : " + st.toString());
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				System.out.println("===================================");
				System.out.println(rs.getNString(1)+" "+ rs.getNString(2)+" "+rs.getString(4));
				System.out.println("===================================");
				return new Account(rs.getNString(1), rs.getNString(2),rs.getString(4));
			}
			
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return null;
	}
}
