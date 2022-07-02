package com.example.Creation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.Creation.domain.Tasks;
import com.example.Creation.service.TasksService;

@Controller
public class CreationController {
	
	 @Autowired
	    private TasksService service;

	    @GetMapping("/")
	    public String viewHomePage(Model model) {
	        List<Tasks> listtasks = service.listAll();
	        model.addAttribute("listtasks", listtasks);
	        System.out.print("Get / ");	
	        return "index";
	    }

	    @GetMapping("/new")
	    public String add(Model model) {
	        model.addAttribute("task", new Tasks());
	        return "new";
	    }

	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String saveTask(@ModelAttribute("task") Tasks std) {
	        service.save(std);
	        return "redirect:/";
	    }

	    @RequestMapping("/edit/{id}")
	    public String showEditTaskPage(Model model, @PathVariable(name = "id") int id) {
	        Tasks std = service.get(id);
	        model.addAttribute("task", std);
	        return "edit";
	    }
	    @RequestMapping("/delete/{id}")
	    public String deletetask(@PathVariable(name = "id") int id) {
	        service.delete(id);
	        return "redirect:/";
	    }
			@GetMapping("/do-task/{id}")
	    public String doTask(@PathVariable(name = "id") int id) {
				Tasks old_std = service.get(id);
				old_std.setKeterangan(true);
				service.save(old_std);
				return "redirect:/";
	        
	    }
}