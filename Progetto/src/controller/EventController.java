package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Event;

@Controller
public class EventController {

	@RequestMapping("/event")
	public String showEventMain() {
		return "event-action";
	}
	
	@RequestMapping("/addEvent")
	public String showNewEventForm(Model model) {
		
		Event e = new Event();
		
		model.addAttribute("event", e);
		
		return "event-form";
	}
	
	@RequestMapping("/searchEvents")
	public String showAllEventi() {
		return "events-list";
	}
	
	@RequestMapping("/processEvent")
	public String processEvent(@ModelAttribute("event") Event event) {
		SessionFactory factory = new Configuration().
									configure("hibernate.cfg.xml").
									addAnnotatedClass(Event.class).
									buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.save(event);
			session.getTransaction().commit();
		}finally {
			session.close();
			factory.close();
		}
		return "main-menu";
	}
	
}
