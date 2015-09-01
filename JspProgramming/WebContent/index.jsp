<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JspProgramming</title>
		<style type="text/css">
			* {
				margin: 0px;
				padding: 0px;
				<img src
			}
			body{
				width: 800px;
				margin: 0 auto;/* 중앙정렬 */
				background-color: #E6E6E6;
				display: flex;
				flex-direction: row;
			}
			#page-wrapper {
				background-color: #ffffff;
				margin: 40px 0px;
				padding: 10px 20px;
				flex: 1;
			}
			header {
				margin-bottom: 10px;
			}
			nav {
				border-top: 1px solid #C8C8C8;	
				border-bottom: 1px solid #C8C8C8;	
				display: flex;
				flex-direction: row;		
			}
			.menu {
				width: 50px;
				margin: 5px;
				
			}
			#content {
				height: 400px;
				display: flex;
				flex-direction: row;
			}
			
			aside{
			
				height:380px;
				width: 250px;
				overflow: scroll;
				border-right: 1px solid #C8C8C8;
				
			}
			section{
				
				height: 400px;
				flex: 1;
			}
			footer {
			
				height: 50px;
				border-top: 1px solid #C8C8C8;
			}
			#category{
				text-align: center;
				margin-left: 30px;
				
				height:500px;
			}
			
			#category > a{
				border:1px solid white;
				display: block;
				
				text-decoration: none;
				font-style: inherit;
				border-radius:100px 0px 0px 100px;
				background-color: grey;
				font-size: small;
				color:white;
				
				
			}
			#category > a:hover {
				background-color: #C8C8C8;
				font-size: small;
				color:black;
				
			}
		</style>
	</head>
	<body>
		<div id="page-wrapper">
			<header>
				<h1>JspProgramming</h1>
			</header>
			<nav>
				<div class="menu">Menu1</div>
				<div class="menu">Menu2</div>
				<div class="menu">Menu3</div>
				<div class="menu">Menu4</div>
				<div class="menu">Menu5</div>
			</nav>
			<div id="content">
				<aside>
					<div id="category" >
						<p class="chapter">[Ch04:서블릿]</p>
						<a href="HelloWorldServlet1" target="iframe">3.0방식으로 등록</a>
						<a href="HelloWorldServlet2" target="iframe">이전 방식으로 등록</a>
						<a href="HelloWorldServlet3" target="iframe">load on startup</a>
						<a href="HelloWorldServlet4" target="iframe">외부 정보 받기</a>
						<a href="ch04/service_get_post.jsp" target="iframe">요청 방식별 처리</a>
						<a href="LoginServlet" target="iframe">요청 처리 및 응답 보내기</a>
					<a href="LoginServlet" target="iframe">요청 처리 및 응답 보내기</a>
					<a href="LoginServlet" target="iframe">요청 처리 및 응답 보내기</a>
					
								
					
					
						<p class="chapter">[ch05: JSP 기초 문법]</p>
							<a href="ch05/comment.jsp" target="iframe">주석</a>
							<a href="ch05/directives/index.jsp" target="iframe">지시어</a>
							<a href="ch05/action/index.jsp" target="iframe">표준액션
							</a>
							<a href="ch05/scriptlet1.jsp" target="iframe">스크립트릿1</a>
							<a href="ch05/scriptlet2.jsp" target="iframe">스크립트릿2</a>	
							
							
						<p class="chapter">[ch06: JSP 내장 객체]</p>
							<a href="ch06/request_form.html" target="iframe">요청 파라미터 값 받기</a>
							<a href="ch06/request/index.jsp" target="iframe">request</a>
							<a href="ch06/response/index.jsp" target="iframe">response</a>
							<a href="ch06/cookie/index.jsp" target="iframe">cookie</a>
							<a href="ch06/session/index.jsp" target="iframe">session</a>
							<a href="ch06/application/index.jsp" target="iframe">application</a>
							<a href="cart/login.jsp" target="iframe">장바구니</a>
							<a href="twitter/twitter_login.jsp" target="iframe">twitter</a>
						<p class="chapter">[ch10: 표현 언어]</p>
							
						<p class="chapter">[ch11: JSTL]</p>
							<a href="ch11/forEach.jsp" target="iframe">&lt;c:forEach&gt;</a>
	
						<p class="chapter">[ch07: JSP 자바 빈즈]</p>
							<a href="ch07/dto.jsp" target="iframe">DTO 이용 방법</a>
							<a href="ch07/dto_auto_setting.jsp" target="iframe">DTO 값 저장</a>
							<a href="ch07/bean_scope.jsp" target="iframe">빈의 사용 범위</a>
							<a href="ch07/database_form.jsp" target="iframe">데이터베이스 연동</a>
							<a href="ch07/service.jsp" target="iframe">Service 이용 방법</a>
						<p class="chapter">[실습1: 게시판]</p>
							<a href="exam01/list.jsp" target="iframe">게시판 목록</a>
						<p class="chapter">[실습2: 상품 목록 게시판]</p>
							<a href="exam02/list.jsp" target="iframe">상품 목록</a>
						<p class="chapter">[실습3: 게시판]</p>
							<a href="mvc/board?action=list" target="iframe">게시판</a>
					</div>
				</aside>
				<section>
					<iframe name="iframe" width="100%" height="100%" frameborder=0></iframe>	
				</section>
			</div>
			<footer>Lee juheon</footer>
		</div>
	</body>
</html>