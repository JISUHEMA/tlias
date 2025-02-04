package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.DemoService;

@RestController
public class HelloController {
	
	@Autowired
	private DemoService demoService;
	
	@RequestMapping("hello")
	public String hello() {
		
		System.out.println("Hello SpringBoot1");
		return "Hello SpringBoot2";
	}
	
	@GetMapping("demo")
	public String demo() {
		demoService.demo();
		//DemoServiceImpI ds=new DemoServiceImpI();
		//ds.demo();
		
		return "Demo OK";
	}
}
