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
 * Servlet implementation class UpdateStockOutServlet
 */
@WebServlet("/UpdateStockOutServlet")
public class UpdateStockOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStockOutServlet() {
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
		String Gno=request.getParameter("Gno");
		int outnum=Integer.parseInt(request.getParameter("outnum"));
		HttpSession session=request.getSession();
		String userno=(String) session.getAttribute("AUserNo");
		Date d=new Date();
		StockOut s=new StockOut();
		s.setOutno(outno);
		s.setGno(Gno);
		s.setOutnum(outnum);
		s.setOuttime(d);
		s.setUserno(userno);
		boolean b=StockOutDao.update(s);
		if(b==true){
			System.out.println("修改成功！");
		}else{
			System.out.println("修改失败！");
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
