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
</tr></thead>
<tbody>
<%
List<StockOutIfo> list1=new ArrayList<StockOutIfo>();

MyPage page1=(MyPage)request.getAttribute("mypage");
int pageNo=page1.getPageNo();
int pageCount=page1.getPageCount();
list1=page1.getList();
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
</tr>
<%} %></tbody>
</table>

<div class="page">
总共<%=page1.getRecordCount()%> 条记录，分为   <%=pageCount %>页，这是第<%=pageNo %>页
<a href="GetAllStockOutServlet?pageNo=<%=pageNo-1 %>&pageCount=<%=pageCount %>">上一页</a>
<a href="GetAllStockOutServlet?pageNo=<%=pageNo+1 %>&pageCount=<%=pageCount%>">下一页</a>
<form action="GetAllStockOutServlet" method="post">
<input type="hidden" name="pageCount" value=<%=pageCount %>  />
<input type="number" name="pageNo" min="1" max="<%=pageCount %>"  required="required"  /> 
<input type="submit" value="跳转" />
</form>
</div>
</body>
</html>