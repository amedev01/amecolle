package jp.co.amedev.amecolle.web.controller;

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
import jp.co.amedev.amecolle.service.CardService;
import jp.co.amedev.amecolle.service.impl.CardServiceImpl;
import jp.co.amedev.amecolle.service.impl.MCardServiceImpl;
import jp.co.amedev.amecolle.service.impl.UserDetailServiceImpl;
import jp.co.amedev.amecolle.web.form.AdminHomeForm;
import jp.co.amedev.amecolle.web.form.GachaResultForm;

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
		cardServiceImpl.saveGatyaResult(gatyaResult);
		} catch(Exception e){
			result.reject("errors.deckover");
			return("gachaHome");
		}
		return("gachaResult");
	}

	
}
