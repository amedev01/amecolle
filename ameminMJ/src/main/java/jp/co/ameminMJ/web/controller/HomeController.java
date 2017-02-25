package jp.co.ameminMJ.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.ameminMJ.web.form.LoginForm;

@Controller
public class HomeController {

	
	
	@RequestMapping("/home")
	public String execute(@ModelAttribute LoginForm loginForm, Model model){
		return("home");
		
	}
	

}
