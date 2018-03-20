<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String auserno=(String)session.getAttribute("AUserNo");int atype=(Integer)session.getAttribute("Atype");if(auserno==null||auserno.equals("")||atype!=3) {response.sendRedirect("index.jsp");}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/bootstrap-3.3.7-dist/css/bootstrap.min.css">  
	<style type="text/css">
	legend{
		font-size: 0.9em;
	}
	 table {
		font-size: 0.8em;
	}
	input[type="number"]{
		width:150px;
	}
	input[type="reset"]{
		margin-left:110px;
	}
	</style>
</head>
<body>

<form action="/work2/AddStockOutServlet" method="post">
<br>
<fieldset>
<br>
<legend>添加出库单</legend>
<table>
<tr>
<td>出库单编号:</td>
<td><input type="text" name="outno"  required="required" /></td>
</tr>
<tr>
<td>商品编号:</td>
<td><input type="text" name="Gno"  required="required"  /></td>
</tr>
<tr>
<td>出库数量:</td>
<td><input type="number" name="outnum" min="0" max="10000"   required="required" /></td>
</tr>
<tr>
<td><input type="submit" name="提交"/></td>
<td><input type="reset" name="重置"/></td>
</tr>
</table>
</fieldset>
</form>
</body>
</html>