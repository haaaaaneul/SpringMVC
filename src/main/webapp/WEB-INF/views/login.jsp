<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<title>Login</title>
</head>
<body onload='document.f.username.focus();'>
<br><br><br>
<center>
	<h3>Login</h3>
	
	<c:if test="${not empty erroMsg}">
				<div style="color:#0000FF"> <h3>${logoutMsg}
				 </h3> </div>
	</c:if>
	
		<form name='f' action="<c:url value="/login"/>" method='POST'>

			<c:if test="${not empty erroMsg}">
				<div style="color:#FF0000"> <h3>${errorMSg} </h3> </div>
			</c:if>
					<h3>${errorMsg}</h3>
					
				
				<table class="type1">
					<tr>
						<th scope="row"> User </th>
						<td><input type='text' name='username' value=''></td>
					</tr>
					<!-- name='username' 과 name='password' (default값들임) 은 security-context 파라미터값과 일치해야함  -->
					<tr>
						<th scope="row"> Password </th>
						<td><input type='password' name='password' /></td>
					</tr>

					
				</table>
				<br><br>
				<input name="submit" type="submit" value="Login" />

				<input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}" />
		</form>
	</center>
</body>
</html>