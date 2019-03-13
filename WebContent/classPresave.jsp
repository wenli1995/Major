<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="aclass!saveClass">
<p>${title}</p>
 <table>
	<tr>
		<td>年级：</td>
		<td><input type="text" id="grade" name="c_grade" value="${stuClass.grade}"/></td>
	</tr>
	<tr>
		<td>班级名称：</td>
		<td><input type="text" id="className" name="c_className" value="${stuClass.className}"/></td>
	</tr>
	<tr>
		<td>
			<input type="hidden" id="id" name="c_id" value="${stuClass.id}"/>
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