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
@RequestMapping("/offer")
public class OfferController {
	
	@Autowired
	private WorkService workService;
	
	@Autowired
	private StageService stageService;
	
	
	@GetMapping("/list")
	public String list(Model model) {
		
		return "offer-list";
	}
	
	@GetMapping("/stageList")
	public String listStages(Model model) {
		
		List<Stage> stages = stageService.getStages();
		
		model.addAttribute("stages", stages);
		
		return "stage-list";
	}
	
	@GetMapping("/workList")
	public String listWorks(Model model) {
		
		List<Work> works = workService.getWorks();
		
		model.addAttribute("works", works);
		
		return "work-list";
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
		
		return "redirect:/offer/workList";
	}
	
	@PostMapping("/saveStage")
	public String saveStage(@ModelAttribute("stage") Stage stage) {
		
		stageService.saveStage(stage);
		
		return "redirect:/offer/stageList";
	}
	
	@GetMapping("/updateWork")
	public String showWorkUpdateForm(@RequestParam("workId") int id, Model model) {
		
		Work work = workService.getWork(id);
		
		model.addAttribute("work", work);
		
		return "new-work-offer-form";
	}
	
	@GetMapping("/updateStage")
	public String showStageUpdateForm(@RequestParam("stageId") int id, Model model) {
		
		Stage stage = stageService.getStage(id);
		
		model.addAttribute("stage", stage);
		
		return "new-stage-offer-form";
	}
	
	@GetMapping("/deleteWork")
	public String deleteWork(@RequestParam("workId") int id, Model model) {
		
		workService.deleteWork(id);
		
		return "redirect:/offer/workList";
	}
	
	@GetMapping("/deleteStage")
	public String deleteStage(@RequestParam("stageId") int id, Model model) {
		
		stageService.deleteStage(id);
		
		return "redirect:/offer/stageList";
	}
	
	@GetMapping("/searchWork")
	public String searchWorks(@RequestParam("searchName") String searchName, Model model) {
		
		List<Work> works = workService.searchWorks(searchName);
		
		model.addAttribute("works", works);
		
		return "work-list";
	}
	
	@GetMapping("/searchStage")
	public String searchStages(@RequestParam("searchName") String searchName, Model model) {
		
		List<Stage> stages = stageService.searchStages(searchName);
		
		model.addAttribute("stages", stages);
		
		return "stage-list";
	}
}
