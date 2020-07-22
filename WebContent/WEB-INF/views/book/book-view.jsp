<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/book/update" id="fm">
<input type="hidden" name="b_num" value="${book.b_num}">
<table border="1">
	<tr>
		<th>번호</th>
		<td>${book.b_num}</td>
	</tr>
	<tr>
		<th>도서명</th>
		<td><input type="text" name="b_title" value="${book.b_title}"></td>
	</tr>
	<tr>
		<th>저자</th>
		<td><input type="text" name="b_author" value="${book.b_author}"></td>
	</tr>
	<tr>
		<th>기타</th>
		<td><input type="text" name="b_dmc" value="${book.b_dmc}"></td>
	</tr>
	<tr>
		<th>출판일</th>
		<td>${book.b_credat}</td>
	</tr>
	<tr>
		<th colspan="2"><button>수정</button><button type="button" onclick="doDelete()">삭제</button></th>
	</tr>
</table>
</form>
<script>
function doDelete(){
	var formObj = document.querySelector('#fm');
	formObj.action='/book/delete';
	formObj.submit();
}
</script>
</body>
</html>