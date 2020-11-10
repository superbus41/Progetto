package progetto.stageandwork.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import progetto.stageandwork.entity.Event;
import progetto.stageandwork.service.EventService;

@Controller
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventService eventService;
	
	@GetMapping("/list")
	public String listOffers(Model model) {
		
		List<Event> events = eventService.getEvents();
		
		model.addAttribute("events", events);
		
		return "event-list";
	}
	
	@GetMapping("/new")
	public String showFormForAdd(Model model) {
		
		Event event = new Event();
		
		model.addAttribute("event", event);
		
		return "new-event-form";
	}
	
	@PostMapping("/save")
	public String saveEvent(@ModelAttribute("event") Event event) {
		
		eventService.saveEvent(event);
		
		return "redirect:/event/list";
	}
	
	@GetMapping("/update")
	public String showUpdateForm(@RequestParam("eventId") int id, Model model) {
		
		Event event = eventService.getEvent(id);
		
		model.addAttribute("event", event);
		
		return "new-event-form";
	}
	
	@GetMapping("/delete")
	public String deleteEvent(@RequestParam("eventId") int id, Model model) {
		
		eventService.deleteEvent(id);
		
		return "redirect:/event/list";
	}
	
	@GetMapping("/search")
	public String searchEvents(@RequestParam("searchName") String searchName, Model model) {
		
		List<Event> events = eventService.searchEvents(searchName);
		
		model.addAttribute("events", events);
		
		return "event-list";
	}
}
