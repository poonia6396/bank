package com.eltropy.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.eltropy.bank.entity.*;
import com.eltropy.bank.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		List<User> employees = userService.findBySpecificRole("ROLE_EMPLOYEE");
		
		theModel.addAttribute("employees",employees);
		
		return "list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		User theEmployee = new User();
		theModel.addAttribute("employee",theEmployee);
		
		return "employee-add";
	}

	@PostMapping("/saveEmployee")
	public String showFormForAdd(@ModelAttribute("employee") User theEmployee, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
            return "employee-add";
        }
		
		
		userService.save(theEmployee);
		
		return "redirect:/admin/list";
	}
	
	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam("userId") int theId) {
		
		userService.deleteById(theId);
		
		return "redirect:/admin/list";
	}
}
