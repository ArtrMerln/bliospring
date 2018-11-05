package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //toda vez que for criar um controller tem que fizer
public class Homecontroller {

	
	
	
	@RequestMapping("/") //mapeando o metodo 
	public String homeseila() {
		
		System.out.println("chamou o metodo da home");
		return "home";
		
	}
	
	
	
}
