package com.vel.springdemo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import com.vel.springdemo.dao.CustomerDAO;
import com.vel.springdemo.entity.Customer;
//import com.vel.springdemo.entity.Role;
import com.vel.springdemo.service.CustomerService;
//import com.vel.springdemo.service.CustomerServiceOracle;
import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer service
	@Autowired
	private CustomerService customerService;
	
	/* Roles from Oracle Database
	@Autowired
	private CustomerServiceOracle customerServiceOracle;
	*/
	
	// need to inject the customer dao
	/* It's removed due to service layer
	@Autowired
	private CustomerDAO customerDAO;
	*/
		
	//@RequestMapping("/list")
	@GetMapping("/list")
	public String listCustomers(Model theModel) {	
		
		// get the customer from service
		List<Customer> thecustomers = customerService.getCustomers();
		// get the customer from dao
		//List<Customer> thecustomers = customerDAO.getCustomers();
				
		// add the customers to the model
		theModel.addAttribute("customers", thecustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Validation Process Begin....!: "+result.toString());		
			return "customer-form";
		} else {
			// save the customer using our service
			customerService.saveCustomer(customer);		
			return "redirect:/customer/list";	
		}
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		// get the customer from our service
		Customer theCustomer = customerService.getCustomer(theId);
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		
		// send over to our form
		return "customer-form";		
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		// get the customer from our service
		//Customer theCustomer = customerService.getCustomer(theId);
		
		// delete the customer from our service
		//Customer theDeletedCustomer = customerService.deleteCustomer(theCustomer);
		customerService.deleteCustomer(theId);
		
		// set customer as a model attribute to pre-populate the form
		//theModel.addAttribute("customer", theCustomer);
		
		return "redirect:/customer/list";
	}
	
	/* Roles from Oracle Database
	@GetMapping("/showRole")
	public String showRole(Model theModel) {
		
		List<Role> theRole = customerServiceOracle.getRoles();
		theModel.addAttribute("role", theRole);
		
		return "oraclerole";
	}
	*/
}
