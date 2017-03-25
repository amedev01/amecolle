package jp.co.ameminMJ.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.ameminMJ.web.form.AdminHomeForm;
import jp.co.ameminMJ.web.form.BattleHomeForm;
import jp.co.ameminMJ.web.form.DeckHomeForm;
import jp.co.ameminMJ.web.form.GachaHomeForm;
import jp.co.ameminMJ.web.form.LoginForm;
import jp.co.ameminMJ.web.form.SignUpForm;

@Controller
public class HomeController {

	
	
	@RequestMapping("/deckhome")
	public String execute(@ModelAttribute DeckHomeForm DeckHomeForm,HttpServletRequest request,HttpServletResponse response, Model model){
		return("deckhome");
		
	}
	
	@RequestMapping("/battleHome")
	public String execute(@ModelAttribute BattleHomeForm BattleHomeForm,HttpServletRequest request,HttpServletResponse response, Model model){
		return("battleHome");
		
	}

	@RequestMapping("/gachahome")
	public String execute(@ModelAttribute GachaHomeForm GachaHomeForm,HttpServletRequest request,HttpServletResponse response, Model model){
		return("gachahome");
		
	}
	
}
