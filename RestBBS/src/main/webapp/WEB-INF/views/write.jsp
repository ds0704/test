<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp" %>
<h1>
	글쓰기 
</h1>

<form action="/rest/" method="post">
이름
<input type="text" name="user_name"><br>
제목
<input type="text" name="title"><br>
내용<br>
<textarea rows="4" cols="20" name="content"></textarea><br>
<input type="submit" value="등록">
</form>

<%@ include file="./include/footer.jsp" %>
