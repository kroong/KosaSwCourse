<%@ page contentType="text/html; charset=UTF-8"%>

<%String method = request.getMethod(); %>

<%if(method.equals("GET")) {%>
	<h4>재윤이가 오늘 시비를 걸어요</h4>
	<img src="../common/images/avata/2seirek_8.gif"/>
<%} else if(method.equals("POST")){ %>
	<h4>재윤이가 오늘 시비를 걸어요</h4>
	<img src="../common/images/avata/avata1.gif"/>
<%}%>