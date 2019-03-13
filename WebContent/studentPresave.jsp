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
</head>
<body>
<form method="post" action="student!saveStudent">
<p>${title}</p>
 <table>
	<tr>
		<td>籍贯：</td>
		<td><input type="text" id="birthplace" name="student.birthplace" value="${student.birthplace}"/></td>
	</tr>
	<tr>
		<td>性别：</td>
		<td><input type="text" id="sex" name="student.sex" value="${student.sex}"/></td>
	</tr>
	<tr>
		<td>姓名：</td>
		<td><input type="text" id="stuName" name="student.stuName" value="${student.stuName}"/></td>
	</tr>
	<tr>
		<td>班级：</td>
		<td>
		 <select name="student.major.id">
			<option value="0">请选择...</option>
			<c:forEach var="s_class" items="${selectClassList }">
				<option value="${s_class.id }" ${s_class.id==student.major.id?'selected':'' }>${s_class.grade} ${ s_class.className}</option>
			</c:forEach>
		</select>
		</td>
	<tr>
		<td>
			<input type="hidden" id="id" name="studentId" value="${student.id}"/>
			<button type="submit" class="btn btn-primary">提交</button>
		</td>
		<td>
			<button type="button" class="btn btn-default" onclick="javascript:history.back()">返回</button>
		</td>
	</tr>
 </table>
</form>
</body>
</html>