package org.example.controller;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("/")
public class UserController {
    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAll(ModelMap model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "getAll";
    }

    @GetMapping("pageAdd")
    public String pageAdd() {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user, ModelMap model) {
        userService.save(user);
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "getAll";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") long id, ModelMap model) {
        userService.deleteById(id);
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "getAll";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") long id, ModelMap model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @PostMapping("updateUser")
    public String updateUser(@ModelAttribute("user") User user, ModelMap model) {
        userService.update(user);
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "getAll";
    }
}
