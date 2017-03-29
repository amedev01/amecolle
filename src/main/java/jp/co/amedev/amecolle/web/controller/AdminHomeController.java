package jp.co.amedev.amecolle.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.amedev.amecolle.web.form.AdminDetailForm;
import jp.co.amedev.amecolle.web.form.AdminHomeForm;


@Controller
public class AdminHomeController {

	
	@RequestMapping("/adminHome")
	public String execute(@ModelAttribute AdminHomeForm AdminHomeForm,HttpServletRequest request,HttpServletResponse response, Model model){
		return("adminHome");
		
	}
	
}
