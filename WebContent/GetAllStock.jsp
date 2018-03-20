<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="bean.*,dao.*,java.util.*" %>
<%String auserno=(String)session.getAttribute("AUserNo");int atype=(Integer)session.getAttribute("Atype");if(auserno==null||auserno.equals("")||!(atype==1||atype==3)) {response.sendRedirect("index.jsp");}%>
<%request.setCharacterEncoding("utf-8") ;
response.setHeader("Content-Type","text/html;charset=utf-8");%>
<!DOCTYPE html >
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
<table class="table table-hover">
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
<tbody>
<%
request.setCharacterEncoding("UTF-8");
response.setHeader("Content-Type","text/html;charset=utf-8");
List<StockIfo> list1=new ArrayList<StockIfo>();
MyPage page1=(MyPage)request.getAttribute("mypage");
int pageNo=page1.getPageNo();
int pageCount=page1.getPageCount();
list1=page1.getList();
if(list1!=null){
for(int i=0;i<list1.size();i++){
StockIfo s=list1.get(i);
%>
<tr>
<td><%=s.getGno() %></td>
<td><%=s.getGname() %></td>
<td><%=s.getTno() %></td>
<td><%=s.getTname() %></td>
<td><%=s.getGother() %></td>
<td><%=s.getStocknum() %></td>
</tr>
<%}
} %>
</tbody>
</table>
<div class="page">
总共<%=page1.getRecordCount()%> 条记录，分为   <%=page1.getPageCount() %>页，这是第<%=pageNo %>页
<a href="GetAllStockServlet?pageNo=<%=pageNo-1 %>&pageCount=<%=pageCount %>">上一页</a>
<a href="GetAllStockServlet?pageNo=<%=pageNo+1 %>&pageCount=<%=pageCount %>">下一页</a>
<form action="GetAllStockServlet" method="post">
<input type="hidden" name="pageCount" value=<%=pageCount %>  />
<input type="number" name="pageNo" min="1" max="<%=pageCount %>"  required="required"  /> 
<input type="submit" value="跳转" />
</form>
</div>
</div>
</body>
</html>