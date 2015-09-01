<%@ page contentType="text/html; charset=UTF-8"%>


<%
request.setCharacterEncoding("UTF-8");
String username = request.getParameter("username");
String title = request.getParameter("title");
String content = request.getParameter("content");
String gender=request.getParameter("gender");
String open=request.getParameter("open");
String password=request.getParameter("password");

%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		제목:<%=title %><br/>
		글쓴이:<%=username %><br/>
		내용:<%=content %><br/>
		성별:<%=gender %><br/>
		공개여부:<%=open %><br/>
		비밀번호:<%=password %>
	</body>
</html>