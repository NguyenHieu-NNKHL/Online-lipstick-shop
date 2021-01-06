package controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import get.BrandDAO;
import model.Brand;

@WebServlet("/admin/brand/list")
public class listBrand extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		List<Brand> brandList;
		BrandDAO brandDao = new BrandDAO();
		try {
			brandList = brandDao.getListBrand();
			req.setAttribute("brandList", brandList);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/brandList.jsp");
			dispatcher.forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}