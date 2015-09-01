<%@ page contentType="text/html; charset=UTF-8"%>
<%-- 선언문(JSP가 클래스로 변화될 때 필드와 메소드가 될 부분) --%>
<%!
	//필드 선언
	int num1,num2=0;
	int result =0;
	String op="";
	
	//연산자별 처리를 위한 메서드 선언
	public int calculator(){
		if(op.equals("+")){
			result=num1+num2;
			
		}else if(op.equals("-")){
			result=num1-num2;
		}else if (op.equals("/")){
			result=num1/num2;
		}
		return result;
	}
%>
<!-- 스크립트릿(요청시 마다 실행되는 코드) -->
<%
	System.out.println("스크립트릿");
	if(request.getMethod().equals("POST")){
		num1=Integer.parseInt(request.getParameter("num1"));
		num2=Integer.parseInt(request.getParameter("num2"));
		op=request.getParameter("operator");
	}
%>

<HTML>
<HEAD><TITLE><%="계산기"%></TITLE></HEAD>
<BODY>
<CENTER>
<H3>계산기</H3>
<HR>
<form name=form1 method=post>
<INPUT TYPE="text" NAME="num1" width=200 size="5">
<SELECT NAME="operator">
	<option selected>+</option>
	<option>-</option>
	<option>*</option>
	<option>/</option>
</SELECT>
<INPUT TYPE="text" NAME="num2" width=200 size="5">
<input type="submit" value="계산" name="b1">
<input type="reset" value="다시입력" name="b2">
</form>
<HR>게산 결과: 
<!-- 표현식: 하나의 값을 출력하는 코드 -->
<%=calculator() %>
</BODY>
</HTML>
