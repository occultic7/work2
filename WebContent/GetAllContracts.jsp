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
<title>合同信息</title>
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
<div class="table-responsive">
<table class="table table-hover" >
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
request.setCharacterEncoding("UTF-8");
response.setHeader("Content-Type","text/html;charset=utf-8");
List<ContractsIfo> list1=new ArrayList<ContractsIfo>();
MyPage page1=(MyPage)request.getAttribute("mypage");
int pageNo=page1.getPageNo();
int pageCount=page1.getPageCount();
list1=page1.getList();
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
} %>
</tbody>
</table>
</div>

<div class="page">
总共<%=page1.getRecordCount()%> 条记录，分为   <%=pageCount %>页，这是第<%=pageNo %>页
<a href="GetAllContractsServlet?pageNo=<%=pageNo-1 %>&pageCount=<%=pageCount %>">上一页</a>
<a href="GetAllContractsServlet?pageNo=<%=pageNo+1 %>&pageCount=<%=pageCount%>">下一页</a>
<form action="GetAllContractsServlet" method="post">
<input type="hidden" name="pageCount" value=<%=pageCount %>  />
<input type="number" name="pageNo" min="1" max="<%=pageCount %>"  required="required"  /> <input type="submit" value="跳转" />
</form>
</div>
</body>
</html>