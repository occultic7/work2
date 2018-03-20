
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>登录页面</title>
<script src="js/gVerify.js"></script>
      
<style type="text/css">
	*{
		margin:0;
		padding:0;
		text-decoration: none;
		box-sizing: border-box;
	
	}
	body{
		margin:0 auto;
		padding:20px ;
		height: 100vh;
		
		background-image: url(images/login4.jpg);
		background-repeat:no-repeat; background-size:100% 100%;
		
		
		 
	}
	#div1{
		
		margin:0 auto;
		width:450px;
		box-sizing: border-box;
		box-shadow:10px 10px 10px black;
		background-color: white;
		
	}
	#container{
		position:relative;
		
		
		width:400px;
		height:300px;
		
	    overflow: hidden;
	    text-align: center;
	    margin:0 auto;
	    background-color:white;
	    
	}
	form {
	  width: 350px;
	  float: left;
	  margin: 25px;
	 
	}

	form table{
		margin:0 auto;
		width: 100%;
	}
		form table tr{
		line-height: 2em;
		margin-top: 30px;
		margin:0 auto;

	}
	form table tr td{
		font-size: 1em;
		text-align: center;
		margin-right: 50px;
	}
	td.tdword{
		width: 120px;
	}
	form input[type="text"],input[type="password"]{
	  width: 80%;
	  border: 2px solid gray;
	  background: none;
	  position: relative;
	  top: 0;
	  left: 0;
	  z-index: 2;
	  padding: 8px 12px;
	  outline: 0;
	  margin:15px;
	}
	form input[type="radio"]{
		margin-right: 30px;
		width:20px;
		height:20px;
	}
	form label{
		margin-right: 20px;
	}
	input[type="submit"] {
	    font-size: 1em;
		background: transparent;
	    border: 3px solid  black;
	    outline: none;
	    cursor: pointer;
	    padding: .6em 1em;
	    -webkit-appearance: none;
	    width: 100%;
		transition: 0.5s all ;
		
		height: 45px;
		

	    
	}
	input[type="reset"]{
		font-size: 1em;
		background: transparent;
	    border: 3px solid   #3e67af;
	    outline: none;
	    cursor: pointer;
	    padding: .6em 1em;
	    -webkit-appearance: none;
	    width: 100%;
		transition: 0.5s all ;
		width:150px;
		height: 45px;
	}
	input[type="submit"]:hover,input[type="reset"]:hover {
	    background: black;
	    border: 3px solid   black;
	    color: white;
	}
	
	h1 {
		font: bold 3em "黑体"; 
	  
	    text-align: center;
	    color:rgba(29,119,130);
	    font-weight: 100;
	    letter-spacing: 3px;
	    margin: 1em 0 0.5em 0;
	}
	 h3{
	    text-align: center;
	    
	    font-size:1.5em;
	    font-weight: 300;
	    text-transform: uppercase;
	    letter-spacing: 3px;
	}
	h2{
		
		
		color: rgba(255,255,255,0.9);
		font-size: 2em;
		letter-spacing: 20px;
		text-align: center;
		background-color: black;
		
	
		
		
	}
	
	
	
	#div2{
		color:black;
		font-size: 0.5em;
		margin-top: 30px;
		text-align: center;
		padding: 10px;
		
	}
        #code{  
            font-family:Arial,宋体;  
            font-style:italic;  
            color:blue;  
            border:0;  
            padding:2px 3px;  
            letter-spacing:3px;  
            font-weight:bolder;  
        } 
		#v_container{
			margin-left:30px;
		
		}
</style>
<script language="JavaScript">
	
	window.onload=function(){
		
		var verifyCode = new GVerify("v_container");

		document.getElementById("my_button").onclick = function(){
			var res = verifyCode.validate(document.getElementById("code_input").value);
			var inputCode = document.getElementById("code_input").value.toUpperCase(); 
			if(res){
				
				return true;
			}else if(inputCode.length <= 0){
			alert("请输入验证码！");
			return false;
			
			
			}
			else{
				alert("验证码错误");
				 document.getElementById("code_input").value = "";//清空文本框  
				return false;
			}
		}
	}
	
	
</script>	


</head>
<body>
					
	<h1>企业仓库管理系统</h1>
	
	<div id="div1">
	
	<h2>用户登录</h2>
<div id="container">
			<form action="/work2/LoginServlet" method="post">
				<table>
					<tr>
						<td class="tdword">账号：</td>
						<td><input name='userno' type='text' value='201511104000' required="required" /></td>
					</tr>
					<tr>
						<td class="tdword">密码：</td>
						<td><input name='password' type='password' value='123' required="required"/></td>

					</tr>
					<tr>
						
						<td><input type="text" id="code_input" value="" placeholder="输入验证码"/> </td>
						<td><div id="v_container" style="width: 105px;height: 35px;"></div></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value ="登录" id="my_button"    /></td>
						
					</tr>

				</table>

			</form>
</div>
</div>
<div id="div2">&copy;Copyright 2017-2018</div>
</body>

</html>