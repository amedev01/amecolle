package jp.co.amedev.amecolle.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.amedev.amecolle.repository.UserRepository;
import jp.co.amedev.amecolle.repository.entity.UserEntity;
import jp.co.amedev.amecolle.service.impl.UserDetailServiceImpl;
import jp.co.amedev.amecolle.web.form.AccountEditForm;

@Controller
public class AccountEditController {
	// accountDetailで完結
//	@Autowired
//	UserRepository userRepository;
//	
//	@Autowired
//	UserDetailServiceImpl userDetailServiceImpl;
//	
//	@PostMapping("/accountEdit")
//	public String execute(@Validated @ModelAttribute AccountEditForm accountEditForm, BindingResult result,HttpServletRequest request,HttpServletResponse response, Model model){
//		if(result.haｓsErrors()){
//			return  "accountDetail";
//		}
//		UserEntity user = new UserEntity();
//		BeanUtils.copyProperties(accountEditForm, user);
//		userDetailServiceImpl.update(user);
//		
//		return("accountDetail");
//		
//	}
//	
//	@PostMapping("/accountEdit/delete")
//	public String delete(@Validated @ModelAttribute AccountEditForm accountEditForm, BindingResult result, HttpServletRequest request,HttpServletResponse response, Model model){
//		if(result.hasErrors()){
//			return  "redirect:/adminHome";
//		}
//		userDetailServiceImpl.delete(accountEditForm.getId());
//		return "redirect:/adminHome";
//	}
}
