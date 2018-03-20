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
<title>供应记录</title>
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
<form action="GetContractsByDate.jsp" method="post">
开始日期：<input type="date" name="sdate" value="" required="required" />截止日期：<input type="date" name="edate" value="" required="required" />
<input type="submit" name="查询" value="查询" />
</form>
<%
request.setCharacterEncoding("UTF-8");
response.setHeader("Content-Type","text/html;charset=utf-8");
String sdate=request.getParameter("sdate");
String  edate=request.getParameter("edate");
if(sdate!=null&&edate!=null&&!sdate.equals("")&&!edate.equals("")){

%>
<div class="table-responsive">
<table class="table table-hover">
<caption>合同信息</caption>
<thead>
<tr>
<th>合同编号</th>
<th>合同名称</th>
<th>供应商编号</th>
<th>货物号</th>
<th>货物名称</th>
<th>货物配置</th>
<th>数量</th>
<th>单价</th>
<th>进货日期</th>
<th>进货人员编号</th>
<th>进货人姓名</th>
<th>进货人员类型</th>
<th>供应商名称</th>
<th>供应商地址</th>
<th>联系人</th>
</tr>
</thead>
<tbody>
<%
List<ContractsIfo> list1=new ArrayList<ContractsIfo>();
list1=ContractsDao.getAllByDate(sdate, edate);
if(list1!=null){
for(int i=0;i<list1.size();i++){
ContractsIfo c=list1.get(i);
%>
<tr>
<td><%=c.getCno() %></td>
<td><%=c.getCname() %></td>
<td><%=c.getSno() %></td>
<td><%=c.getGno() %></td>
<td><%=c.getGname()  %></td>
<td><%=c.getGother() %></td>
<td><%=c.getNum() %></td>
<td><%=c.getPrice() %></td>
<td><%=c.getCdate() %></td>
<td><%=c.getUserno() %></td>
<td><%=c.getUsername() %></td>
<td><%=c.getUsertype() %></td>
<td><%=c.getSname() %></td>
<td><%=c.getSadress() %></td>
<td><%=c.getLinkman() %></td>
</tr>
<%}
}} %></tbody>
</table>
</div>
</body>
</html>