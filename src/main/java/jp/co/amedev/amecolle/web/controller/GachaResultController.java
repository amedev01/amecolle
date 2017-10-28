package jp.co.amedev.amecolle.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.amedev.amecolle.repository.entity.MCardEntity;
import jp.co.amedev.amecolle.repository.entity.UserEntity;
import jp.co.amedev.amecolle.service.CardService;
import jp.co.amedev.amecolle.service.impl.CardServiceImpl;
import jp.co.amedev.amecolle.service.impl.MCardServiceImpl;
import jp.co.amedev.amecolle.service.impl.UserDetailServiceImpl;
import jp.co.amedev.amecolle.web.form.AdminHomeForm;
import jp.co.amedev.amecolle.web.form.GachaResultForm;
import jp.co.amedev.amecolle.web.form.TutorialGachaResultForm;

/**
 * 
 * @author hiwatashi
 *
 */
@Controller
public class GachaResultController {
	
	@Autowired
	CardServiceImpl cardServiceImpl;
	
	@Autowired
	MCardServiceImpl mCardServiceImpl;

	@Autowired
	UserDetailServiceImpl userDetailServiceImpl; 
	
/*
	@RequestMapping("/gachaResult")
	public String execute(@ModelAttribute GachaResultForm GachaResultForm,HttpServletRequest request,HttpServletResponse response, Model model){
		return("gachaResult");
		
	}
*/
	
	@RequestMapping("/gachaResult")
	public String execute(@Validated @ModelAttribute GachaResultForm gachaResultForm,BindingResult result,HttpServletRequest request,HttpServletResponse response, Model model  ){
		MCardEntity gatyaResult = mCardServiceImpl.pullOneCharacter();
		model.addAttribute("pullOne",gatyaResult);
		// ガチャ結果を保存するための記述
		try{
		int userId = (int) cardServiceImpl.getUserId(); //User aaa → userを持ってくる処理も必要
		cardServiceImpl.saveGatyaResult(gatyaResult,userId);
		} catch(Exception e){
			result.reject("errors.deckover");
			return("gachaHome");
		}
		return("gachaResult");
	}

	@RequestMapping("/signUp/tutorialGachaResult")
	public String execute(@Validated @ModelAttribute TutorialGachaResultForm tutorialGachaResultForm,BindingResult result,HttpServletRequest request,HttpServletResponse response, Model model  ){
		List<MCardEntity> cardList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {	
		cardList.add(mCardServiceImpl.pullOneCharacter());
			if (i > 0 && cardList.get(i).getCardId() == cardList.get(i-1).getCardId()) {
				cardList.remove(i);
				i--;
			}
			if(i == 2 && cardList.get(i).getCardId() == cardList.get(i-2).getCardId() ){
				cardList.remove(i);
				i--;
			}
			
		}
		model.addAttribute("cardList",cardList);
		// ガチャ結果を保存するための記述
		try{
			UserEntity userEntity = new UserEntity();
			userEntity = (UserEntity)request.getSession().getAttribute("userEntity");
			request.getSession().removeAttribute("userEntity");
			int userId = (int) (userEntity.getId()) ; 
			for (MCardEntity gatyaResult : cardList) {
				cardServiceImpl.saveGatyaResult(gatyaResult,userId);				
			}
		} catch(Exception e){
			throw new RuntimeException(e);
		}
		return("tutorialGachaResult");
	}

	
	
}
