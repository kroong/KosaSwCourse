package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import dto.Board;

public class BoardController {
	private ServletContext application;
	private BoardService boardService;
	
	public void handle(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		application = req.getServletContext();
		boardService = (BoardService) application.getAttribute("boardService");
		if(boardService==null){
			boardService=new BoardService();
			application.setAttribute("boardService", boardService);
		}
		
		String action = req.getParameter("action");
		switch(action){
		case "list": list(req,res); break;
		case "writeForm": writeForm(req,res); break;
		case "write": write(req,res); break;
	}
	}
	
	private void write(HttpServletRequest req, HttpServletResponse res) {
		
		
	}

	private void writeForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/exam03/write_form.jsp");
		rd.forward(req,res);
		
	}


	private void list(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("BoardController-list");
		
		List<Board> list = boardService.getPage(1, 10);
		req.setAttribute("list", list);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/exam03/list.jsp");
		rd.forward(req,res);
	}

}
