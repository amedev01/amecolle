package jp.co.amedev.amecolle.web.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.amedev.amecolle.repository.entity.DeckEntity;
import jp.co.amedev.amecolle.repository.entity.MCardEntity;
import jp.co.amedev.amecolle.service.impl.CardServiceImpl;
import jp.co.amedev.amecolle.service.impl.DeckServiceImpl;
import jp.co.amedev.amecolle.service.impl.MCardServiceImpl;
import jp.co.amedev.amecolle.service.impl.UserDetailServiceImpl;
import jp.co.amedev.amecolle.web.form.DeckEditForm;



@Controller
public class DeckEditController {
	
	@Autowired
	UserDetailServiceImpl userDetailServiceImpl; 

	@Autowired
	DeckServiceImpl deckServiceImpl;

	@Autowired
	MCardServiceImpl mCardServiceImpl;

	@Autowired
	CardServiceImpl cardServiceImpl;

	
	
//	@RequestMapping("deckEdit")
	public String execute(
			@ModelAttribute @Validated DeckEditForm deckEditForm, BindingResult result, 
			HttpServletRequest request,HttpServletResponse response, Model model
			) throws IllegalAccessException, InvocationTargetException{
		if(result.hasErrors()){
			return "forward:/deckHome";
		}
		
		final MCardEntity inCard = mCardServiceImpl.pullCard(Long.parseLong(deckEditForm.getInDeck()));
		// ログインユーザのデッキ
		DeckEntity deck = deckServiceImpl.pullDeck(userDetailServiceImpl.getUserId());
		BeanUtils.copyProperties(deckEditForm, deck);
		
		long card1 = Long.parseLong(deck.getCard1());
		long card2 = Long.parseLong(deck.getCard2());
		long card3 = Long.parseLong(deck.getCard3());
		deckEditForm.getDeckCardList().add(mCardServiceImpl.pullCard(card1));
		deckEditForm.getDeckCardList().add(mCardServiceImpl.pullCard(card2));
		deckEditForm.getDeckCardList().add(mCardServiceImpl.pullCard(card3));
		
		for(MCardEntity deckExsist : deckEditForm.getDeckCardList()){
			if(deckExsist.getCardId() == inCard.getCardId()){
				result.reject("errors.deck.samecard", new Object[]{}, "同名カードがすでにデッキに存在します。");
			}
		}
		
		// ログインユーザ所持カードのリスト
		List<String> cardIdList = cardServiceImpl.getCardIdList(userDetailServiceImpl.getUserId());
		for(String cardId : cardIdList){
			deckEditForm.getUserCardList().add(mCardServiceImpl.pullCard(Long.parseLong(cardId)));
		}
		


		
		return("deckhome");
		
	}
}
