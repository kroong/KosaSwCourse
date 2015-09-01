package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController {

	public void handle(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("MemberController-handle");
		String action = req.getParameter("action");
		switch(action){
			case "joinForm": joinForm(req,res); break;
			case "join": join(req,res); break;
			case "loginForm": loginForm(req,res); break;
			case "login": login(req,res); break;
		}
	}
	public void joinForm(HttpServletRequest req, HttpServletResponse res){
		System.out.println("joinForm");
	}
	public void join(HttpServletRequest req, HttpServletResponse res){
		System.out.println("join");
	}
	public void loginForm(HttpServletRequest req, HttpServletResponse res){
		System.out.println("loginForm");
	}
	public void login(HttpServletRequest req, HttpServletResponse res){
		System.out.println("loin");
	}
}
