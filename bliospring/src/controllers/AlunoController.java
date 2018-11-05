package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlunoController {
	@RequestMapping("/aluno/form")
	public String form() {
		System.out.println("Chamou o form de aluno");
		return "aluno/form";
	}
	}
	




















