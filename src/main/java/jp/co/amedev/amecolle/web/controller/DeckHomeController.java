package jp.co.amedev.amecolle.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.amedev.amecolle.repository.entity.DeckEntity;
import jp.co.amedev.amecolle.service.impl.DeckServiceImpl;
import jp.co.amedev.amecolle.service.impl.UserDetailServiceImpl;
import jp.co.amedev.amecolle.web.form.DeckHomeForm;

@Controller
public class DeckHomeController {
	
	@Autowired
	UserDetailServiceImpl userDetailServiceImpl; 
	
	@Autowired
	DeckServiceImpl deckServiceImpl; 
	
	@RequestMapping("/deckHome")
	public String execute(@ModelAttribute DeckHomeForm DeckHomeForm,HttpServletRequest request,HttpServletResponse response, Model model){
	
		DeckEntity deck = deckServiceImpl.pullDeck(userDetailServiceImpl.getUserId());
		model.addAttribute(deck);
			
		return("deckHome");
	}
	

}
