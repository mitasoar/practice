package com.coderby.myapp.hello.service.proxy;

import org.springframework.stereotype.Component;

import com.coderby.myapp.hello.service.HelloService;
import com.coderby.myapp.util.HelloLog;

@Component("helloServiceProxy")
public class HelloServiceProxy extends HelloService{
	
	@Override
	public String sayHello(String name) {
		HelloLog.log();
		return super.sayHello(name);
	}

	@Override
	public String sayGoodbye(String name) {
		return "Goodbye~" + name;
	}
}
