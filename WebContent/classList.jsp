<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function deleteClass(classId){
		if(confirm("确定删除这条记录吗")){
			$.post("aclass!delete",{c_id:classId},function(result){
				var result=eval('('+result+')');
				if(result.error){		
					alert(result.error);
				}else{
					alert("删除成功");
					window.location.href="${pageContext.request.contextPath}/aclass!list";
				}
			});
		}
	}
</script>
</head>
<body>
<div class="querydiv">
 <form method="post" action="aclass!list">
	年级：<input type="text" name="major.grade" value="${major.grade}"/>
	班级名称：<input type="text" name="major.className" value="${major.className}"/>
	<button type="submit" class="btn btn-primary">查询</button>
 </form>
</div>
<div class="adddiv">
<button type="button" clas
s="btn btn-primary" onclick="javascript:window.location='aclass!preSave'">添加班级信息</button>
</div>
<table class="table">
  <tr>
  	<th>序号</th>
  	<th>年级</th>
  	<th>班级名称</th>
  	<th>学生人数</th>
  	<th>操作</th>
  </tr>
  <c:forEach var="stuClass" items="${classList}">
  <tr>
  	<td>${stuClass.id}</td>
  	<td>${stuClass.grade}</td>
  	<td>${stuClass.className}</td>
  	<td>${stuClass.stuAmount}</td>
  	<td>
  		<button type="button" class="btn btn-primary" onclick="javascript:window.location='aclass!preSave?c_id=${stuClass.id}'">修改</button>&nbsp;&nbsp;
  		<button type="button" class="btn btn-default" onclick="deleteClass('${stuClass.id}')">删除</button>
  	</td>
  </tr>
  </c:forEach>
</table>
</body>
</html>