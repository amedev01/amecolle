package jp.co.amedev.amecolle.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.amedev.amecolle.web.form.HomeForm;
import jp.co.amedev.amecolle.web.form.SignUpForm;


@Controller
public class SignUpController {

	
	@GetMapping("/signUp")
	public String execute(@ModelAttribute SignUpForm SignUpForm,HttpServletRequest request,HttpServletResponse response, Model model){
		return("signUp");
		
	}
	
	@PostMapping("/signUp")
	public String execute(@ModelAttribute HomeForm HomeForm,HttpServletRequest request,HttpServletResponse response, Model model){
		return("login");
	}
}
