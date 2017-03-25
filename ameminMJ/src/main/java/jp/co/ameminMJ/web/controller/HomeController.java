package jp.co.ameminMJ.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.ameminMJ.web.form.AccountEditForm;
import jp.co.ameminMJ.web.form.BattleHomeForm;
import jp.co.ameminMJ.web.form.DeckHomeForm;
import jp.co.ameminMJ.web.form.GachaHomeForm;

@Controller
public class HomeController {
	@RequestMapping("/accountEdit")
	public String execute(@ModelAttribute AccountEditForm accountEditForm,HttpServletRequest request,HttpServletResponse response, Model model){
		return("accountEdit");
	}
	@RequestMapping("/deckHome")
	public String execute(@ModelAttribute DeckHomeForm DeckHomeForm,HttpServletRequest request,HttpServletResponse response, Model model){
		return("deckHome");
	}
	@RequestMapping("/battleHome")
	public String execute(@ModelAttribute BattleHomeForm BattleHomeForm,HttpServletRequest request,HttpServletResponse response, Model model){
		return("battleHome");	
	}
	@RequestMapping("/gachaHome")
	public String execute(@ModelAttribute GachaHomeForm GachaHomeForm,HttpServletRequest request,HttpServletResponse response, Model model){
		return("gachaHome");	
	}
	
}
