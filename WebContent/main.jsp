<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String mainPage=(String)request.getAttribute("mainPage");
	if(mainPage==null||mainPage==""){
		mainPage="default.jsp";
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班级管理系统</title>
<link href="${pageContext.request.contextPath}/style/all.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap3/css/bootstrap-theme.min.css">
<script src="${pageContext.request.contextPath}/bootstrap3/js/jquery-1.11.2.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap3/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid">
<jsp:include  page="common/head.jsp"></jsp:include>
<jsp:include  page="common/menu.jsp"></jsp:include>
<jsp:include  page="<%= mainPage %>"></jsp:include>
<jsp:include  page="common/foot.jsp"></jsp:include>
</div>
</body>
</html>