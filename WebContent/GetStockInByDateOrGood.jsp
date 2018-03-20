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
<title>模糊查询1</title>
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
<form action="GetStockInByDateOrGood.jsp" method="post">
商品名称:<input type="text" name="Gname" value="" required="required"/>
开始时间：<input type="datetime-local" name="stime" value="2018-01-09T00:00" required="required" />
截止时间：<input type="datetime-local" name="etime" value="2018-01-15T00:00" required="required" />
<input type="submit" name="查询" value="查询" />
</form>
<%
request.setCharacterEncoding("UTF-8");
response.setHeader("Content-Type","text/html;charset=utf-8");
String Gname=request.getParameter("Gname");
String stime=request.getParameter("stime");
String  etime=request.getParameter("etime");
System.out.print("GetStockInByDateOrGood.jsp测试：");
System.out.println(Gname);
System.out.println(stime);
System.out.println(etime);
if(stime!=null&&etime!=null&&!stime.equals("")&&!etime.equals("")){

%>
<table>
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
List<StockInIfo> list1=new ArrayList<StockInIfo>();
list1=StockInDao.getStockInByDateOrGood(Gname, stime, etime);
for(int i=0;i<list1.size();i++){
StockInIfo s=list1.get(i);
if(s!=null){
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
<%}}} %></tbody>
</table>
</body>
</html>