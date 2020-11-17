package progetto.stageandwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "login";
	}
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}	
	
	@GetMapping("/newOffer")
	public String showNewOfferForm() {
		return "new-offer-type-form";
	}
	
	@GetMapping("/listOffer")
	public String list(Model model) {
		
		return "offer-list";
	}
}
