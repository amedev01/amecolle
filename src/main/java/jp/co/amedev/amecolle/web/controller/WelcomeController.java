package jp.co.amedev.amecolle.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class WelcomeController {

	static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
	
	@GetMapping("/")
	public String execute(Model model){
		logger.debug("WelcomeController accessed");
		return("home");
	}
	
}
