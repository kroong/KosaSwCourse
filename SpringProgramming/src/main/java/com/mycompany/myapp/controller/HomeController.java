package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final  Logger Logger= LoggerFactory.getLogger(HomeController.class);
	@RequestMapping("/")
	public String home() {
		
		System.out.println("homecontroller-home");
		Logger.info("HomeController-home()");
		return "home";
	}
	
}
