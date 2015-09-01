package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BoardController;
import controller.MemberController;

/**
 * Servlet implementation class DispatcherServlet
 */

public class DispatcherServlet extends HttpServlet {
	private MemberController memberController;
	private BoardController boardController;
	
	@Override
	public void init() throws ServletException {
		memberController = new MemberController();
		boardController = new BoardController();
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		//*******************************************
		// URL ╦егн
		//*******************************************
		// /JspProgramming/mvc
		String requestURI = req.getRequestURI();
		
		// /JspProgramming/mvc/member
		if(requestURI.indexOf("/mvc/member")!=-1){
			memberController.handle(req,res);
		}
		/*/JspProgramming/mvc/board */
		else if(requestURI.indexOf("/mvc/board")!=-1){
			boardController.handle(req,res);
		}
	}

}
