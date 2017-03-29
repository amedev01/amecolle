package jp.co.amedev.amecolle.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.amedev.amecolle.web.form.BattleResultForm;

/**
 * 
 * @author oguma
 *
 */
@Controller
public class BattleResultController {
	@RequestMapping("/battleResult")
	public String execute(@ModelAttribute BattleResultForm battleResultForm,HttpServletRequest request,HttpServletResponse response, Model model){
		return("battleResult");		
	}
}
