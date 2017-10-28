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

import jp.co.amedev.amecolle.repository.DeckRepository;
import jp.co.amedev.amecolle.repository.entity.DeckEntity;
import jp.co.amedev.amecolle.repository.entity.MCardEntity;
import jp.co.amedev.amecolle.service.impl.CardServiceImpl;
import jp.co.amedev.amecolle.service.impl.DeckServiceImpl;
import jp.co.amedev.amecolle.service.impl.MCardServiceImpl;
import jp.co.amedev.amecolle.service.impl.UserDetailServiceImpl;
import jp.co.amedev.amecolle.web.form.DeckEditForm;
import jp.co.amedev.amecolle.web.form.DeckHomeForm;

@Controller
public class DeckHomeController {
	
	@Autowired
	UserDetailServiceImpl userDetailServiceImpl; 
	
	@Autowired
	DeckServiceImpl deckServiceImpl;
	
	@Autowired
	MCardServiceImpl mCardServiceImpl;
	
	@Autowired
	CardServiceImpl cardServiceImpl;
	
	@RequestMapping("/deckHome")
	public String execute(@ModelAttribute DeckHomeForm deckHomeForm,HttpServletRequest request,HttpServletResponse response, Model model)
	throws InvocationTargetException ,IllegalAccessException{
	
		
		initialize(deckHomeForm);
		
		return("deckHome");
	}
	
	@RequestMapping("deckEdit")
	public String execute(
			@ModelAttribute @Validated DeckHomeForm deckHomeForm, BindingResult result, 
			HttpServletRequest request,HttpServletResponse response, Model model
			) throws IllegalAccessException, InvocationTargetException{
		if(result.hasErrors()){
			initialize(deckHomeForm);
			return ("deckHome");
		}
		
		final MCardEntity inCard = mCardServiceImpl.pullCard(Long.parseLong(deckHomeForm.getInDeck()));
		
		final DeckEntity deck = initialize(deckHomeForm);
		
		for(MCardEntity deckExsist : deckHomeForm.getDeckCardList()){
			if(deckExsist.getCardId() == inCard.getCardId()){
				result.reject("", new Object[]{}, "同名カードがすでにデッキに存在します。");
				return ("deckHome");
			}
		}
		
		switch(deckHomeForm.getOutDeck()){
			case "1" : deck.setCard1(inCard.getCardId().toString()); break;
			case "2" : deck.setCard2(inCard.getCardId().toString()); break;
			case "3" : deck.setCard3(inCard.getCardId().toString()); break;
		}
		
		deckServiceImpl.update(deck);
		
		return("redirect:/deckHome");
		
	}
	
	private DeckEntity initialize(DeckHomeForm deckHomeForm) throws IllegalAccessException, InvocationTargetException{
		// ログインユーザのデッキ
		final DeckEntity deck = deckServiceImpl.pullDeck(userDetailServiceImpl.getUserId());
		BeanUtils.copyProperties(deckHomeForm, deck);
		
		long card1 = Long.parseLong(deck.getCard1());
		long card2 = Long.parseLong(deck.getCard2());
		long card3 = Long.parseLong(deck.getCard3());
		deckHomeForm.getDeckCardList().add(mCardServiceImpl.pullCard(card1));
		deckHomeForm.getDeckCardList().add(mCardServiceImpl.pullCard(card2));
		deckHomeForm.getDeckCardList().add(mCardServiceImpl.pullCard(card3));

		// ログインユーザ所持カードのリスト
		List<String> cardIdList = cardServiceImpl.getCardIdList(userDetailServiceImpl.getUserId());
		for(String cardId : cardIdList){
			deckHomeForm.getUserCardList().add(mCardServiceImpl.pullCard(Long.parseLong(cardId)));
		}

		return deck;
	}

}
