package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GoodsDaoImpl;
import dbUtil.DBConnectionFactory;
import entity.Cart;
import entity.Goods;

/**
 * Servlet implementation class HandleServlet
 */
@WebServlet("/handleServlet")
public class HandleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HandleServlet() {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int status = Integer.parseInt(request.getParameter("status"));
		int id = Integer.parseInt(request.getParameter("goodsId"));
		HttpSession session = request.getSession();
		Goods goods = (Goods) session.getAttribute("goodsId" + id);
		Cart cart = new Cart();
		if (status == 1) {
			// 添加到购物车
			cart.addGoods(goods, 1);
		} else if (status == -1) {
			// 删除购物车中的商品
			cart.deleteGoods(goods, 1);
		}
		response.sendRedirect("cart.jsp");
	}

}
