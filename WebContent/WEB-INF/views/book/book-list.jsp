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
<table border="1">
	<tr>
		<th>책이름</th>
		<th>저자</th>
		<th>작성일</th>
		<th>기타</th>
	</tr>
<c:forEach items='${bookList}' var="book">
	<tr>
		<td><a href="/book/view?b_num=${book.b_num}">${book.b_title}</a></td>
		<td>${book.b_author}</td>
		<td>${book.b_credat}</td>
		<td>${book.b_dmc}</td>
	</tr>
</c:forEach>

</table>
<a href="/views/book/book-insert"><button>책 등록</button></a>
</body>
</html>