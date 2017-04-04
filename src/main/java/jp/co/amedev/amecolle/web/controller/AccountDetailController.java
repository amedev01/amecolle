package jp.co.amedev.amecolle.web.controller;

import java.util.Date;
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
	
	@PostMapping("accountDetail")
	public String display(@ModelAttribute AccountDetailForm accountDetailForm,HttpServletRequest request,HttpServletResponse response, Model model)throws Exception{
		init(model, accountDetailForm);
		return("accountDetail");
	}
	
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
		copyPropertiesForUpdate(accountDetailForm, user);
		userDetailServiceImpl.update(user);
		
		init(model, accountDetailForm);
		return("accountDetail");
	}
	
	@PostMapping("admin/accountDetail/delete")
	public String delete(@ModelAttribute AccountDetailForm accountDetailForm, BindingResult result, HttpServletRequest request,HttpServletResponse response, Model model){
		userDetailServiceImpl.delete(accountDetailForm.getId());
		return "redirect:/admin/home";
	}
	
	private void init(Model model, AccountDetailForm accountDetailForm)throws Exception{
		UserEntity user = userRepository.findOne(accountDetailForm.getId());
		List<MCardEntity> mCardList = mCardRepository.findAll();
		List<String> cardIdList = cardService.getCardIdList(accountDetailForm.getId());
		copyPropertiesForDisplay(user, accountDetailForm);
		model.addAttribute("cardIdList", cardIdList);
		model.addAttribute("mCardList", mCardList);
		model.addAttribute("cardNum", cardIdList.size());
	}
	
	private void copyPropertiesForUpdate(AccountDetailForm from, UserEntity to)throws Exception{
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
	
	private void copyPropertiesForDisplay(UserEntity from, AccountDetailForm to)throws Exception{
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
