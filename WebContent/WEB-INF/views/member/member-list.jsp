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
		<th>이름</th>
		<th>아이디</th>
		<th>패스워드</th>
		<th>가입일</th>
	</tr>
<c:forEach items='${memberList}' var="member">
	<tr>
		<th>${member.m_name}</th>
		<th><a href="/member/view?m_num=${member.m_num}">${member.m_id}</a></th>
		<th>${member.m_pwd}</th>
		<th>${member.m_joindate}</th>
	</tr>
</c:forEach>
</table>
<a href="/views/member/member-insert"><button>회원추가</button>
</body>
</html>