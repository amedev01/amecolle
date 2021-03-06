package jp.co.amedev.amecolle.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.amedev.amecolle.service.impl.UserDetailServiceImpl;
import jp.co.amedev.amecolle.web.form.AdminHomeForm;


@Controller
public class AdminHomeController {

	@Autowired
	UserDetailServiceImpl userDetailServiceImpl;
	
	@RequestMapping("/admin/home")
	public String execute(@ModelAttribute AdminHomeForm AdminHomeForm,HttpServletRequest request,HttpServletResponse response, Model model){
		model.addAttribute("userList", userDetailServiceImpl.findAll());
		return("adminHome");
	}
	
}
