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
import progetto.stageandwork.service.WorkService;

@Controller
@RequestMapping("/offer")
public class OfferController {
	
	@Autowired
	private WorkService workService;
	
	@GetMapping("/list")
	public String listOffers(Model model) {
		
		List<Work> works = workService.getWorks();
		
		model.addAttribute("works", works);
		
		return "offer-list";
	}
	
	@GetMapping("/new")
	public String showNewOfferForm() {
		return "new-offer-type-form";
	}
	
	@GetMapping("/newStage")
	public String showNewStageForm(Model model) {
		
		Stage stage = new Stage();
		
		model.addAttribute("stage", stage);
		
		return "new-stage-offer-form";
	}
	
	@GetMapping("/newWork")
	public String showNewWorkForm(Model model) {
		
		Work work = new Work();
		
		model.addAttribute("work", work);
		
		return "new-work-offer-form";
	}
	
	@PostMapping("/saveWork")
	public String saveWork(@ModelAttribute("work") Work work) {
		
		workService.saveWork(work);
		
		return "redirect:/offer/list";
	}
	
	@GetMapping("/updateWork")
	public String showFormForUpdate(@RequestParam("workId") int id, Model model) {
		
		Work work = workService.getWork(id);
		
		model.addAttribute("work", work);
		
		return "work-form";
	}
	
	@GetMapping("/deleteWork")
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
