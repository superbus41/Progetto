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

import progetto.stageandwork.entity.Company;
import progetto.stageandwork.entity.Event;
import progetto.stageandwork.entity.Stage;
import progetto.stageandwork.entity.Student;
import progetto.stageandwork.entity.User;
import progetto.stageandwork.service.StageService;
import progetto.stageandwork.service.UserService;

@Controller
@RequestMapping("/stage")
public class StageController {
	
	@Autowired
	private StageService stageService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String list(Model model, Principal principal) {
		
		List<Stage> stages = stageService.getStages();
		
		model.addAttribute("stages", stages);
		
		return "stage-list";
	}
	
	@GetMapping("/new")
	public String add(Model model, Principal principal) {
		
		Stage stage = new Stage();
		
		model.addAttribute("stage", stage);
		
		return "new-stage-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("stage") Stage stage, Principal principal) {
		
		User user = userService.loadUserByUsername(principal.getName());
		
		Company company = user.getCompany();
		
		stage.setCompany(company);
		
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
	public String search() {
		return "search-stage";
	}	
	
	@GetMapping("/searchForm")
	public String search(	@RequestParam String title,
							@RequestParam String sector,
							@RequestParam(required = false, defaultValue = "false") boolean curricular,
							@RequestParam(required = false, defaultValue = "false") boolean validated,
							@RequestParam String company,
							@RequestParam(required = false, defaultValue = "2000-01-01") String fromDate,
							@RequestParam(required = false, defaultValue = "2099-12-31") String toDate,
							Model model) {
		
		List<Stage> stages = stageService.searchStages(title, sector, curricular, validated, company, Date.valueOf(fromDate), Date.valueOf(toDate));
		
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
	
	@GetMapping("/details")
	public String details(@RequestParam("stageId") int id, Model model) {
		
		Stage stage = stageService.getStage(id);

		model.addAttribute("stage", stage);
		
		return "details";
	}
	
	@GetMapping("/subscribe")
	public String subscribe(@RequestParam("stageId") int id, Principal principal) {
		
		User user = userService.loadUserByUsername(principal.getName());
		
		Student student = user.getStudent();
		
		Stage stage = stageService.getStage(id);
		
		stage.addSub(student);
		
		stageService.saveStage(stage);
		
		return "redirect:/stage/list";
	}
	
	@GetMapping("/unsubscribe")
	public String unsubscribe(@RequestParam("stageId") int id, Principal principal) {
		
		User user = userService.loadUserByUsername(principal.getName());
		
		Student student = user.getStudent();
		
		Stage stage = stageService.getStage(id);

		stage.removeSub(student);
			
		stageService.saveStage(stage);
		
		return "redirect:/stage/list";
	}
}
