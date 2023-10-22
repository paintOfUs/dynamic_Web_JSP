package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import bean.Products;
import database.ConnectJDBC;

public class ProductsDAO implements DAOInterface<Products> {

	public static ProductsDAO getInstance() {

		return new ProductsDAO();

	}

	@Override
	public int insert(Products t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Products t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Products t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Products> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<Products> list = new ArrayList<Products>();
		try {
			Connection con = ConnectJDBC.getConnection();

			String sql = "select * from Products";

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
//				System.out.println(rs.getInt(1) + "  " + rs.getNString(2) + "  " + rs.getNString(3) + "  "
//						+ rs.getDouble(4) + "  " + rs.getNString(5) + "  " + rs.getNString(6) + " " + rs.getNString(7));

				Products product = new Products(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getDouble(4),
						rs.getNString(5), rs.getNString(6), rs.getNString(7));
				list.add(product);
			}

			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public Products selectById(String t) {
		try {
			Connection con = ConnectJDBC.getConnection();

			String sql = "select * from Products\n" + "where product_id = ?";
			System.out.println(sql);
			PreparedStatement st = con.prepareStatement(sql);
			
			
			st.setInt(1,Integer.parseInt(t));
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
//				System.out.println(rs.getInt(1) + "  " + rs.getNString(2) + "  " + rs.getNString(3) + "  "
//						+ rs.getDouble(4) + "  " + rs.getNString(5) + "  " + rs.getNString(6) + " " + rs.getNString(7));

				return new Products(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getDouble(4), rs.getNString(5),
						rs.getNString(6), rs.getNString(7));
			}

			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public ArrayList<Products> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		ArrayList<Products> list = new ArrayList<Products>();
		try {
			Connection con = ConnectJDBC.getConnection();

			String sql = "select * from Products\r\n" + "where product_name like ?";

			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, "%" + condition + "%");
			ResultSet rs = st.executeQuery();

			System.out.println("===========================================");
			while (rs.next()) {
//				System.out.println(rs.getInt(1) + "  " + rs.getNString(2) + "  " + rs.getNString(3) + "  "
//						+ rs.getDouble(4) + "  " + rs.getNString(5) + "  " + rs.getNString(6) + " " + rs.getNString(7));

				Products product = new Products(rs.getInt(1), rs.getNString(2), rs.getNString(3), rs.getDouble(4),
						rs.getNString(5), rs.getNString(6), rs.getNString(7));
				list.add(product);
			}
			System.out.println("===============================================");
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public ArrayList<Products> selectByCondition(int index, int numProduct) {
		ArrayList<Products> list = new ArrayList<Products>();
		try {
			Connection con = ConnectJDBC.getConnection();

			String sql = "select * from Products\r\n"
					+ "limit ?,?";
			
			System.out.println(sql);
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, (index-1)*numProduct);
			st.setInt(2, numProduct);
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				list.add(new Products(rs.getInt(1), rs.getNString(2),
						rs.getNString(3),rs.getDouble(4), 
						rs.getNString(5),
						rs.getNString(6),
						rs.getNString(7)));
			}

			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public Products selectByCondition(String condition1, String condition2) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getNumberPage(int numProduct) {
		try {
			Connection con = ConnectJDBC.getConnection();

			String sql = "select count(*) from Products";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				int record = rs.getInt(1);
				int countPage = 0;
				if (record % numProduct != 0) {
					countPage = (record / numProduct) + 1;
				} else {
					countPage = record / numProduct;
				}
				return countPage;
			}
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

}
