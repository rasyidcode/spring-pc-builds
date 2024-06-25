package com.rasyidcode.spring_pc_builds.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomeController {

	@GetMapping("")
	public String index() {
		return "welcome";
	}

}
