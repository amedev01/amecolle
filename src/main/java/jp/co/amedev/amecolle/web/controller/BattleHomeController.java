package jp.co.amedev.amecolle.web.controller;

import java.util.List;

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

		// 自分のデッキ情報の取得
		Authentication test = SecurityContextHolder.getContext().getAuthentication();
		String userName = test.getName();
		long id = userDetailServiceImpl.pullIdByUserId(userName);
		DeckEntity deckEntity = deckServiceImpl.pullDeck(id);
		model.addAttribute("deckEntity", deckEntity);
		
		// 自分のカード情報の取得（1枚目）
		long battleCard1 = Long.parseLong(deckEntity.getCard1());
		MCardEntity mCardEntity1 = mCardServiceImpl.pullCard(battleCard1);
		model.addAttribute("mCardEntity1", mCardEntity1);
		
		// 自分のカード情報の取得（2枚目）
		long battleCard2 = Long.parseLong(deckEntity.getCard2());
		MCardEntity mCardEntity2 = mCardServiceImpl.pullCard(battleCard2);
		model.addAttribute("mCardEntity2", mCardEntity2);

		// 自分のカード情報の取得（3枚目）
		long battleCard3 = Long.parseLong(deckEntity.getCard3());
		MCardEntity mCardEntity3 = mCardServiceImpl.pullCard(battleCard3);
		model.addAttribute("mCardEntity3", mCardEntity3);

		// 相手のデッキ情報の取得
		DeckEntity enemyDeckEntity = deckServiceImpl.pullEnemyDeck(id);
		model.addAttribute("enemyDeckEntity", enemyDeckEntity);
		
		// 相手のカード情報の取得（1枚目）
		long enemyCard1 = Long.parseLong(enemyDeckEntity.getCard1());
		MCardEntity enemyCardEntity1 = mCardServiceImpl.pullCard(enemyCard1);
		model.addAttribute("enemyCardEntity", enemyCardEntity1);
		
		// 相手のカード情報の取得（2枚目）
		long enemyCard2 = Long.parseLong(enemyDeckEntity.getCard2());
		MCardEntity enemyCardEntity2 = mCardServiceImpl.pullCard(enemyCard2);
		model.addAttribute("enemyCardEntity", enemyCardEntity2);
		
		// 相手のカード情報の取得（3枚目）
		long enemyCard3 = Long.parseLong(enemyDeckEntity.getCard3());
		MCardEntity enemyCardEntity3 = mCardServiceImpl.pullCard(enemyCard3);
		model.addAttribute("enemyCardEntity", enemyCardEntity3);

		
		return("battleHome");
	}
}
