package controller.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BrandDAO;
import dao.CategoryDAO;
import dao.ProductDAO;
import model.Brand;
import model.Category;
import model.Product;

/**
 * Servlet implementation class ProductList
 */
@WebServlet("/ProductList")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductList() {
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

		doPost(request, response);/**
									 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
									 *      response)
									 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String currentPage = request.getParameter("currentPage");
		String command = request.getParameter("command");
		System.out.println(command);
		ProductDAO gp = new ProductDAO();
		List<Product> listProduct = null;
		ArrayList<Category> cate = new ArrayList<Category>();
		CategoryDAO getCate = new CategoryDAO();
		ArrayList<Brand> brand = new ArrayList<Brand>();
		BrandDAO getBrand = new BrandDAO();
		String url = "";
		String sql = "/index.jsp";
		switch (command) {
		case "search":
			String input = request.getParameter("input");
			if (input != null) {
				request.setAttribute("searchKey", request.getParameter("input"));
			} else {
				input = request.getParameter("searchKey");
				request.setAttribute("searchKey", request.getParameter("searchKey"));
			}
			try {
				listProduct = gp.search(input, Integer.parseInt(currentPage) * 9 - 9, 9);
				sql = "from Product where name LIKE '%" + input + "%'";
				sql.toString();
			} catch (NumberFormatException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case "filter":
			try {
				int id = 0;
				String filter = request.getParameter("filter");
				if (filter != null) {
					session.setAttribute("filter", filter);
				} else {
					id = Integer.parseInt(request.getParameter("filterID"));
					filter = (String) session.getAttribute("filter");
				}
				System.out.println(filter);
				if (filter.equals("brand")) {
					String brandID = request.getParameter("brandID");
					if (brandID != null) {
						sql = "from Product where brandID = " + Integer.parseInt(brandID);
						request.setAttribute("filterID", request.getParameter("brandID"));
					} else {
						sql = "from Product where brandID = " + id;
						request.setAttribute("filterID", request.getParameter("brandID"));
					}
				} else {
					String categoryID = request.getParameter("categoryID");
					if (categoryID != null) {
						sql = "from Product where category = " + Integer.parseInt(categoryID);
						request.setAttribute("filterID", request.getParameter("categoryID"));
					} else {
						sql = "from Product where category = " + id;
						request.setAttribute("filterID", request.getParameter("categoryID"));
					}

				}
				String key = request.getParameter("filterID");
				if (key != null) {
					request.setAttribute("filterID", request.getParameter("filterID"));
				}
				listProduct = gp.getProductFilter(sql, Integer.parseInt(currentPage) * 9 - 9, 9);
			} catch (NumberFormatException | SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;

		case "list":
			try {
				listProduct = gp.getAllProduct(Integer.parseInt(currentPage) * 9 - 9, 9);
				sql = "from Product";
			} catch (NumberFormatException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			break;

		}

		try

		{
			brand = getBrand.getListBrand();
			cate = getCate.getListCategory();
			request.setAttribute("listBrand", brand);
			request.setAttribute("listCategory", cate);
			request.setAttribute("totalPage", gp.totalPage(sql));
			request.setAttribute("command", request.getParameter("command"));
			request.setAttribute("currentPage", currentPage);
			if (listProduct.size() > 0) {
				request.setAttribute("listProduct", listProduct);
			} else {
				request.setAttribute("EmptyListProduct", "Không có sản phẩm nào");
			}
			url = "/index.jsp";
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
