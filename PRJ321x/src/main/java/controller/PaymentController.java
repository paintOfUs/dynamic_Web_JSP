package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Cart;
import bean.Orders;
import bean.Orders_detail;
import bean.Products;
import dao.Order_detailDAO;
import dao.OrdersDAO;

/**
 * Servlet implementation class PaymentController
 */
@WebServlet("/payment")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Cart cart =(Cart) session.getAttribute("cart");
		
		
		
		session.setAttribute("cart", cart);
		request.getRequestDispatcher("/pay.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Object cartcheck =session.getAttribute("cart");
		Cart cart=null;
		if (cartcheck != null) {
			cart = (Cart) cartcheck;
		} else {
			try {
				cart = new Cart();
			} catch (Exception e) {
				// TODO: handle exception
				e.getMessage();
			}
		}
		System.out.println("check emai address");
		String user_email = request.getParameter("email");
		String user_address = request.getParameter("address");
		
		long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        System.out.println(date);
		Orders order = new Orders(user_email,date, user_address);
		
		OrdersDAO ne = OrdersDAO.getInstance();
		ne.insert(order);
		
		Orders cOrder = ne.selectById(user_email);
		System.out.println("ORDER: "+cOrder);
		
		for (Products x : cart.getItems()) {
			int id = cOrder.getOrderId();
			int pid = x.getProductId();
			int quantity = x.getNum();
			int price = (int) Math.round(x.getPrice()*x.getNum());
			Orders_detail order_detail = new Orders_detail(id,pid,quantity,price);
			Order_detailDAO neo= Order_detailDAO.getInstance();
			neo.insert(order_detail);
		};
		session.removeAttribute("cart");
		request.getRequestDispatcher("/cart.jsp").forward(request, response);
	}

}
