<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<title>학기별 학점</title>
</head>

<body>
<center>
<br>
<br>
	<table class="type1">
		<thead>
		<tr>
			<th>년도</th>
			<th>학기</th>
			<th>이수학점</th>
			<th>상세보기</th>
		</tr>
		</thead>
		<c:forEach var="lecture" items="${lectures}">
			<tr>
				<td> ${lecture.year} </td>
				<td> ${lecture.semester} </td>
				<td> ${lecture.credit} </td>
				<td> <a href="${pageContext.request.contextPath}/lecturesbysemester?year=${lecture.year}&semester=${lecture.semester}"> 학기별 수강과목 </a> </td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<a class="page" href="${pageContext.request.contextPath}"> Main</a>
</center>
</body>
</html>