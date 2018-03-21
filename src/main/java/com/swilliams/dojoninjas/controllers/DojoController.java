package com.swilliams.dojoninjas.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.swilliams.dojoninjas.models.Dojo;
import com.swilliams.dojoninjas.services.DojoService;


@Controller
@RequestMapping("/dojos")
public class DojoController {
	private DojoService dS;
	
	public DojoController(DojoService dS) {
		this.dS = dS;
	}
	
	@RequestMapping("/new")
	public String newDojo(Model model) {
		model.addAttribute("dojo",new Dojo());
		return "dojos.jsp";
	}
	
	@PostMapping("/new")
	public String newDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult res,RedirectAttributes re) {
		if(res.hasErrors()) {
			re.addFlashAttribute("errs",res.getAllErrors());
		}else {
			dS.create(dojo);
		}
		return "redirect:/dojos/new";
	}
	
	@RequestMapping("/{id}")
	public String showDojo(@PathVariable("id")Long id,Model model) {
		Optional<Dojo> dojo = dS.find(id);
		Dojo dj = dojo.get();
		model.addAttribute("dojo",dj);
		
		return "showdojo.jsp";
	}
	
}
