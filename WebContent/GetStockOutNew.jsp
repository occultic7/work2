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
<title>出库统计</title>
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
<form action="GetStockOutNew.jsp" method="post">
开始时间：<input type="datetime-local" name="stime" value="2018-01-01T00:00" required="required" />截止时间：<input type="datetime-local" name="etime" value="2018-01-18T00:00" required="required" />
<input type="submit"  name="查询"  />
</form>
<%
request.setCharacterEncoding("UTF-8");
response.setHeader("Content-Type","text/html;charset=utf-8");
String stime=request.getParameter("stime");
String  etime=request.getParameter("etime");
System.out.print("GetStockOutNew.jsp测试：");
System.out.print(stime);
System.out.print(etime);
if(stime!=null&&etime!=null&&!stime.equals("")&&!etime.equals("")){

%>
<table class="table table-hover">
<caption>统计记录</caption>
<thead>
<tr>
<th>商品编号</th>
<th>商品名称</th>
<th>出库总数</th>
</tr></thead>
<tbody>
<%
List<StockOutNew> list1=new ArrayList<StockOutNew>();
list1=StockOutDao.getStockOutNewByDate(stime, etime);
for(int i=0;i<list1.size();i++){
StockOutNew s=list1.get(i);
if(s!=null){
%>
<tr>
<td><%=s.getGno() %></td>
<td><%=s.getGname() %></td>
<td><%=s.getOutnum() %></td>

</tr>
<%}}} %></tbody>
</table>
</body>
</html>