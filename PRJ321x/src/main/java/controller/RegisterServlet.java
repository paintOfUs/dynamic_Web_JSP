package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Account;
import dao.AccountDAO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("registerForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String url = "";
		try {
			String username = request.getParameter("username");
			String pass = request.getParameter("password");
			String email = request.getParameter("email");
			String repass = request.getParameter("repass");
			
			if(pass.equals(repass)) {
				Account user = new Account(email, pass, username);
				System.out.println("servlet");
				AccountDAO ne = AccountDAO.getInstance();
				ne.insert(user);
				ne.selectAll();
				
				url="/loginForm.jsp";
				
				
			}else {
				url="/registerForm.jsp";
				String mess = "Password and repass not match";
				request.setAttribute("mess", mess);
			}
			
			request.getRequestDispatcher(url).forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
