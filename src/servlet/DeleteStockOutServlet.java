package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StockOutDao;


/**
 * Servlet implementation class DeleteStockOutServlet
 */
@WebServlet("/DeleteStockOutServlet")
public class DeleteStockOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStockOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type","text/html;charset=utf-8");
		String outno=request.getParameter("outno");
		response.setContentType("text/HTML");
		
		boolean flag=StockOutDao.delete(outno);
		if(flag){
			
			System.out.println("删除成功！");

		}else{
			
			System.out.println("删除成功！");

		}
		response.setHeader("Refresh", "0.5;URL=GetStockOutByUserNoServlet");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
