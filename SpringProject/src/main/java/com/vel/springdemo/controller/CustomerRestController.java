package com.vel.springdemo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.vel.springdemo.entity.Customer;
import com.vel.springdemo.service.CustomerService;

@RestController
@RequestMapping("/rest")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	/* ----------------------------Retrieve All Users---------------------------- */
	@GetMapping("/userlist")
	public ResponseEntity<List<Customer>> getCustomersList() {			
		List<Customer> thecustomers = customerService.getCustomers();
		if(thecustomers.isEmpty()) {
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}	
		return new ResponseEntity<List<Customer>>(thecustomers, HttpStatus.OK);
	}
	
	/* ----------------------------Retrieve Single User---------------------------- */
	@GetMapping("/user/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id) {	
		System.out.println("getCustomer: id: "+id);
		Customer thecustomer = customerService.getCustomer(id);
		if(thecustomer==null) {
			System.out.println("Customer Not Found: "+thecustomer);
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}	
		return new ResponseEntity<Customer>(thecustomer, HttpStatus.OK);
	}
	
	/* ----------------------------Create a User---------------------------- */
	@PostMapping("/user/")
	public ResponseEntity<String> createUser(@RequestBody Customer customer, UriComponentsBuilder uriComponentsBuilder){
		System.out.println("User FirstName: " + customer.getFirstName());
		System.out.println("User LastName: " + customer.getLastName());
		System.out.println("User Email: " + customer.getEmail());
		Customer thecustomer = customerService.getCustomerInfo(customer);
		if(thecustomer!=null) {
			System.out.println("Customer is Found: Create: "+customer);
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		
		customerService.saveCustomer(customer);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(uriComponentsBuilder.path("/user/{id}").buildAndExpand(customer.getId()).toUri());		
		return new ResponseEntity<String>("Record Created",httpHeaders, HttpStatus.CREATED);
	}
	
	/* ----------------------------Update a User---------------------------- */
	@PutMapping("/user/{id}")
	public ResponseEntity<Customer> updateUser(@PathVariable("id") int id, @RequestBody Customer customer){
		System.out.println("updateUser: id: "+id);
		Customer thecustomer = customerService.getCustomer(id);
		if(thecustomer==null) {
			System.out.println("Update: Customer Not Found: "+thecustomer);
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		thecustomer.setFirstName(customer.getFirstName());
		thecustomer.setLastName(customer.getLastName());
		thecustomer.setEmail(customer.getEmail());
		customerService.saveCustomer(thecustomer);
		return new ResponseEntity<Customer>(thecustomer, HttpStatus.CREATED);
	}
	
	/* ----------------------------Delete a User---------------------------- */
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Customer> deleteUser(@PathVariable("id") int id){
		System.out.println("deleteUser: id: "+id);
		Customer thecustomer = customerService.getCustomer(id);
		if(thecustomer==null) {
			System.out.println("Update: Customer Not Found: "+thecustomer);
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		customerService.deleteCustomer(thecustomer.getId());
		return new ResponseEntity<Customer>(thecustomer, HttpStatus.NO_CONTENT);
	}
}
