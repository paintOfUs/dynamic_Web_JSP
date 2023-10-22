package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cart;
import bean.Products;
import dao.ProductsDAO;

/**
 * Servlet implementation class CartEdit
 */
@WebServlet("/cartedit")
public class CartEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartEdit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// lấy id rồi kiểm tra trong db
		String proID = request.getParameter("productId");
		ProductsDAO ne = ProductsDAO.getInstance();
		ArrayList<Products> listAllProduct = ne.selectAll();
		Products item = ne.selectById(proID);

		HttpSession session = request.getSession(true);
		Object checkCart = session.getAttribute("cart");
		Cart cart = null;
		if (checkCart != null) {
			cart = (Cart) checkCart;
		} else {
			try {
				cart = new Cart();
			} catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		cart.add(item);

		session.setAttribute("cart", cart);
		request.getRequestDispatcher("/home").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("do Post");
		HttpSession session = request.getSession(true);
		Object checkCart = session.getAttribute("cart");
		Cart cart = null;

		if (checkCart != null) {
			cart = (Cart) checkCart;
		} else {
			try {
				cart = new Cart();
			} catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		String id = request.getParameter("pid");
		String action = request.getParameter("action");

		if (id == null) {
			System.out.println("null cart");
		} else {
			int pid = Integer.parseInt(id);
			System.out.println(pid);
			System.out.println("start");
			System.out.println(action);
			if (action != null) {
				if(action.equals("remove")) {
					System.out.println("remove");
					cart.remove(pid);
				}else if (action.equals("abstract")) {
					System.out.println("abstract");
					int quantity = cart.getProduct(pid).getNum() - 1;
					cart.getProduct(pid).setNum(quantity);
				} else if (action.equals("add")) {
					int quantity = cart.getProduct(pid).getNum() + 1;
					cart.getProduct(pid).setNum(quantity);
				}
			}
		}

		session.setAttribute("cart", cart);
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

}
