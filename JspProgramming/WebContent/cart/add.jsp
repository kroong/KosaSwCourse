<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>add.jsp</title>
	</head>
	<body>
		<%
			request.setCharacterEncoding("UTF-8");
			String productname=request.getParameter("product");
			ArrayList list=(ArrayList)session.getAttribute("productlist");
			if(list==null){
				list=new ArrayList();
				session.setAttribute("productlist", list);
			}
			list.add(productname);
		%>
		<script>
			alert("<%=productname%>이 추가 되었습니다!!");
			history.go(-1);
		</script>
	</body>
</html>