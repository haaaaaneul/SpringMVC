<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<title>학기별 강의 목록</title>
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
			<th>교과코드</th>
			<th>교과목명</th>
			<th>구분</th>
			<th>학점</th>
		</tr>
	</thead>
		<c:forEach var="lecture" items="${lectures}">
			<tr>
				<td>${lecture.year}</td>
				<td>${lecture.semester}</td>
				<td>${lecture.code}</td>
				<td>${lecture.classname}</td>
				<td>${lecture.classification}</td>
				<td>${lecture.credit}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a class="page" href="${pageContext.request.contextPath}"> Main</a> <br>
</center>
</body>
</html>