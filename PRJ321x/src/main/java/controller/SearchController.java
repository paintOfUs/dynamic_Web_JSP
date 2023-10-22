package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Products;
import dao.ProductsDAO;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Working");
		String inpSearch = request.getParameter("textinp");
		ArrayList<Products> list = null;
		
		ProductsDAO ne = ProductsDAO.getInstance();
		list = ne.selectByCondition(inpSearch);
		int size = list.size();
		if(size==0) {
			list=null;
		}
			
		//Css
		request.setAttribute("center", "justify-content-center");
		request.setAttribute("allProduct", "Products have found:");
		request.setAttribute("count", size);
		
		//danh sách sản phẩm
		request.setAttribute("listProduct", list);
		
		
		//lưu lại giá trị vừa nhập trên ô input
		request.setAttribute("text", inpSearch);
		
		//biến kiểm tra đang ở trang nào
		request.setAttribute("check", "");
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
