package jp.co.amedev.amecolle.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.amedev.amecolle.web.form.DeckEditForm;

@Controller
public class DeckEditController {
	@RequestMapping("deckEdit")
	public String execute(@ModelAttribute @Validated DeckEditForm deckEditForm, BindingResult result, HttpServletRequest request,HttpServletResponse response, Model model){
		if(result.hasErrors()){
			return "deckHome";
		}
		
		
		
		return("deckhome");
		
	}
}
