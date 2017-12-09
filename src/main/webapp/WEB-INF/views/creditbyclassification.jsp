<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<title>강의구분별 학점</title>
</head>
<body>
<center>
<br><br>
	<table class="type1">
		<thead>
			<c:forEach var="lecture" items="${lectures}">
				<th>${lecture.classification}</th>
			</c:forEach>
		</thead>
		
		<tr>				
			<c:forEach var="lecture" items="${lectures}">
				<td>${lecture.credit}</td>
			</c:forEach>
		</tr>
	</table>
	<br>
	<br>
	<a class="page" href="${pageContext.request.contextPath}"> Main</a>

</center>
</body>
</html>