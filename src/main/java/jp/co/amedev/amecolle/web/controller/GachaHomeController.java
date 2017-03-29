package jp.co.amedev.amecolle.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.amedev.amecolle.web.form.GachaHomeForm;
import jp.co.amedev.amecolle.web.form.GachaResultForm;

/**
 * 
 * @author hiwatashi
 *
 */
@Controller
public class GachaHomeController {

	@RequestMapping("/gachaHome")
	public String execute(@ModelAttribute GachaHomeForm GachaHomeForm,HttpServletRequest request,HttpServletResponse response, Model model){
		return("gachaHome");	
	}
	
}
