package com.swilliams.dojoninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.swilliams.dojoninjas.models.Ninja;
import com.swilliams.dojoninjas.services.DojoService;
import com.swilliams.dojoninjas.services.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	private NinjaService nS;
	private DojoService dS;
	
	public NinjaController(NinjaService nS,DojoService dS) {
		this.nS = nS;
		this.dS = dS;
	}
	
	@RequestMapping("/new")
	public String newNinja(Model model) {
		model.addAttribute("ninja", new Ninja());
		model.addAttribute("dojos", dS.all());
		return "ninjas.jsp";
	}
	
	@PostMapping("/new")
	public String createNinja( @Valid @ModelAttribute("ninja") Ninja ninja, BindingResult res, RedirectAttributes re) {
		if(res.hasErrors()) {
			re.addFlashAttribute("errs",res.getAllErrors());
		}else {
			nS.create(ninja);			
		}
		return "redirect:/ninjas/new";
	}

}
