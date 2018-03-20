package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StockOut;
import bean.StockOutIfo;
import dao.StockOutDao;

/**
 * Servlet implementation class ShowUpdateStockOutServlet
 */
@WebServlet("/ShowUpdateStockOutServlet")
public class ShowUpdateStockOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUpdateStockOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type","text/html;charset=utf-8");
		String outno=request.getParameter("outno");
		StockOut s=StockOutDao.getone(outno);
		request.setAttribute("oldone", s);
		request.getRequestDispatcher("UpdateStockOut.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
