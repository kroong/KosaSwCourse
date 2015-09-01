<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h4>요청 파라메타값 받기</h4>
		<a href="request_form.html">request_form.html</a>
		
		<h4>[요청 방식]</h4>
		<p>1. get 방식 </p> 
			<ul>
				<li> URL로 직접 입력</li>
				<li> 	
					&lt;a&gt; 방식:
					<a href="ch06/request/getMethod.jsp ?id=white&name=honkildong">getData.jsp</a>
				</li>
				<li> 
					&lt;form method="GET"&gt;
					<form method="GET" action="getMethod.jsp"> 
						아이디: <input type="text" name="id"/><br/>
						이름: <input type="text" name="name"/> <br/>
						<input type="submit" value = "getMethod.jsp"><br/>
					</form>
					</li>
			</ul>
		<p>2. post 방식 </p>
			<ul>
				<li> 
					&lt;form method="post"&gt; :
					<form method="POST" action="getMethod.jsp">
						아이디: <input type="text" name="id"/><br/>
						이름: <input type="text" name="name"/> <br/>
						<input type="submit" value = "getMethod.jsp"><br/>
					</form>
					</li>
			</ul>
			<h4>[클라이언트 IP]</h4>
			<%=request.getRemoteAddr()%>
			<h4>[클라이언트 os 및 브라우저 정보]</h4>
			<%String browser = request.getHeader("User-Agent"); %>
			<%if(browser.indexOf("MSIE")!=-1){ %>
				Internet Explorer 이군요
			<%} else if(browser.indexOf("Chrome")!=-1) {%>
				Chrome 이군요.
			<%} %>
	</body>
</html>