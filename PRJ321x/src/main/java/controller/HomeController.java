package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Products;
import bean.Cart;
import dao.ProductsDAO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductsDAO ne = ProductsDAO.getInstance();
		ArrayList<Products> listAllProduct =ne.selectAll();
		
		int count = listAllProduct.size();
		String page = request.getParameter("page");
		
		int index;
		if(page==null) {
			index = 1;
		}else {
			index = Integer.parseInt(page);
		}
		
		int countPage = ne.getNumberPage(6);
		ArrayList<Products> listProduct = ne.selectByCondition(index, 6);
		
		//css và số lượng sản phẩm
		request.setAttribute("center", "");
		request.setAttribute("allProduct", "All product:");
		request.setAttribute("count", count);
		
		//danh sách các sản phẩm
		request.setAttribute("listProduct", listProduct);
		
		//số trang
		request.setAttribute("page", index);
		request.setAttribute("numpage", countPage);
		
		//kiểm tra đang ở trang nào
		request.setAttribute("check","checked");
		
		String url = "/index.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
