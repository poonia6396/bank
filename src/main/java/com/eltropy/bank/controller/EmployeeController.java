package com.eltropy.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.eltropy.bank.entity.Account;
import com.eltropy.bank.entity.Customer;
import com.eltropy.bank.service.AccountService;
import com.eltropy.bank.service.CustomerService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		List<Customer> customers = customerService.getCustomers();
		
		theModel.addAttribute("customers",customers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-add";
	}

	@PostMapping("/saveCustomer")
	public String showFormForAdd(@ModelAttribute("customer") Customer theCustomer, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
            return "customer-add";
        }
		
		customerService.save(theCustomer);
		
		return "redirect:/employee/list";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		customerService.deleteById(theId);
		
		return "redirect:/employee/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,  Model theModel) {
		
		Customer theCustomer = customerService.getCustomer(theId);
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-add";
	}
	
	@GetMapping("/listAccounts")
	public String listAccounts(@RequestParam("customerId") long theId,  Model theModel) {
		Customer theCustomer = customerService.getCustomer(theId);
		List<Account> accounts = accountService.findByCustomer(theCustomer);
		
		theModel.addAttribute("accounts",accounts);
		theModel.addAttribute("customerId",theId);
		
		return "list-accounts";
	}
	
	@PostMapping("/showFormForAddAccount")
	public String showFormForAddAccount(@RequestParam("customerId") long theId, Model theModel) {
		
		
		theModel.addAttribute("customerId",theId);
		
		
		
		return "account-add";
	}
	
	@PostMapping("/saveAccount")
	public String saveAccount(@ModelAttribute("accountType") String type, @ModelAttribute("customerId") long theId,BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
            return "account-add";
        }
		
		Account theAccount = new Account(type);
		
		Customer theCustomer =  customerService.getCustomer(theId);
		
		theCustomer.addAccount(theAccount);
		
		accountService.save(theAccount);
		
		return "redirect:/employee/list";
	}
	
	@GetMapping("/deleteAccount")
	public String deleteAccount(@RequestParam("accountId") int theId) {
		
		accountService.deleteById(theId);
		
		return "redirect:/employee/list";
	}
	
}
