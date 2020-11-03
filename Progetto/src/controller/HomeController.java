package controller;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.*;


@Controller
public class HomeController {
	
	User loggedUser;
	
	@RequestMapping("/")
	public String showMainMenu() {
		return "main-menu";
	}
	
	@RequestMapping("/login")
	public String showLoginForm() {
		return "login-form";
	}
	

	@RequestMapping("/processForm")
	public String processLogin(HttpServletRequest request, Model model) {
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		return "user-confirmation";
		
	}
}
