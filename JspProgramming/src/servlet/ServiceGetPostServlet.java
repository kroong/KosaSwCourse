package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServiceGetPostServlet extends HttpServlet {
	
/*	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)throws ServletException, IOException {
		//��û ��İ� ��� ���� �׻� ������ ������ ����
	}*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��û ����� GET�� ��쿡 ������ ����
		System.out.println("Get ������� ��û�ϼ̳׿�.");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//��û ����� POST�� ��쿡 ������ ����
		System.out.println("Post ������� ��û�ϼ̳׿�");
	}
}
