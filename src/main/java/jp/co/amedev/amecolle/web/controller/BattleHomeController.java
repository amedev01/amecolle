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
import jp.co.amedev.amecolle.repository.entity.MCardEntity;
import jp.co.amedev.amecolle.service.impl.DeckServiceImpl;
import jp.co.amedev.amecolle.service.impl.MCardServiceImpl;
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
	MCardServiceImpl mCardServiceImpl;
	@Autowired
	UserDetailServiceImpl userDetailServiceImpl;
	@RequestMapping("/battleHome")
	public String execute(@ModelAttribute BattleHomeForm BattleHomeForm,HttpServletRequest request,HttpServletResponse response, Model model){

		// デッキ情報の取得
		Authentication test = SecurityContextHolder.getContext().getAuthentication();
		String userName = test.getName();
		long id = userDetailServiceImpl.pullIdByUserId(userName);
		DeckEntity deckEntity = deckServiceImpl.pullDeck(id);
		model.addAttribute("deckEntity", deckEntity);
		
		// カード情報の取得（1枚目）
		long battleCard1 = Long.parseLong(deckEntity.getCard1());
		MCardEntity mCardEntity1 = mCardServiceImpl.pullCard(battleCard1);
		model.addAttribute("mCardEntity1", mCardEntity1);
		
		// カード情報の取得（2枚目）
		long battleCard2 = Long.parseLong(deckEntity.getCard2());
		MCardEntity mCardEntity2 = mCardServiceImpl.pullCard(battleCard2);
		model.addAttribute("mCardEntity2", mCardEntity2);

		// カード情報の取得（3枚目）
		long battleCard3 = Long.parseLong(deckEntity.getCard3());
		MCardEntity mCardEntity3 = mCardServiceImpl.pullCard(battleCard3);
		model.addAttribute("mCardEntity3", mCardEntity3);
		
		return("battleHome");
	}
}
