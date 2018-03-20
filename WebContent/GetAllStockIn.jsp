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
<title>入库信息</title>
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
<caption>入库信息</caption>
<thead>
<tr>
<th>入库单号</th>
<th>合同号</th>
<th>货物号</th>
<th>货物名称</th>
<th>单价</th>
<th>数量</th>
<th>入库时间</th>
<th>入库人编号</th>
<th>入库人类型</th>
<th>入库人姓名</th>
<th>供应商号</th>
<th>供应商名称</th>
<th>供应商地址</th>
<th>联系人</th>
</tr></thead>
<tbody>
<%
request.setCharacterEncoding("UTF-8");
response.setHeader("Content-Type","text/html;charset=utf-8");
List<StockInIfo> list1=new ArrayList<StockInIfo>();
MyPage page1=(MyPage)request.getAttribute("mypage");
int pageNo=page1.getPageNo();
int pageCount=page1.getPageCount();
list1=page1.getList();
for(int i=0;i<list1.size();i++){
StockInIfo s=list1.get(i);
%>
<tr>
<td><%=s.getInno() %></td>
<td><%=s.getCno() %></td>
<td><%=s.getGno() %></td>
<td><%=s.getGname() %></td>
<td><%=s.getPrice() %></td>
<td><%=s.getInnum() %></td>
<td><%=s.getIntime() %></td>
<td><%=s.getUserno() %></td>
<td><%=s.getUsertype() %></td>
<td><%=s.getUsername() %></td>
<td><%=s.getSno() %></td>
<td><%=s.getSname() %></td>
<td><%=s.getSadress() %></td>
<td><%=s.getLinkman() %></td>
</tr>
<%} %>
</tbody>
</table>
<div class="page">
总共<%=page1.getRecordCount()%> 条记录，分为   <%=pageCount %>页，这是第<%=pageNo %>页
<a href="GetAllStockInServlet?pageNo=<%=pageNo-1 %>&pageCount=<%=pageCount %>">上一页</a>
<a href="GetAllStockInServlet?pageNo=<%=pageNo+1 %>&pageCount=<%=pageCount%>">下一页</a>
<form action="GetAllStockInServlet" method="post">
<input type="hidden" name="pageCount" value=<%=pageCount %>  />
<input type="number" name="pageNo" min="1" max="<%=pageCount %>"  required="required"  /> 
<input type="submit" value="跳转" />
</form>
</div>
</body>
</html>