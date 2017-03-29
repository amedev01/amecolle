package jp.co.amedev.amecolle.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.amedev.amecolle.web.form.AccountEditForm;
import jp.co.amedev.amecolle.web.form.BattleHomeForm;
import jp.co.amedev.amecolle.web.form.DeckHomeForm;
import jp.co.amedev.amecolle.web.form.GachaHomeForm;
import jp.co.amedev.amecolle.web.form.LoginForm;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String execute(@ModelAttribute LoginForm loginForm,HttpServletRequest request,HttpServletResponse response, Model model){
		return("home");
	}
	
}
