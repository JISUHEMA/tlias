package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpI implements DemoService{

	@Override
	public void demo() {
		System.out.println("DemoService OK");
	}

	

}
