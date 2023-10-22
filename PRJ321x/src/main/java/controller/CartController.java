package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import bean.Cart;
import bean.Products;
import dao.ProductsDAO;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Get time
		LocalDateTime myDateObj = LocalDateTime.now();
		 // Cộng thêm 7 ngày
        LocalDateTime newDateObj = myDateObj.plusDays(7);
		
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		String dateStart= myDateObj.format(myFormatObj);
		 String dateEnd = newDateObj.format(myFormatObj);
		 
		 
		 HttpSession session = request.getSession(true);
		session.setAttribute("dateS", dateStart);
		session.setAttribute("dateE", dateEnd);
		request.getRequestDispatcher("/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("cart check");
		HttpSession session = request.getSession();
		String checkLogin = (String) session.getAttribute("user");
		if(checkLogin==null) {
			String mess= "to order product you must login first";
			request.setAttribute("message", mess);
			request.getRequestDispatcher("/loginForm.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/pay.jsp").forward(request, response);
		}
	}

}
