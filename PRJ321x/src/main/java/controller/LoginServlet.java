package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import bean.Account;
import bean.Products;
import dao.AccountDAO;
import dao.ProductsDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String action = request.getParameter("action");
		String page = null;
		if(action == null) {
			page = "/index.jsp";
		}else if(action.equals("login")) {
			page = "/loginForm.jsp";
		}
		if (page != null) {
		    getServletContext().getRequestDispatcher(page).forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String user = request.getParameter("username");
			String pass = request.getParameter("password");
			String rem = request.getParameter("remember");
			
			//Lấy dữ liệu trong xml
			String checkUser = getServletContext().getInitParameter("username");
			String checkPass = getServletContext().getInitParameter("password");
			
			String url = "";
			
			if( user !=null && pass.equals(checkPass)&& user.equals(checkUser)) {
				url = "/admin.jsp";
				
				//Session
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				
			}else if(!user.equals("") && !pass.equals("")) {
				AccountDAO ne = AccountDAO.getInstance();
				Account accDao = ne.selectByCondition(user, pass);
				
				if(accDao!=null){
					url = "/index.jsp";
					
					HttpSession session = request.getSession();
					session.setAttribute("user", accDao.getName());

					ProductsDAO p = ProductsDAO.getInstance();
					ArrayList<Products> listProduct = p.selectAll();
					
					request.setAttribute("listProduct", listProduct);
				}else {
					url = "/loginForm.jsp";
					String mess= "User or password not correct";
					request.setAttribute("message", mess);
					request.getRequestDispatcher(url).forward(request, response);
				}
			}else {
				url = "/loginForm.jsp";
				Account acc = new Account(user, pass); 
				String mess = acc.validate();
				request.setAttribute("message", mess);
				request.getRequestDispatcher(url).forward(request, response);
			}
			
			
			//Tạo cookie
			Cookie cUser = new Cookie("cUser", user);
			Cookie cPass = new Cookie("cPass", pass);
			Cookie cRem = new Cookie("cRem", rem);
			
			//cài đặt thời gian sống cho cookie 30 ngay
			cUser.setMaxAge(60 * 60 * 24 * 30); 
			cPass.setMaxAge(60 * 60 * 24 * 30); 
			cRem.setMaxAge(60 * 60 * 24 * 30); 
			
			response.addCookie(cUser);
			response.addCookie(cPass);
			response.addCookie(cRem);
			
			request.getRequestDispatcher(url).forward(request, response);
			
		
		} catch (Exception e) {
			// TODO: handle exception
			response.getWriter().println(e);
		}
	}
	
}
