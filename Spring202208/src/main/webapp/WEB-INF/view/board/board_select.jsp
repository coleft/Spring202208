<%@page import="kr.jobtc.springboot.board.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
게시판 조회.
<%
List<BoardVo> list = (List<BoardVo>)request.getAttribute("list");
out.print("<ol>");
for(BoardVo v : list){
	out.print("<ul>");
	out.print("	<li>" + v.getSno() + "/" + v.getId() + " / " + v.getSubject());
	out.print("</ul>");
}

%>
</body>
</html>