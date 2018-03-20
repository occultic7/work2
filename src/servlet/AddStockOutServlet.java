package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.StockOut;
import dao.StockOutDao;

/**
 * Servlet implementation class AddStockOutServlet
 */
@WebServlet("/AddStockOutServlet")
public class AddStockOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStockOutServlet() {
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
		HttpSession session=request.getSession();
		String auserno=(String)session.getAttribute("AUserNo");
		String outno=request.getParameter("outno");
		System.out.println(outno);
		String Gno=request.getParameter("Gno");
		int outnum=Integer.parseInt(request.getParameter("outnum"));
		Date d=new Date();
		StockOut stockout1=new StockOut();
		stockout1.setOutno(outno);
		stockout1.setGno(Gno);
		stockout1.setOutnum(outnum);
		stockout1.setOuttime(d);
		stockout1.setUserno(auserno);
		boolean b=StockOutDao.add(stockout1);
		if(b==true){
			System.out.println("插入成功！");
		}else{
			System.out.println("插入失败！");
		}
		response.sendRedirect("GetStockOutByUserNoServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
