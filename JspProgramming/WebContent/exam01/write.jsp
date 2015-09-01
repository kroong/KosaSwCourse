<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="dto.*, com.oreilly.servlet.*, com.oreilly.servlet.multipart.*"%>

<%
DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
String urlPath = "/uploadFiles";
String saveFilePath = application.getRealPath(urlPath);
System.out.println(saveFilePath);
MultipartRequest mr = 
new MultipartRequest(request, saveFilePath, 1024*1024*5, "UTF-8", policy);

Board board = new Board();
board.setTitle(mr.getParameter("title"));
board.setWriter(mr.getParameter("writer"));
board.setContent(mr.getParameter("content"));
board.setOriginalFileName(mr.getOriginalFileName("attach"));
board.setFilesystemName(mr.getFilesystemName("attach"));
board.setContentType(mr.getContentType("attach"));
%>

<!-- applicaiton 범위의 BoardService 객체 사용 -->
<jsp:useBean 
	id="boardService" 
	class="service.BoardService"
	scope="application"/>

<%-- BoardService의 add() 메소드를 호출 --%>	
<%boardService.add(board);%>

<%-- BoardService의 add() 메소드를 호출 --%>	
<%response.sendRedirect("list.jsp");%>
