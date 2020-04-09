package com.example.springboot.controller;

import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService service;


	@RequestMapping(value = "/user/hello", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("This user");
		model.addAttribute("messages", messages);
		return "user/hello";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String printError(ModelMap model) {

		List<String> messages = new ArrayList<>();
		messages.add("Error");

		model.addAttribute("messages", messages);
		return "home";
	}

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

}