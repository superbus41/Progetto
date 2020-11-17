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

import progetto.stageandwork.entity.Stage;
import progetto.stageandwork.entity.Work;
import progetto.stageandwork.service.StageService;

@Controller
@RequestMapping("/stage")
public class StageController {
	
	@Autowired
	private StageService stageService;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		List<Stage> stages = stageService.getStages();
		
		model.addAttribute("stages", stages);
		
		return "stage-list";
	}
	
	@GetMapping("/new")
	public String add(Model model) {
		
		Stage stage = new Stage();
		
		model.addAttribute("stage", stage);
		
		return "new-stage-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("stage") Stage stage) {
		
		stageService.saveStage(stage);
		
		return "redirect:/stage/list";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("stageId") int id, Model model) {
		
		Stage stage = stageService.getStage(id);
		
		model.addAttribute("stage", stage);
		
		return "new-stage-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("stageId") int id, Model model) {
		
		stageService.deleteStage(id);
		
		return "redirect:/stage/list";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("searchName") String searchName, Model model) {
		
		List<Stage> stages = stageService.searchStages(searchName);
		
		model.addAttribute("stages", stages);
		
		return "stage-list";
	}
	
	@GetMapping("/convalidate")
	public String validate(@RequestParam("stageId") int id, Model model) {
		
		Stage stage = stageService.getStage(id);
		
		stage.setValidated(true);
		
		stageService.saveStage(stage);
		
		return "redirect:/stage/list";
	}
	
	@GetMapping("/invalidate")
	public String invalidate(@RequestParam("stageId") int id, Model model) {
		
		Stage stage = stageService.getStage(id);
		
		stage.setValidated(false);
		
		stageService.saveStage(stage);
		
		return "redirect:/stage/list";
	}
}
