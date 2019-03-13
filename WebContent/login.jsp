<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登陆</title>
<link href="${pageContext.request.contextPath}/style/all.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-responsive.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap3/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.js"></script>
<script type="text/javascript">
	function checkForm(){
		var loginName=document.getElementById("loginName").value;
		var loginPsw=document.getElementById("loginPsw").value;
		if(loginName==""||loginName==null){
			alert("请输入用户名!");
			return false;
		}
		if(loginPsw==""||loginPsw==null){
			alert("请输入密码!");
			return false;
		}
		return true;
	}
	
	function reset(){
		document.getElementById("loginName").value="";
		document.getElementById("loginPsw").value="";
	}
	
</script>
</head>
<body>
<div class="logindiv">
<form  method="post" action="manager!login" onsubmit="return checkForm()">
	<div class="block">
		<label class="title" >用户登录</label>
	</div>
	<div class="block">
		<div><label>用户名:</label></div>
		<input type="text" id="loginName" name="user.userName" /></br>
	</div>
	<div class="block">
		<div><label>密  码:</label></div>
		<input type="password" id="loginPsw"  name="user.password" />
	</div>
	<div ><label style="color:red">${error}</label></div>
	<div class="block">
		<button type="submit" class="btn btn-primary">登录</button>&nbsp;&nbsp;
		<button type="button" class="btn btn-default" onclick="reset()">重置</button>
	</div>
</form>
</div>
</body>
</html>