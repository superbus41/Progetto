package stageandwork.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import stageandwork.entity.*;
import stageandwork.service.WorkService;

@Controller
@RequestMapping("work")
public class WorkController {
	
	@Autowired
	private WorkService workService;
	
	@GetMapping("/showList")
	public String listOffers(Model model) {
		
		List<Work> works = workService.getWorks();
		
		model.addAttribute("works", works);
		
		return "work-list";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Work work = new Work();
		
		model.addAttribute("work", work);
		
		return "work-form";
	}
	
	@PostMapping("/saveWork")
	public String saveWork(@ModelAttribute("work") Work work) {
		
		workService.saveWork(work);
		
		return "redirect:/work/list";
	}
	
	@GetMapping("/showFormUpdate")
	public String showFormForUpdate(@RequestParam("workId") int id, Model model) {
		
		Work work = workService.getWork(id);
		
		model.addAttribute("work", work);
		
		return "work-form";
	}
	
	@GetMapping("/delete")
	public String deleteWork(@RequestParam("workId") int id, Model model) {
		
		workService.deleteWork(id);
		
		return "redirect:/work/list";
	}
	
	@GetMapping("/search")
	public String searchWorks(@RequestParam("searchName") String searchName, Model model) {
		
		List<Work> works = workService.searchWorks(searchName);
		
		model.addAttribute("works", works);
		
		return "list-works";
	}
}
