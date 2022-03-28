package Controller.Admin;


import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.Impl.ProductDaoImpl;
import Model.Product;


@WebServlet("/AdminAddProductController")
public class AdminAddProductController extends HttpServlet {

       
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductDaoImpl productDao = new ProductDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/addproduct.jsp"); 
		dispatcher.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String catalog_id =request.getParameter("catalog_id");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		int status = Integer.parseInt(request.getParameter("status"));
		String description = request.getParameter("description");
		String image_link = request.getParameter("file");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Product product = new Product(catalog_id,name,price,status,description,image_link,quantity);

		String err = "";
		String url = "addproduct.jsp";
		if (err.length() > 0) {
			request.setAttribute("err", err);
		}

		try
		{
			if(err.length()==0)
			{
				productDao.add(product);
	            response.sendRedirect("product");
			}
			else
			{
				url = "/addproduct.jsp";
				RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/addproduct.jsp");
		}

		
	}


}