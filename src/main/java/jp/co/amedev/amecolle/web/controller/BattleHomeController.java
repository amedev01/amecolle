package jp.co.amedev.amecolle.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.amedev.amecolle.repository.entity.DeckEntity;
import jp.co.amedev.amecolle.service.impl.DeckServiceImpl;
import jp.co.amedev.amecolle.service.impl.UserDetailServiceImpl;
import jp.co.amedev.amecolle.web.form.BattleHomeForm;

/**
 * 
 * @author oguma
 *
 */


@Controller
public class BattleHomeController {
	@Autowired
	DeckServiceImpl deckServiceImpl;
	@Autowired
	UserDetailServiceImpl userDetailServiceImpl;
	@RequestMapping("/battleHome")
	public String execute(@ModelAttribute BattleHomeForm BattleHomeForm,HttpServletRequest request,HttpServletResponse response, Model model){
		Authentication test = SecurityContextHolder.getContext().getAuthentication();
		String userName = test.getName();
		long id = userDetailServiceImpl.pullIdByUserId(userName);
		DeckEntity deckEntity = deckServiceImpl.pullDeck(id);
		model.addAttribute(deckEntity);
		return("battleHome");	
	}
}
