package jp.co.amedev.amecolle.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public String execute(Model model){
		return("home");
	}
	
	@RequestMapping("/login")
	public String execute2(Model model){
		return("login");
	}
}
