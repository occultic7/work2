<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="bean.*,dao.*,java.util.*" %>
<%String auserno=(String)session.getAttribute("AUserNo");int atype=(Integer)session.getAttribute("Atype");if(auserno==null||auserno.equals("")||atype!=1) {response.sendRedirect("index.jsp");}%>
<%request.setCharacterEncoding("utf-8") ;
response.setHeader("Content-Type","text/html;charset=utf-8");%>
<!DOCTYPE html ">
<html>
<head>
<meta charset="utf-8">
<title>模糊查询2</title>
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
<br>
<form action="GetStockOutByDateOrUser.jsp" method="post">
出库人姓名:<input type="text" name="username" value="" required="required"/>
开始时间：<input type="datetime-local" name="stime" value="2018-01-09T00:00" required="required" />
截止时间：<input type="datetime-local" name="etime" value="2018-01-17T15:12:25" required="required" />
<input type="submit" name="查询" value="查询" />
</form>
<%
request.setCharacterEncoding("UTF-8");
response.setHeader("Content-Type","text/html;charset=utf-8");
String uname=request.getParameter("username");
String stime=request.getParameter("stime");
String  etime=request.getParameter("etime");
System.out.print("GetStockOutByDateOrUser.jsp测试：");
System.out.print(uname);
System.out.print(stime);
System.out.print(etime);
if(stime!=null&&etime!=null&&!stime.equals("")&&!etime.equals("")){

%>
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
</tr></thead>
<tbody>
<%
List<StockOutIfo> list1=new ArrayList<StockOutIfo>();
list1=StockOutDao.getStockOutByDateOrUser(uname, stime, etime);
for(int i=0;i<list1.size();i++){
StockOutIfo s=list1.get(i);
if(s!=null){
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

</tr>
<%}}} %></tbody>
</table>
</body>
</html>