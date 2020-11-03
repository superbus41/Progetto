package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.*;

public class OfferController {
	
	@RequestMapping("/offer")
	public String showofferMain() {
		return "offer-action";
	}
	
	@RequestMapping("/addOffer")
	public String showNewOfferForm(Model model) {
		
		Offer e = new Offer();
		
		model.addAttribute("offer", e);
		
		return "offer-form";
	}
	
	@RequestMapping("/searchOffers")
	public String showAllofferi() {
		return "offers-list";
	}
	
	@RequestMapping("/processOffer")
	public String processOffer(@ModelAttribute("offer") Offer offer) {
		SessionFactory factory = new Configuration().
									configure("hibernate.cfg.xml").
									addAnnotatedClass(Stage.class).
									addAnnotatedClass(Work.class).
									buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.save(offer);
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}
		return "main-menu";
	}
	
}
