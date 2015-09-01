<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			table{
				width:100%;
				border-collapse:collapse;
				font-size: small;
			}
			
			table, th, td{
				border : 1px solid black;
				text-align:center;
				
			}
			
			th{
				background-color: #B2EBF4;
			}
			#buttonGroup{
				text-align:center;
				margin:10px;
			}
			
			#pager {
				font-size : small;
				margin-top : 5px;
				text-align: center;
			}
		</style>
	</head>
	
	<body>
		<h4>게시물 목록</h4>
		<table>
			<tr>
				<th style="width:60px">번호</th>
				<th>제목</th>
				<th style="width:80px">글쓴이</th>
				<th style="width:90px">날짜</th>
				<th style="width:70px">조회수</th>
			</tr>
			
			<c:forEach var="board" items="${list}">
			<tr>
				<td>${board.no}</td>
				<td>${board.title}</td>
				<td>${board.writer}</td>
				<!--  삼항 연산자 -->
				<td>${board.date}</td>
				<td>${board.hitcount}</td>
			</tr>
			</c:forEach>
		</table>
		

		<div id="buttonGroup">
			<a href="/JspProgramming/mvc/board?action=writeForm">
				<img src="../common/images/board/write.gif"/>
			</a>
		</div>
	</body>
</html>