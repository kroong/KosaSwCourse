<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="dto.*,java.util.*" %>

<%
int pageNo = 1;
String strPageNo = request.getParameter("pageNo");
if(strPageNo != null) {
	//pageNo가 전달되었을 경우
	pageNo = Integer.parseInt(strPageNo);
}
%>
<jsp:useBean id="productService" 
class="service.ProductService" 
scope="application">
</jsp:useBean>

<%
List<Product> list=productService.getPage(pageNo,productService.getRowsPerPage());
%>

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
			#pager a{
				text-decoration: none;
				color:
			}
		</style>
	</head>
	
	<body>
		<h4>게시물 목록</h4>
		<table>
			<tr>
				<th style="width:30px">번호</th>
				<th style="width:50px">이름</th>
				<th style="width:30px">가격</th>
				<th style="width:30px">재고</th>
				<th style="width:150px">상세정보</th>
			</tr>
			<%for(Product product : list) {%>
			<tr>
				<td><%=product.getNo()%></td>
				<td><a href="detail.jsp?product_no=<%=product.getNo()%>"><%=product.getName()%></a></td>
			 	<td><%=product.getPrice()%></td>
				<td><%=product.getStock()%></td> 
				<td><%=(product.getDetail().length()>20)?product.getDetail().substring(0,20):product.getDetail()%></td>
				<!--  삼항 연산자 -->
			</tr>
			<%} %>
		</table>
		
		<div id = "pager">
			<%
			int groupNo = productService.getGroupNo(pageNo);
			%>
			<a href= "list.jsp?pageNo=1">[처음]</a>
			<% if(groupNo>1) {%>
			<a href= "list.jsp?pageNo=<%=productService.getStartPageNo(groupNo-1)%>">[이전]</a>
			<%} %> 
			
			<% for(int i=productService.getStartPageNo(groupNo); 
					i<=productService.getEndPageNo(groupNo); i++) {%>
				<a href="list.jsp?pageNo=<%=i %>"><%=i %></a>
			<%}%>
			
			<%if(groupNo<productService.getTotalGroupNo()) {%>
				<a href="list.jsp?pageNo=<%=productService.getStartPageNo(groupNo+1)%>">[다음]</a>
			<%}%>
			<a href="#"><[맨끝]</a>
		</div>
		<div id="buttonGroup">
			<a href="write_form.jsp"><img src="../common/images/board/write.gif"/></a>
		</div>
	</body>
</html>