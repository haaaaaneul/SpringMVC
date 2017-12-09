<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<title>Main Home</title>
</head>
<body>
<br><br><br>
<center>
	<table class="type1">
	<thead>
		<tr>
			<td> MAIN MENU </td>
		</tr>
	</thead>
	
	<tr>
		<td>
			<a href="${pageContext.request.contextPath}/creditbysemester"> 학기별 이수 학점 조회</a>
		</td>
	</tr>
	
	<tr>
		<td>
			<a href="${pageContext.request.contextPath}/creditbyclassification">이수 구분별 학점조회</a>
		</td>
	</tr>
	
	<tr>
		<td>
			<a href="${pageContext.request.contextPath}/addlecture">수강신청하기</a>
		</td>
	</tr>
	
	<tr>
		<td>
			<a href="${pageContext.request.contextPath}/searchlecture">수강신청 조회</a>
		</td>
	</tr>
	
</table>
<br>
	<c:if test="${pageContext.request.userPrincipal.name != null}"> <!-- 누군가가 로그인 되어있을 때 -->
		<a href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>


	<form id="logout" action="<c:url value="/logout"/>" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>

</center>	


</body>

</html>

