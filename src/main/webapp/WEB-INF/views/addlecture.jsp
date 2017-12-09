<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<title>수강신청</title>
</head>
<body>
<br><br><br><br>
<center>

	<sf:form method="get" action="${pageContext.request.contextPath}/addinglecture" modelAttribute="lecture">
		<table class="type1">
			<tr>
			 <th scope="row" class="label"> 년도 </th>
			 <td>
				<select class="select" name="year">
					<option value="2018">2018</option>
				</select>
				</td>
			</tr>
			
			<tr>
				<th scope="row" class="label"> 학기 </th>
				<td>
				<select class="select" name="semester">
					<option value="1">1</option>
				</select>
				</td>
			</tr>
			
			<tr>
				<th scope="row" class="label"> 과목코드 </th>
				<td><sf:input path="code" type="text"/><br>
				<sf:errors cssClass="error" path="code"></sf:errors></td>
			</tr>
			
			<tr>
				<th scope="row" class="label"> 과목명 </th>
				<td><sf:input path="classname" type="text"/><br>
				<sf:errors cssClass="error" path="classname"></sf:errors></td>
			</tr>
			
			<tr>
				<th scope="row" class="label"> 구분 </th>
				<td>
				<sf:select class="select" path="classification">
					
					<sf:option value="교필">교필</sf:option>
					<sf:option value="핵교A">핵교A</sf:option>
					<sf:option value="핵교B">핵교B</sf:option>
					<sf:option value="일교">일교</sf:option>
					<sf:option value="전기">전기</sf:option>
					<sf:option value="전지">전지</sf:option>
					<sf:option value="전선">전선</sf:option>
					
				</sf:select>
				</td>
			</tr>
			
			<tr>
				<th scope="row" class="label"> 학점 </th>
				<td>
				<sf:select class="select" path="credit">
					<sf:option value="1">1</sf:option>
					<sf:option value="2">2</sf:option>
					<sf:option value="3">3</sf:option>
				</sf:select>
				</td>
			</tr>
			
		
			
		</table>
		<input value="신청" type="submit"/>
	</sf:form>
	
	<br><br>
	<a class="page" href="${pageContext.request.contextPath}"> Main</a>
	
</center>
</body>
</html>