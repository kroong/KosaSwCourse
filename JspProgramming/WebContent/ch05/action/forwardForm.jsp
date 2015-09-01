<%@ page contentType="text/html; charset=UTF-8"%>

<%

String email=request.getParameter("emali");
String id = request.getParameter("id");
String name = request.getParameter("name");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		forward.form
		<hr/>
		
		<form>
			ID: <%=id %> <br/>
			Name: <%=name %> <br/>
			Email: <%=email %> <br/>
		</form>
	</body>
</html>