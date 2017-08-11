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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.amedev.amecolle.repository.DeckRepository;
import jp.co.amedev.amecolle.repository.entity.DeckEntity;
import jp.co.amedev.amecolle.repository.entity.MCardEntity;
import jp.co.amedev.amecolle.service.impl.CardServiceImpl;
import jp.co.amedev.amecolle.service.impl.DeckServiceImpl;
import jp.co.amedev.amecolle.service.impl.MCardServiceImpl;
import jp.co.amedev.amecolle.service.impl.UserDetailServiceImpl;
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
	public String execute(@ModelAttribute DeckHomeForm DeckHomeForm,HttpServletRequest request,HttpServletResponse response, Model model)
	throws InvocationTargetException ,IllegalAccessException{
	
		List<String> cardIdList = cardServiceImpl.getCardIdList(userDetailServiceImpl.getUserId());
		List<MCardEntity> userCardList = new ArrayList<>();
		for(String cardId : cardIdList){
			userCardList.add(mCardServiceImpl.pullCard(Long.parseLong(cardId)));
		}
		DeckEntity deck = deckServiceImpl.pullDeck(userDetailServiceImpl.getUserId());
		BeanUtils.copyProperties(DeckHomeForm, deck);
		
		long card1 = Long.parseLong(deck.getCard1());
		long card2 = Long.parseLong(deck.getCard2());
		long card3 = Long.parseLong(deck.getCard3());
		DeckHomeForm.getmCardList().add(mCardServiceImpl.pullCard(card1));
		DeckHomeForm.getmCardList().add(mCardServiceImpl.pullCard(card2));
		DeckHomeForm.getmCardList().add(mCardServiceImpl.pullCard(card3));

		
		return("deckHome");
	}
	
	

}
