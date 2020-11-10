package stageandwork.controller;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import stageandwork.entity.*;


@Controller
public class HomeController {
		
	@RequestMapping("/home")
	public String showMainMenu() {
		return "main-menu";
	}
	
}
