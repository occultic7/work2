<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="bean.*,dao.*,java.util.*" %>
<%String auserno=(String)session.getAttribute("AUserNo");int atype=(Integer)session.getAttribute("Atype");if(auserno==null||auserno.equals("")||atype!=3) {response.sendRedirect("index.jsp");}%>
<%request.setCharacterEncoding("utf-8") ;
response.setHeader("Content-Type","text/html;charset=utf-8");%>
<!DOCTYPE html ">
<html>
<head>
<meta charset="utf-8">
<title>出库信息</title>
	<link rel="stylesheet" href="css/bootstrap-3.3.7-dist/css/bootstrap.min.css">  
	<script src="js/jquery-2.1.1/jquery.min.js"></script>
	<script src="css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<style type="text/css">
		 table {
			font-size: 0.8em;
		}
	</style>
</head>
<body>
<table class="table table-hover">
<caption>出库信息</caption>
<thead>
<tr>
<th>出库单编号</th>
<th>商品编号</th>
<th>商品名称</th>
<th>出库数量</th>
<th>出库人编号</th>
<th>出库人姓名</th>
<th>出库人类型</th>
<th>出库时间</th>
<th>编辑</th>
<th>删除</th>
</tr></thead>
<tbody>
<%
request.setCharacterEncoding("UTF-8");
response.setHeader("Content-Type","text/html;charset=utf-8");
//String userno=(String) session.getAttribute("AUserNo");
//List<StockOutIfo> list=StockOutDao.getAllByUserNo(userno);
List<StockOutIfo> list1=new ArrayList<StockOutIfo>();
list1=(List<StockOutIfo>)request.getAttribute("list");
for(int i=0;i<list1.size();i++){
StockOutIfo s=list1.get(i);
%>
<tr>
<td><%=s.getOutno() %></td>
<td><%=s.getGno() %></td>
<td><%=s.getGname() %></td>
<td><%=s.getOutnum() %></td>
<td><%=s.getUserno() %></td>
<td><%=s.getUsername() %></td>
<td><%=s.getUsertype() %></td>
<td><%=s.getOuttime() %></td>
<td><a href="ShowUpdateStockOutServlet?outno=<%=s.getOutno()%>">修改</a></td>
<td><a href="DeleteStockOutServlet?outno=<%=s.getOutno() %>"  onclick="if(!confirm('确认删除？')) return false;" >删除</a></td>
</tr>
<%} %></tbody>
</table>
</body>
</html>