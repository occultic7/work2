<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*,java.util.* ,dao.*,bean.*" %>
<%String auserno=(String)session.getAttribute("AUserNo");int atype=(Integer)session.getAttribute("Atype");if(auserno==null||auserno.equals("")||atype!=3) {response.sendRedirect("index.jsp");}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%StockOut oldone=(StockOut)request.getAttribute("oldone"); %>


	<form action="/work2/UpdateStockOutServlet" method="post">
		修改出库信息<br />
		<table>
		<input type="hidden" name="oldid" value=<%=oldone.getOutno() %> /> 
			<tr>
				<td>出库编号：</td>
				<td><input type="text" name="outno" value=<%=oldone.getOutno() %> readonly  ><br /></td>
			</tr>
			<tr>

				<td>货物编号：</td>
				<td><input type="text" name="Gno"  value=<%=oldone.getGno() %> readonly  ><br /></td>
			</tr>
			
			<tr> 
				<td>出库数量：</td>
				<td><input type="number" name="outnum" min="0" max="10000"     value=<%=oldone.getOutnum() %> /></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交"></td>
				<td><input type="reset" value="重置"></td>
			</tr>
		</table>
	</form>
</body>
</html>