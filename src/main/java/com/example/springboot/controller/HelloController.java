package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
@RequestMapping("/admin")
public class HelloController {

	@Autowired
	private UserService service;


	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView mainPage() {
		List<User> users = service.getAllUser();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/users");
		modelAndView.addObject("userList", users);

		return modelAndView;
	}

	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable("id") Long id) {
		User user = service.getUserById(id);


		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("admin/editPage");
		modelAndView.addObject("user", user);

		return modelAndView;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editUser(@ModelAttribute("user") User user, @RequestParam("checkboxRole") String[] checkboxRoles) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/users");
		if (checkboxRoles.length < 2) {
			modelAndView.addObject("error","Choose the role or roles");
			modelAndView.setViewName("admin/editPage");
			return modelAndView;
		}

		if (user.getPassword().equals("") || user.getEmail().equals("")  || user.getName().equals("") ) {
			modelAndView.addObject("error","Some field is empty");
			modelAndView.setViewName("admin/editPage");
			return modelAndView;
		}
		String oldUnicEmail = service.getUserById(user.getId()).getEmail();

		if ((!service.unicEmail(user.getEmail()) ^ user.getEmail().equals(oldUnicEmail))) {
			modelAndView.addObject("error","Email must be unic");
			modelAndView.setViewName("admin/editPage");
			return modelAndView;
		}

		service.edit(user, checkboxRoles);
		return modelAndView;
	}

	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String addPage() {
		return "admin/addPage";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") User user, @RequestParam("checkboxRole") String[] checkboxRoles) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/users");
		if (checkboxRoles.length < 2) {
			modelAndView.addObject("error","Choose the role or roles");
			modelAndView.setViewName("admin/addPage");
			return modelAndView;
		}
		if (user.getPassword().equals("") || user.getEmail().equals("")  || user.getName().equals("") ) {
			modelAndView.addObject("error","Some field is empty");
			modelAndView.setViewName("admin/addPage");
			return modelAndView;
		}
		if (!service.unicEmail(user.getEmail())) {
			modelAndView.addObject("error","Email must be unic");
			modelAndView.setViewName("admin/editPage");
			return modelAndView;
		}

		service.add(user, checkboxRoles);
		return modelAndView;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") Long id) {
		User user = service.getUserById(id);
		service.delete(user);
		return "redirect:/admin/users";
	}


	
}