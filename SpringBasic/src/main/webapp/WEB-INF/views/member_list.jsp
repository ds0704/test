<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>멤버목록</title>
</head>
<body>
	<h1>멤버목록</h1>
	
	
		<table>
			<thead>
				<th>id</th>
				<th>pw</th>
				<th>name</th>
				<th>email</th>
				<th>date</th>
				<th>수정</th>
				<th>삭제</th>
			</thead>
			<tbody>
				<c:forEach items="${member_list}" var="member_list">
					<tr>
						<td>${member_list.getUser_id()}</td>
						<td>${member_list.getPw()}</td>
						<td>${member_list.getUser_name()}</td>
						<td>${member_list.getEmail()}</td>
						<td>${member_list.getRegdate()}</td>
						<td><form action="/spring/memberUpdate" method="post">
								<input type="hidden" name="user_id" value="${member_list.getUser_id()}">
								<input type="submit" value="수정">
							</form>
						</td>
						<td><form action="/spring/member" method="post">
								<input type="hidden" name="CRUD" value="Delete">
								<input type="hidden" name="user_id" value="${member_list.getUser_id()}">
								<input type="submit" value="삭제">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<input type="button" value="글쓰기" onclick="a()">
	
</body>
<script type="text/javascript">
	function a(){
		location.href = "/spring/memberWrite";
	}
</script>
</html>