package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
/*		resp.setContentType("text/html; charset=UTF-8");
		ServletOutputStream sos = resp.getOutputStream();
		String html= "";
		html+="<?DOCUTYPE html>";
		html+="<html>";
		html+="	<head>";
		html+="		<meta charset='UTF-8'>";
		html+="	</head>";
		html+="	<body>";
		html+="		<form method='post' action='/LoginServlet'>";
		html+="			���̵�:<input type='text' name='mid'/><br/>";
		html+="			���:<input type='text' name='mpass'/><br/>";
		html+="			<input type='submit' value='�α���'/><br/>";
		html+="		</form>";
		html+="";
		
		html+="	</body>";
		html+="</html>";
		sos.write(html.getBytes("UTF-8"));*/
		RequestDispatcher rd= 
				req.getRequestDispatcher("ch04/login_form.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��û �Ķ���� �� �ޱ�---------------------------------
		req.setCharacterEncoding("UTF-8");
		String mid=req.getParameter("mid");
		String mpass=req.getParameter("mpass");
		
		//��û ó�� �ϱ� -------------------------------------

		//���� ������ ---------------------------------------
		resp.setContentType("text/html; charset=UTF-8");
		ServletOutputStream sos=resp.getOutputStream();
		String html= "";
		html+="<?DOCUTYPE html>";
		html+="<html>";
		html+="	<head>";
		html+="		<meta charset='UTF-8'>";
		html+="	</head>";
		html+="	<body>";

		html+="		"+mid+"��, �α��� ����";
		
		html+="	</body>";
		html+="</html>";
		sos.write(html.getBytes("UTF-8"));
		
		
	};
	
}
