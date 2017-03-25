package jp.co.ameminMJ.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.ameminMJ.web.form.DeckEditForm;
import jp.co.ameminMJ.web.form.DeckHomeForm;

@Controller
public class DeckHomeController {

	
	
	@RequestMapping("/deckEdit")
	public String execute(@ModelAttribute DeckHomeForm deckHomeForm,HttpServletRequest request,HttpServletResponse response, Model model){
		return("deckEdit");
		
	}
	

}
