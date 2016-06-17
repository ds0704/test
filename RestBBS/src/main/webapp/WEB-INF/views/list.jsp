<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp" %>
<h1>
	목록  
</h1>
	<table class="table">
		<thead>
			<th>no</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
		</thead>
		<tbody>
			<c:forEach items="${rest_list}" var="rest_list">
				<tr>
					<td>${rest_list.getBoard_no()}</td>
					<td><a href="/rest/${rest_list.getBoard_no()}">${rest_list.getTitle()}</a>[${rest_list.getReply_cnt()}]</td>
					<td>${rest_list.getUser_name()}</td>
					<td>${rest_list.getRegdate()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<input type="button" onclick="writea()" value="글쓰기">
	

<script type="text/javascript">
	function writea(){
		location.href="/rest/new";
	}
</script>
<%@ include file="./include/footer.jsp" %>
