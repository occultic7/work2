<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String auserno=(String)session.getAttribute("AUserNo");int atype=(Integer)session.getAttribute("Atype");if(auserno==null||auserno.equals("")||atype!=1) {response.sendRedirect("index.jsp");}%>
<html>
	<head>
		<meta charset="utf-8" />
		<title>管理系统</title>
		<style type="text/css">
			@font-face{font-family:'ZoomlaXingtiJ6';
					src: url('http://code.z01.com/font/ZoomlaXingtiJ6.eot?#iefix'); /* IE9 */
					src: url('http://code.z01.com/font/ZoomlaXingtiJ6.eot?#iefix') format("embedded-opentype"), /* IE6-IE8 */
					url('http://code.z01.com/font/ZoomlaXingtiJ6.woff') format("woff"), /* chrome、firefox */
					url('http://code.z01.com/font/ZoomlaXingtiJ6.ttf') format("truetype"), /* chrome、firefox、opera、Safari, Android, iOS 4.2+ */
					url('http://code.z01.com/font/ZoomlaXingtiJ6.svg#ZoomlaXingtiJ6') format("svg"); /* iOS 4.1- */
					font-style: normal; font-weight: normal;}
			*{
				margin: 0;
				padding: 0;
				box-sizing: border-box;
				text-decoration: none;
			}
			body{
				width:100%;
				min-width: 900px;
				
			}
			header{
				margin: 0 auto;
				width:100%;
				height:10%;
				 background-color: black;
				box-shadow: 1px 5px 5px black;


			}
			#hcontent{
				
				margin:0 auto;
				padding-top: 10px;
				color: rgb(253,75,3);

				
			}
			#hcontent img{
				margin-left:20px;
				width: 45px;
				height: 45px;
				
				float: left;
			}
			#name{
				float: left;
				text-align: center;
				margin-left: 10px;
				margin-top:10px;
			}
			.p2{
				background: url('') no-repeat 10px 8px;
	            display: inline-block;
	            vertical-align: middle;
	            padding-left: 50px;
	            color: #fff;
			}
			
			#exist{
				float:right;
				margin-top:10px;
			}

			#exist a,span{

				font-size:15px ;
				color: white;
			}
			#exist a:hover{
				color: rgb(253,75,3);
				text-shadow: 1px 1px 1px black;
			}
			#all{
				background-color: rgb(241,245,231);
				width: 100%;
				height: 85%;
			}
			aside{
				width: 18%;
				height: 100%;
				padding: 15px;
				background-color: white;
				float: left;
				
			}
			aside ul{
				list-style: none;
				text-align: center;
				
			}
			aside ul li{
				margin-bottom: 4px;

			}
			aside ul li a{
				display: block;
				padding: 10px 8px;
                font-size: 12px;
                font-weight: 600;
                color: #4A515B;
                background: #E9E9E9;
                background: -moz-linear-gradient(top, #FAFAFA 0%, #E9E9E9 100%);
                background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#FAFAFA), color-stop(100%,#E9E9E9));
                background: -webkit-linear-gradient(top, #FAFAFA 0%,#E9E9E9 100%);
                background: -o-linear-gradient(top, #FAFAFA 0%,#E9E9E9 100%);
                background: -ms-linear-gradient(top, #FAFAFA 0%,#E9E9E9 100%);
                background: linear-gradient(top, #FAFAFA 0%,#E9E9E9 100%);
                filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#FAFAFA', endColorstr='#E9E9E9');
                -ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr='#FAFAFA', endColorstr='#E9E9E9')";
                border: 1px solid #D5D5D5;
                border-radius: 4px;
                text-align: left;
			}

			aside ul li a:hover{
					color: #FFF;
                    background: #3C4049;
                    background: -moz-linear-gradient(top, #4A515B 0%, #3C4049 100%);
                    background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#4A515B), color-stop(100%,#3C4049));
                    background: -webkit-linear-gradient(top, #4A515B 0%,#3C4049 100%);
                    background: -o-linear-gradient(top, #4A515B 0%,#3C4049 100%);
                    background: -ms-linear-gradient(top, #4A515B 0%,#3C4049 100%);
                    background: linear-gradient(top, #4A515B 0%,#3C4049 100%);
                    filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#4A515B', endColorstr='#3C4049');
                    -ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr='#4A515B', endColorstr='#3C4049')";
                    border-color: #2B2E33; 
			}
			iframe{
				width: 82%;
				height: 100%;
				float: right;
				overflow: hidden;
				background-color: white;
			}
			footer{
				float: left;
				width: 100%;
				height: 5%;
				text-align: center;
				padding-top: 10px;
				font-family:;
				color: #f5f5f5;
				background-color:black;
				font-size:0.5em;
			}
			ul.unvisible{
				display:none;
			}
			ul.visible{
				display: block;
				
			}
			#sul1,#sul2,#sul3,#sul4{
				background-color: white;
			}
			#sul1 li a,#sul2 li a,#sul3 li a,#sul3 li a,#sul4 li a{
				display: block;
				font-size: 12px;
            	color: #4A515B;
           		text-align: center;
           		background: white;
           		padding: 10px 8px;

			}
			#sul1 li a:hover,#sul2 li a:hover,#sul3 li a:hover,#sul4 li a:hover{
				display: block;
				
                background: #E9E9E9;
                background: -moz-linear-gradient(top, #FAFAFA 0%, #E9E9E9 100%);
                background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#FAFAFA), color-stop(100%,#E9E9E9));
                background: -webkit-linear-gradient(top, #FAFAFA 0%,#E9E9E9 100%);
                background: -o-linear-gradient(top, #FAFAFA 0%,#E9E9E9 100%);
                background: -ms-linear-gradient(top, #FAFAFA 0%,#E9E9E9 100%);
                background: linear-gradient(top, #FAFAFA 0%,#E9E9E9 100%);
                filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#FAFAFA', endColorstr='#E9E9E9');
                -ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr='#FAFAFA', endColorstr='#E9E9E9')";
                
                border-radius: 4px;
               border-color: #E9E9E9; 
				
			}
		</style>
		<script language="JavaScript">
			var lastId="";
			function show(ele){
				var obj=document.getElementById(ele);
				if(obj.className.toLowerCase()=="visible")
				obj.className="unvisible";
				else
				obj.className="visible";
				if((lastId!="")&&(ele!=lastId)){
					document.getElementById(lastId).className="unvisible";
				}
				lastId=ele;
			}
		</script>
	</head>
	<body>
		<header>
			<div id="hcontent">
				<img src="images/logo.png" />
				<div id="name">
					<p  class="p2">仓库管理系统（管理员端）</p>
				</div>
				<div id="exist">
					<a>欢迎您，<%=auserno %></a>&nbsp;<span>|</span><a href="exit.jsp">退出</a>
				</div>
				
			</div>
		</header>
		<div id="all">
		<aside>
			<ul>
				<li>
					<a href="#" onclick="show('sul2')">库存信息</a>
					<ul class="unvisible" id="sul2">
						<li><a href="GetAllStockServlet" target="iframe2">全部库存信息</a></li>
						<li><a href="GetStockByGood.jsp" target="iframe2">模糊查询</a></li>
					</ul>
				</li>
				<li>
					<a href="#" onclick="show('sul1')">合同信息</a>
					<ul class="unvisible" id="sul1">
						<li><a href="GetAllContractsServlet" target="iframe2">全部合同信息</a></li>
						<li><a href="GetContractsByDate.jsp" target="iframe2">供应记录</a></li>
					</ul>
				</li>
				<li>
					<a href="#" onclick="show('sul3')">出库信息</a>
					<ul class="unvisible" id="sul3">
						<li><a href="GetAllStockOutServlet" target="iframe2">全部出库信息</a></li>
						<li><a href="GetStockOutByDateOrGood.jsp" target="iframe2">模糊查询1</a></li>
						<li><a href="GetStockOutByDateOrUser.jsp" target="iframe2">模糊查询2</a></li>
						<li><a href="GetStockOutByOutNo.jsp" target="iframe2">模糊查询3</a></li>
						<li><a href="GetStockOutNew.jsp" target="iframe2">统计出库记录</a></li>
					</ul>
				</li>
				<li>
					<a href="#" onclick="show('sul4')">入库信息</a>
					<ul class="unvisible" id="sul4">
						<li><a href="GetAllStockInServlet" target="iframe2">全部入库信息</a></li>
						<li><a href="GetStockInByDateOrGood.jsp" target="iframe2">模糊查询1</a></li>
						<li><a href="GetStockInByDateOrUser.jsp" target="iframe2">模糊查询2</a></li>
					</ul>
				</li>
				
			</ul>
		</aside>
		<iframe name="iframe2" src="GetAllStockServlet" scrolling="yes" frameborder="no"></iframe>
		</div>
		<footer>
			山东建筑大学&nbsp;&copy;Copyright 2017-2018
		</footer>
	</body>
</html>