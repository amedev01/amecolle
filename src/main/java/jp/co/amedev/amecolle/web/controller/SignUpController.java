package jp.co.amedev.amecolle.web.controller;

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

import jp.co.amedev.amecolle.repository.entity.UserEntity;
import jp.co.amedev.amecolle.service.CardService;
import jp.co.amedev.amecolle.service.impl.UserDetailServiceImpl;
import jp.co.amedev.amecolle.web.form.SignUpForm;

@Controller
public class SignUpController {

	@Autowired
	UserDetailServiceImpl userDetailServiceImpl; 
	
	@Autowired
	CardService cardService;
	
	@RequestMapping("/signUp")
	public String init(@ModelAttribute SignUpForm signUpForm, HttpServletRequest request, HttpServletResponse response, Model model) {
		return ("signUp");

	}

	@RequestMapping("/signUp/exec")
	public String execute(@Validated @ModelAttribute SignUpForm signUpForm, BindingResult result, HttpServletRequest request,HttpServletResponse response, Model model)throws Exception{
		if(result.hasErrors()){
			return "redirect:/signUp";
		}
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties( userEntity,signUpForm);
		userEntity = userDetailServiceImpl.save(userEntity);
		cardService.saveNew(userEntity.getId());
		
		return "redirect:/login";
	}
}
