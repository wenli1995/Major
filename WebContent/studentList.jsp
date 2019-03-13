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
function deleteStudent(studentId){
	if(confirm("确定删除该记录吗")){
		$.post("student!deleteStudent",{studentId:studentId},function(result){
			var resultStudent=eval('('+result+')');
			if(resultStudent.status=="success"){
				alert("删除成功");
				window.location.href="${pageContext.request.contextPath}/student!list";
			}else{
				alert("删除失败");
			}
		});
	}
}
</script>
</head>
<body>
<div class="querydiv">
 <form method="post" action="student!list">
	籍贯：<input type="text" name="querystudent.birthplace" value="${querystudent.birthplace}"/>
	性别：<input type="text" name="querystudent.sex" value="${querystudent.sex}" />
	姓名：<input type="text" name="querystudent.stuName" value="${querystudent.stuName}"/>
	班级： <select name="querystudent.major.id">
			<option value="0">请选择...</option>
			<c:forEach var="s_class" items="${selectClassList}">
				<option value="${s_class.id }" ${s_class.id==querystudent.major.id?'selected':''}>${s_class.className }</option>
			</c:forEach>
		</select>
	年级：<input type="text" name="querystudent.major.grade" value="${querystudent.major.grade}"/>
	<button type="submit" class="btn btn-primary">查询</button>
 </form>
</div>
<div class="adddiv">
<button type="button" class="btn btn-primary" onclick="javascript:window.location='student!preSave'">添加学生信息</button>
</div>
<table class="table">
  <tr>
  	<th>序号</th>
  	<th>籍贯</th>
  	<th>性别</th>
  	<th>姓名</th>
  	<th>班级</th>
  	<th>年级</th>
  </tr>
  <c:forEach var="student" items="${studentList}" varStatus="status">
  <tr>
  	<td>${status.index+1}</td>
  	<td>${student.birthplace}</td>
  	<td>${student.sex}</td>
  	<td>${student.stuName}</td>
  	<td>${student.major.className}</td>
  	<td>${student.major.grade}</td>
  	<td>
  		<button type="button" class="btn btn-primary" onclick="javascript:window.location='student!preSave?studentId=${student.id}'">修改</button>&nbsp;&nbsp;
  		<button type="button" class="btn btn-default" onclick="deleteStudent(${student.id})">删除</button>
  	</td>
  </tr>
  </c:forEach>
</table>
</body>
</html>