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
<title>库存信息</title>
	<link rel="stylesheet" href="css/bootstrap-3.3.7-dist/css/bootstrap.min.css">  
	<script src="js/jquery-2.1.1/jquery.min.js"></script>
	<script src="css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<style type="text/css">
		 table {
			font-size: 0.5em;
		}
	</style>
</head>
<body>
<br>
<form action="GetStockByGood.jsp" method="post">
商品名称：<input type="text" name="Gname" value="" required="required" />类别名称：<input type="text" name="Tname" value="" required="required" />
<input type="submit" name="查询" value="查询" />
</form>
<%
request.setCharacterEncoding("UTF-8");
response.setHeader("Content-Type","text/html;charset=utf-8");
String gname=request.getParameter("Gname");
String  tname=request.getParameter("Tname");
if(gname!=null&&tname!=null&&!gname.equals("")&&!tname.equals("")){

%>
<table  class="table table-hover">
<caption>库存信息</caption>
<thead>
<tr>
<th>商品编号</th>
<th>商品名称</th>
<th>类型编号</th>
<th>类型名称</th>
<th>配置信息</th>
<th>库存数量</th>
</tr></thead>
<%
List<StockIfo> list1=new ArrayList<StockIfo>();
list1=StockDao.getAllByGood(gname, tname);
if(list1!=null){
for(int i=0;i<list1.size();i++){
StockIfo s=list1.get(i);
%>
<tbody>
<tr>
<td><%=s.getGno() %></td>
<td><%=s.getGname() %></td>
<td><%=s.getTno() %></td>
<td><%=s.getTname() %></td>
<td><%=s.getGother() %></td>
<td><%=s.getStocknum() %></td>
</tr>
<%}
}} %></tbody>
</table>
</body>
</html>