package jp.co.amedev.amecolle.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.amedev.amecolle.web.form.DeckEditForm;
import jp.co.amedev.amecolle.web.form.DeckHomeForm;

@Controller
public class DeckHomeController {
	@RequestMapping("/deckHome")
	public String execute(@ModelAttribute DeckHomeForm DeckHomeForm,HttpServletRequest request,HttpServletResponse response, Model model){
		return("deckHome");
	}
	

}
