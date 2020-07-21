<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 등록</title>
</head>
<body>
<form method="post"action="/book/insert">
<table border="1">
	<tr>
		<th>책이름</th>
		<td><input type="text"name="b_title"></td>
	</tr>
	<tr>
		<th>저자</th>
		<td><input type="text"name="b_author"></td>
	</tr>
	<tr>
		<th>설명</th>
		<td><input type="text"name="b_dmc"></td>
	</tr>
	<tr>
		<th colspan="2"><button>책 추가</button></th>
	</tr>
</table>
</form>
</body>
</html>