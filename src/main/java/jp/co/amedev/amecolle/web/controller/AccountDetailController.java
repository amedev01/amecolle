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

import jp.co.amedev.amecolle.repository.CardRepository;
import jp.co.amedev.amecolle.repository.MCardRepository;
import jp.co.amedev.amecolle.repository.UserRepository;
import jp.co.amedev.amecolle.repository.entity.MCardEntity;
import jp.co.amedev.amecolle.repository.entity.UserEntity;
import jp.co.amedev.amecolle.service.CardService;
import jp.co.amedev.amecolle.service.impl.UserDetailServiceImpl;
import jp.co.amedev.amecolle.web.form.AccountDetailForm;

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
	
	@PostMapping("admin/accountDetail")
	public String execute(@ModelAttribute AccountDetailForm accountDetailForm,HttpServletRequest request,HttpServletResponse response, Model model)throws Exception{
		init(model, accountDetailForm);
		return("accountDetail");
		
	}

	@PostMapping("admin/accountDetail/update")
	public String execute(@Validated @ModelAttribute AccountDetailForm accountDetailForm, BindingResult result,HttpServletRequest request,HttpServletResponse response, Model model)throws Exception{
		if(result.hasErrors()){
			init(model, accountDetailForm);
			return  "accountDetail";
		}
		UserEntity user = new UserEntity();
		BeanUtils.copyProperties(user, accountDetailForm);
		userDetailServiceImpl.update(user);
		
		init(model, accountDetailForm);
		return("accountDetail");
	}
	
	@PostMapping("admin/accountDetail/delete")
	public String delete(@ModelAttribute AccountDetailForm accountDetailForm, BindingResult result, HttpServletRequest request,HttpServletResponse response, Model model){
		cardRepository.delete(accountDetailForm.getId());
		userDetailServiceImpl.delete(accountDetailForm.getId());
		return "redirect:/admin/home";
	}
	
	private void init(Model model, AccountDetailForm accountDetailForm)throws Exception{
		UserEntity user = userRepository.findOne(accountDetailForm.getId());
		List<MCardEntity> mCardList = mCardRepository.findAll();
		List<String> cardIdList = cardService.getCardIdList(accountDetailForm.getId());
		BeanUtils.copyProperties(accountDetailForm, user);
		model.addAttribute("cardIdList", cardIdList);
		model.addAttribute("mCardList", mCardList);
		model.addAttribute("cardNum", cardIdList.size());
	}
}
