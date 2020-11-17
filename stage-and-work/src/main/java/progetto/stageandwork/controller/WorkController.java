package progetto.stageandwork.controller;

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
import progetto.stageandwork.service.StageService;
import progetto.stageandwork.service.WorkService;

@Controller
@RequestMapping("/work")
public class WorkController {
	
	@Autowired
	private WorkService workService;
	
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
	public String save(@ModelAttribute("work") Work work) {
		
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
	public String search(@RequestParam("searchName") String searchName, Model model) {
		
		List<Work> works = workService.searchWorks(searchName);
		
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

}
