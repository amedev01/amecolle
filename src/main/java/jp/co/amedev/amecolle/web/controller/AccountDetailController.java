package jp.co.amedev.amecolle.web.controller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.amedev.amecolle.repository.CardRepository;
import jp.co.amedev.amecolle.repository.MCardRepository;
import jp.co.amedev.amecolle.repository.UserRepository;
import jp.co.amedev.amecolle.repository.entity.MCardEntity;
import jp.co.amedev.amecolle.repository.entity.UserEntity;
import jp.co.amedev.amecolle.service.CardService;
import jp.co.amedev.amecolle.service.impl.UserDetailServiceImpl;
import jp.co.amedev.amecolle.web.form.AdminDetailForm;
import jp.co.amedev.amecolle.web.form.AdminHomeForm;

@Controller
public class AccountDetailController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDetailServiceImpl userDetailServiceImpl;
	
	@Autowired
	MCardRepository mCardRepository;
	
	@Autowired
	CardService cardService;
	
	@Autowired
	CardRepository cardRepository;
	
	@PostMapping("/accountDetail")
	public String execute(@ModelAttribute AdminDetailForm adminDetailForm,HttpServletRequest request,HttpServletResponse response, Model model)throws Exception{
		init(model, adminDetailForm);
		return("accountDetail");
		
	}

	@PostMapping("/accountEdit")
	public String execute(@Validated @ModelAttribute AdminDetailForm adminDetailForm, BindingResult result,HttpServletRequest request,HttpServletResponse response, Model model)throws Exception{
		if(result.hasErrors()){
			init(model, adminDetailForm);
			return  "accountDetail";
		}
		UserEntity user = new UserEntity();
		BeanUtils.copyProperties(user, adminDetailForm);
		userDetailServiceImpl.update(user);
		
		init(model, adminDetailForm);
		return("accountDetail");
	}
	
	@PostMapping("/accountEdit/delete")
	public String delete(@ModelAttribute AdminDetailForm adminDetailForm, BindingResult result, HttpServletRequest request,HttpServletResponse response, Model model){
		cardRepository.delete(adminDetailForm.getId());
		userDetailServiceImpl.delete(adminDetailForm.getId());
		return "redirect:/adminHome";
	}
	
	private void init(Model model, AdminDetailForm adminDetailForm)throws Exception{
		UserEntity user = userRepository.findOne(adminDetailForm.getId());
		List<MCardEntity> mCardList = mCardRepository.findAll();
		List<String> cardIdList = cardService.getCardIdList(adminDetailForm.getId());
		BeanUtils.copyProperties(adminDetailForm, user);
		model.addAttribute("cardIdList", cardIdList);
		model.addAttribute("mCardList", mCardList);
		model.addAttribute("cardNum", cardIdList.size());
	}
}
