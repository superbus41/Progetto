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

import progetto.stageandwork.entity.*;
import progetto.stageandwork.service.UserService;
import progetto.stageandwork.service.WorkService;

@Controller
@RequestMapping("/work")
public class WorkController {
	
	@Autowired
	private WorkService workService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String listWorks(Model model) {
		
		List<Work> works = workService.getWorks();
		
		model.addAttribute("works", works);
		
		return "work-list";
	}

	@GetMapping("/new")
	public String showNewWorkForm(Model model) {
		
		Work work = new Work();
		
		model.addAttribute("work", work);
		
		return "new-work-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("work") Work work, Principal principal) {
		
		
		User user = userService.loadUserByUsername(principal.getName());
		
		Company company = user.getCompany();
		
		work.setCompany(company);
		
		workService.saveWork(work);
		
		return "redirect:/work/list";
	}

	@GetMapping("/update")
	public String update(@RequestParam("workId") int id, Model model) {
		
		Work work = workService.getWork(id);
		
		model.addAttribute("work", work);
		
		return "new-work-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("workId") int id, Model model) {
		
		workService.deleteWork(id);
		
		return "redirect:/work/list";
	}

	@GetMapping("/search")
	public String search() {
		return "search-work";
	}	
	
	@GetMapping("/searchForm")
	public String search(	@RequestParam String title,
							@RequestParam String sector,
							@RequestParam String company,
							Model model) {
		
		List<Work> works = workService.searchWorks(title, sector, company);
		
		model.addAttribute("works", works);
		
		return "work-list";
	}
	
	@GetMapping("/convalidate")
	public String validate(@RequestParam("workId") int id, Model model) {
		
		Work work = workService.getWork(id);
		
		work.setValidated(true);
		
		workService.saveWork(work);
		
		return "redirect:/work/list";
	}
	
	@GetMapping("/invalidate")
	public String invalidate(@RequestParam("workId") int id, Model model) {
		
		Work work = workService.getWork(id);
		
		work.setValidated(false);
		
		workService.saveWork(work);
		
		return "redirect:/work/list";
	}

	@GetMapping("/details")
	public String details(@RequestParam("workId") int id, Model model) {
		
		Work work = workService.getWork(id);

		model.addAttribute("work", work);
		
		return "details";
	}
	
	@GetMapping("/subscribe")
	public String subscribe(@RequestParam("workId") int id, Principal principal) {
		
		User user = userService.loadUserByUsername(principal.getName());
		
		Student student = user.getStudent();
		
		Work work = workService.getWork(id);
		
		work.addSub(student);
		
		workService.saveWork(work);
		
		return "redirect:/work/list";
	}
	
	@GetMapping("/unsubscribe")
	public String unsubscribe(@RequestParam("workId") int id, Principal principal) {
		
		User user = userService.loadUserByUsername(principal.getName());
		
		Student student = user.getStudent();
		
		Work work = workService.getWork(id);

		work.removeSub(student);
			
		workService.saveWork(work);
		
		return "redirect:/work/list";
	}
}
