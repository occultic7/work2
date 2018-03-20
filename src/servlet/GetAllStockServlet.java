package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.MyPage;
import bean.StockIfo;
import dao.StockDao;

/**
 * Servlet implementation class GetAllStockServlet
 */
@WebServlet("/GetAllStockServlet")
public class GetAllStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllStockServlet() {
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
		List<StockIfo> list=new ArrayList<StockIfo>();
		int pageNo=1;
		int pageCount=10;
		if(request.getParameter("pageCount")!=null){
			pageCount=Integer.parseInt(request.getParameter("pageCount"));
			//System.out.println("总页数"+pageCount);
		}
		if(request.getParameter("pageNo")!=null&&(Integer.parseInt(request.getParameter("pageNo"))>0)&&
				(Integer.parseInt(request.getParameter("pageNo"))<=pageCount)){
			pageNo=Integer.parseInt(request.getParameter("pageNo"));
			System.out.println("页码"+pageNo);
		}
		MyPage mypage=new MyPage();
		mypage=StockDao.getAllWithPage(pageNo, 10);
		request.setAttribute("mypage", mypage);
		request.getRequestDispatcher("GetAllStock.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
