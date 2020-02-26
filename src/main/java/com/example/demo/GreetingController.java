package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	// get mapping ensures all get HTTP requests send to the /greeting route are mapped to the greeting method
	@GetMapping("/greeting")
	// looking for a param "name", if none proivded, "World" is used in its place
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		// counter is incremented on each request
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
