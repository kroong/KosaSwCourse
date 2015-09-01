<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h4>실제 경로 얻기</h4>
		<%String infoPath = application.getRealPath("/ch06"); %>
		<%=infoPath %>
	</body>
</html>