package com.eden.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eden.entity.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("hello")
public class DemoController {
	
	public String hello() {
		
		System.out.println("Hello Thymeleaf!");
		return "index";
	}
	@GetMapping("demo")
	public String demo(Model model ) {
		
		log.info("demo OK!");
		
		String String="Hello Thymeleaf";
		
		model.addAttribute("msg",String);
		
		return"index";
	}
	@RequestMapping("value")
	public String sentvalue(HttpServletRequest request,Model model,HttpSession session) {
		
		String name="瓜皮";
		
		Integer age=25;
		String access=" 谷歌";
		request.setAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("access", access);
		
		User user=new User(20,"李",2300.00,new Date());
		request.setAttribute("user", user);
		
		List<User> users=Arrays.asList(new User(21,"さｋま",4500.0,new Date()),
				new User(22,"山本",5700.0,new Date()),
				new User(23,"大田",57700.0,new Date()));
		model.addAttribute("users", users);
		
		session.setAttribute("username1", "山本");
		session.setAttribute("username",users);
		
		return "sentValue";
		
	}
	
}