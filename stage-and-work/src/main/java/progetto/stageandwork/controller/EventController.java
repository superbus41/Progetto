package progetto.stageandwork.controller;

import java.security.Principal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import progetto.stageandwork.entity.Event;
import progetto.stageandwork.entity.Student;
import progetto.stageandwork.entity.Subscriber;
import progetto.stageandwork.entity.University;
import progetto.stageandwork.entity.User;
import progetto.stageandwork.service.EventService;
import progetto.stageandwork.service.UserService;

@Controller
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventService eventService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Event> events = eventService.getEvents();
		
		model.addAttribute("events", events);
		
		return "event-list";
	}
	
	@GetMapping("/new")
	public String add(Model model) {
		
		Event event = new Event();
		
		model.addAttribute("event", event);
		
		return "new-event-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("event") Event event, Principal principal) {
		
		User user = userService.loadUserByUsername(principal.getName());
		
		University university = user.getUniversity();
		
		event.setUniversity(university);
		
		eventService.saveEvent(event);
		
		return "redirect:/event/list";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("eventId") int id, Model model) {
		
		Event event = eventService.getEvent(id);
		
		model.addAttribute("event", event);
		
		return "new-event-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("eventId") int id, Model model) {
		
		eventService.deleteEvent(id);
		
		return "redirect:/event/list";
	}
	
	@GetMapping("/search")
	public String search() {
		return "search-event";
	}	
	
	@GetMapping("/searchForm")
	public String search(	@RequestParam String title,
							@RequestParam String sector,
							@RequestParam String place,
							@RequestParam String university,
							Model model) {
		
		List<Event> events = eventService.searchEvents(title, sector, place, university);
		
		model.addAttribute("events", events);
		
		return "event-list";
	}
	
	@GetMapping("/details")
	public String details(@RequestParam("eventId") int id, Model model) {
		
		Event event = eventService.getEvent(id);

		model.addAttribute("event", event);
		
		return "details";
	}
	
	@GetMapping("/subscribe")
	public String subscribe(@RequestParam("eventId") int id, Principal principal) {
		
		User user = userService.loadUserByUsername(principal.getName());
		
		Subscriber sub = user.getSubscriber();
		
		Event event = eventService.getEvent(id);
		
		event.addSub(sub);
		
		eventService.saveEvent(event);
		
		return "redirect:/event/list";
	}
	
	@GetMapping("/unsubscribe")
	public String unsubscribe(@RequestParam("eventId") int id, Principal principal) {
		
		User user = userService.loadUserByUsername(principal.getName());
		
		Subscriber sub = user.getSubscriber();
		
		Event event = eventService.getEvent(id);

		event.removeSub(sub);
			
		eventService.saveEvent(event);
		
		return "redirect:/event/list";
	}
}
