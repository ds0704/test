<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp" %>
<h1>
	글읽기 
</h1>

<table class="table">
	<tr>
		<th>제목</th>
		<td>${vo.title}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${vo.user_name}</td>
	</tr>
	<tr>
		<th>날짜</th>
		<td>${vo.regdate}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${vo.content}</td>
	</tr>
</table>

<form action="/rest/${vo.board_no}" method="post">
	<input type="hidden" id="_method" name="_method" value="delete">
	<input type="submit" class="btn btn-primary" value="삭제">
	<input type="button" class="btn btn-info" id="list" onclick="lista()" value="목록">
</form>


<h3>덧글</h3>

<div id="reply_list"></div>
<div id="reply_page"></div>

<form id="reply">
	<input type="hidden" id="board_no" name="board_no" value="${vo.board_no}">
	<input type="text" id="content" name="content" size="50">
	<input type="text" id="user_name" name="user_name" size="10">
	<input type="button" class="btn btn-primary" id="reply_submit" onclick="setReply()" value="등록">
</form>
<input type="button" class="btn btn-info" id="list" onclick="lista()" value="목록">
<script type="text/javascript">
	var currentPage = 1;
	var startPage = 1;
	var endPage = 1;
	var totalPage;
	function lista(){
		location.href="/rest";
	}
	
	function setReplyList(data){
		var a = document.getElementById("reply_list");
		var result = "<ul>"
		
		$(data).each(function(){
			result+="<li>" 
					+ this.user_name
					+ "</br>" 
					+ this.content
					+ '<input type="button" class="btn btn-primary" onclick="deleteReply(\'' + this.reply_no + '\')" value="삭제">'
					+ "</li>";
		});
		
		result+="</ul>";
		a.innerHTML = result;
	}
	
	function setPagePrint(pm){
		var str = "";
		
		if(currentPage > pm.endPage && currentPage > 1){
			getReplyList(currentPage-1);
		}
		
		
		str += "<ul class='pagination'>";
		
		if(pm.prev){
			str += "<li><a href='javascript:getReplyList("+(pm.startPage-1)+")'>&lt;</a> </li>"
		}
		
		for(var i = pm.startPage; i<=pm.endPage; i++){
			if(i == pm.criteria.page){
				str+="<li class='active'><a href='#'>" + i + "</a></li>"
			}else{
				str+="<li><a href='javascript:getReplyList("+i+")'>" + i + "</a></li>"
			}
			
		}
		
		
		if(pm.next){
			str += "<li><a href='javascript:getReplyList("+(pm.endPage+1)+")'>&gt;</a> </li>"
		}
		str += "</ul>";
		document.getElementById("reply_page").innerHTML = str;
		
	}
	
	function getReplyList(page){
		
		if(page==null){
			page = currentPage; 
		}
		currentPage = page;
		
		$.ajax({
			type : 'get',
			url : '/reply/${vo.board_no}/'+page,
			headers : {
				"Content-Type" : "application/json"
//				"X-HTTP-Method-Override" : "GET",
			},
			dataType : 'json',
			data : '',
			success : function(result){
				endPage = result.p.endPage; 
				startPage = result.p.startPage;
				if(totalPage<result.p.totalPage){
					getReplyList(result.p.totalPage);
				}
				totalPage = result.p.totalPage;
				
				setReplyList(result.l);
				setPagePrint(result.p);
				
			}
		});
		
	}
	getReplyList(currentPage);
	
	function setReply(){
		
		var reply_user_name = $("#user_name").val();
		var reply_content = $("#content").val();
		
		
		$.ajax({
			type : 'post',
			url : '/reply/${vo.board_no}',
			headers : {
				"Content-Type" : "application/json; charset=utf-8"
//				"X-HTTP-Method-Override" : "POST",
			},
			data : JSON.stringify({
				"user_name" : reply_user_name,
				"content" : reply_content
			}),
			success : function(result){
				if(result == "SUCCESS"){
					
					getReplyList(totalPage);
				}
			}
		});
		console.log($("#reply").get(0));
		$("#reply").get(0).reset();
		
	}

	function deleteReply(reply_no){
		
		$.ajax({
			type : 'delete',
			url : '/reply/'+reply_no,
			headers : {
				"Content-Type" : "application/json; charset=utf-8"
			//	"X-HTTP-Method-Override" : "DELETE"
			},
			success : function(result){
				if(result == "SUCCESS"){
					getReplyList(currentPage);
				}
			}
		});
		
	}
</script>

<%@ include file="./include/footer.jsp" %>