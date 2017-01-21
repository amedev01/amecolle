package jp.co.ameminMJ.web.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//import jp.co.ameminMJ.service.PlayMahJanggService;

@Controller
public class PlayMahJangController {
	
//	@Autowired
//	PlayMahJanggService playMahJanggService;
	
	@RequestMapping("/play")
	public String execute(Model model){
		
//		playMahJanggService.JFrameTest();
		
		return("index");
	}
}
