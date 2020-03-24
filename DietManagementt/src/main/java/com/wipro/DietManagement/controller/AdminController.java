package com.wipro.DietManagement.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminController {
	
	@RequestMapping("/")
	public String login()
	{
		System.out.println("Entered");
		return "login sucessfully";
	}

}
