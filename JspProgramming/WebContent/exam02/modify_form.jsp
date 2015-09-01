<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="dto.*" %>
<%
int productNo=Integer.parseInt(request.getParameter("product_no"));
%>

<jsp:useBean id="productService" 
class="service.ProductService" 
scope="application">
</jsp:useBean>

<%Product product=productService.getProduct(productNo);%>
<!DOCTYPE html>
	<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			body{
				font-family: "돋움";
				font-size: 12px;
			} 
			span{
				display:inline-block;
				margin:2px 10px;
			}
			span.title{
				margin:2px 10px;
				border:1px solid darkgray;
				background: lightgray;
				width:70px;
				text-align: center;
			}
			pre{
				margin:10px;
				border:1px solid darkgray;
				padding:10px;
				height:100px;
				width:300px;
				font-size: 12px;
			}
		</style>
		<script type="text/javascript">
			function sendData(){
				//값의 유효성 검사
				//var modifyForm=document.querySelector("#modifyForm");
				var modifyForm =document.modifyForm;
				console.log(modifyForm);
				
				//var title=document.querySelector("#title");
				var name=document.modifyForm.name;
				console.log(name);
				
				var price=document.modifyForm.price;
				
				var stock=document.modifyForm.stock;
				
				var detail=document.modifyForm.detail;
				
				if (name.value== "") {
					alert("이름이 있어야 합니다.")
					return;
				} else if (price.value== ""){
					alert("가격이 있어야 합니다.")
					return;
				} else if (stock.value=="") {
					alert("재고량이 있어야 합니다.")
					return;
				} else if (detail.value=="") {
					alert("세부정보가 있어야 합니다.")
					return;
				}
				
				//서버로 전송
				modifyForm.submit();
			}
		</script>
	</head>
	
	<body>
		<h4>게시물 보기</h4>
		<form id="modifyForm" name="modifyForm" method="post" action="modify.jsp">
			<span class="title">번호 :</span>
			<span class="content"> <%=product.getNo()%></span>
			<input type="hidden" name="no" value="<%=product.getNo()%>"/>
			<br/>
			<span class="title">이름 :</span>
			<input id="name" type="text" name="name" value="<%=product.getName()%>"/><br/>
			<span class="title">가격 :</span>
			<input id="price" type="number" step="100" min="500" max="999999" : name="price" value="<%=product.getPrice()%>"/><br/>
			<span class="title">재고 :</span>
			<input id="stock" type="number" min="1" max= "999" name="stock" value="<%=product.getStock()%>"/><br/>
			<span class="title">상세정보 :</span> <br/>
			<textarea name="detail" cols="30" rows="5"><%=product.getDetail() %></textarea>
		</form>
		<div id="buttonGroup">
			<a href="javascript:sendData()">[수정]</a>
			<a href="detail.jsp?product_no=<%=product.getNo()%>">[취소]</a>
		</div>
	</body>
</html>