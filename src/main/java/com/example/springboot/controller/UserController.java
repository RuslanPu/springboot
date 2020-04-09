package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public String userPage(ModelMap model) {

        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("This user");
        model.addAttribute("messages", messages);
        return "user/userPage";
    }
}
