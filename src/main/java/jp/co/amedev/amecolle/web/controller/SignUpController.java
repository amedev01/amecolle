package jp.co.amedev.amecolle.web.controller;

import java.util.Date;

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
import jp.co.amedev.amecolle.web.form.AccountDetailForm;
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
		copyPropertiesForUpdate(signUpForm, userEntity);
		userEntity = userDetailServiceImpl.save(userEntity);
		cardService.saveNew(userEntity.getId());
		
		return "redirect:/login";
	}
	
	private void copyPropertiesForUpdate(SignUpForm from, UserEntity to)throws Exception{
		// when Date　eq null, It will throws Exception.
		long init = 00000000;
		if(from.getLatestLoginTime() == null && from.getUpdateTime() == null){
			from.setLatestLoginTime(new Date(init));
			from.setUpdateTime(new Date(init));
			BeanUtils.copyProperties(to, from);
			to.setLatestLoginTime(null);
			to.setUpdateTime(null);
		}else if(from.getUpdateTime() == null){
			from.setUpdateTime(new Date(init));
			BeanUtils.copyProperties(to, from);
			to.setUpdateTime(null);
		}else if(from.getLatestLoginTime() == null){
			from.setLatestLoginTime(new Date(init));
			BeanUtils.copyProperties(to, from);
			to.setLatestLoginTime(null);
		}else{
			BeanUtils.copyProperties(to, from);
		}
	}
}
