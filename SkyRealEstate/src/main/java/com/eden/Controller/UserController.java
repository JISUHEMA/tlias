package com.eden.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eden.Service.UserService;
import com.eden.entity.UserEntity;



@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        List<UserEntity> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "user/list";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        UserEntity user = userService.getUserById(id).orElse(null);
        model.addAttribute("user", user);
        return "user/detail";
    }

    @PostMapping
    public String createUser(@ModelAttribute UserEntity user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute UserEntity user) {
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
