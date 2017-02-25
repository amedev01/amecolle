package jp.co.ameminMJ.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BattleController {

	@RequestMapping("/battlehome")
	public String execute(Model model){
		return("battlehome");
	}
}
