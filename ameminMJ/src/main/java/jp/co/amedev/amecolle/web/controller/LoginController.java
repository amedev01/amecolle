package jp.co.amedev.amecolle.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.amedev.amecolle.web.form.AdminHomeForm;
import jp.co.amedev.amecolle.web.form.LoginForm;
import jp.co.amedev.amecolle.web.form.SignUpForm;

@Controller
public class LoginController {

	
	
	@RequestMapping("/home")
	public String execute(@ModelAttribute LoginForm loginForm,HttpServletRequest request,HttpServletResponse response, Model model){
		return("home");
		
	}
	
	@RequestMapping("/signUp")
	public String execute(@ModelAttribute SignUpForm SignUpForm,HttpServletRequest request,HttpServletResponse response, Model model){
		return("signUp");
		
	}

	@RequestMapping("/adminHome")
	public String execute(@ModelAttribute AdminHomeForm AdminHomeForm,HttpServletRequest request,HttpServletResponse response, Model model){
		return("adminHome");
		
	}
	
}
