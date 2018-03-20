package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type","text/html;charset=utf-8");
		String userno=request.getParameter("userno");
		String password=request.getParameter("password");
		int type=0;
		Login lo=new Login();
		int flag=lo.loginVerify(userno, password);
		HttpSession session=request.getSession();
		if(flag==1){
			type=1;
			session.setAttribute("AUserNo", userno);
			session.setAttribute("Atype", type);
			System.out.println(session.getAttribute("AUserNo")+"登录测试");
			response.sendRedirect("iframe2.jsp");
			System.out.println("管理员登录");
		}else if(flag==2){
			type=2;
			session.setAttribute("AUserNo", userno);
			session.setAttribute("Atype", type);
			System.out.println(session.getAttribute("AUserNo")+"登录测试");
			response.sendRedirect("iframe3.jsp");
			System.out.println("采购员登录");
		}else if(flag==3){
			type=3;
			session.setAttribute("AUserNo", userno);
			session.setAttribute("Atype", type);
			System.out.println(session.getAttribute("AUserNo")+"登录测试");
			response.sendRedirect("iframe1.jsp");
			System.out.println("客户登录");
		}
		else{
			response.setContentType("text/HTML");
			PrintWriter out=response.getWriter();
			out.println("<!doctype html><HTML><head><tilte></tilte></head><body>登录失败！<a href='index.jsp'>点此处返回</a></body></HTML>");
			System.out.println("登录失败");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
