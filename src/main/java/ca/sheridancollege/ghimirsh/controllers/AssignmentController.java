package ca.sheridancollege.ghimirsh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import ca.sheridancollege.ghimirsh.beans.CSRFormat;

@Controller
public class AssignmentController {
	
	@GetMapping("/assignment1")
	public String goAssignment1( Model model) {
		model.addAttribute("objCSRFormat",new CSRFormat() );
		return "assignment1";
	}

	@GetMapping("/add")
	public String doAddCSRFormat(Model model, @ModelAttribute CSRFormat objCSRFormat) {
		System.out.println(objCSRFormat.toString());
		
		return "output";
	}
	
	@GetMapping("/output")
	public String goOutput() {
		
		return "output";
	}
	
}
