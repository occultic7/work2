package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.MyPage;
import bean.StockInIfo;
import dao.ContractsDao;
import dao.StockInDao;


/**
 * Servlet implementation class GetAllStockInServlet
 */
@WebServlet("/GetAllStockInServlet")
public class GetAllStockInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllStockInServlet() {
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
		int pageNo=1;
		int pageCount=10;
		if(request.getParameter("pageCount")!=null){
			pageCount=Integer.parseInt(request.getParameter("pageCount"));
			//System.out.println("总页数"+pageCount);
		}
		if(request.getParameter("pageNo")!=null&&(Integer.parseInt(request.getParameter("pageNo"))>0)&&(Integer.parseInt(request.getParameter("pageNo"))<=pageCount)){
			pageNo=Integer.parseInt(request.getParameter("pageNo"));
			System.out.println("页码"+pageNo);
		}
		MyPage mypage=new MyPage();
		mypage=StockInDao.getAllWithPage(pageNo, 10);
		request.setAttribute("mypage", mypage);
		request.getRequestDispatcher("GetAllStockIn.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
