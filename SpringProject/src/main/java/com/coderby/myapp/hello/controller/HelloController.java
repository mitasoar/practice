package com.coderby.myapp.hello.controller;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.coderby.myapp.hello.service.*;

@Controller
public class HelloController {

//	@Inject
//	IHelloService service;

//	@Autowired
//	@Qualifier("niceService")
//	IHelloService helloService;

	@Resource(name = "helloService")
	IHelloService helloService;

//	public HelloController(IHelloService helloService) {
//		this.helloService = helloService;
//	}

	public void hello(String name) {
		System.out.println("HelloController : " + helloService.sayHello(name));
	}

	public void goodbye(String name) {
		System.out.println("HelloController : " + helloService.sayGoodbye(name));
	}
}
