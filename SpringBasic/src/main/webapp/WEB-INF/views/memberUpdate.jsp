<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>멤버등록</title>
</head>
<body>
<h1>
	멤버등록
</h1>
<form action="/spring/member" method="post">
<input type="hidden" name="CRUD" value="Update">
<table>
	<tr>
		<th>아이디</th>
		<td><input type="text" name="user_id" value="${memberVO.getUser_id()}"></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" name="user_name" value="${memberVO.getUser_name()}"></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="text" name="pw" value="${memberVO.getPw()}"></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><input type="text" name="email" value="${memberVO.getEmail()}"></td>
	</tr>
	
</table>
<input type="submit" value="등록">
</form>
</body>
</html>
