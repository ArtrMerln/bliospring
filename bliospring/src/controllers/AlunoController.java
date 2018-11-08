package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.AlunoDAO;
import models.Aluno;

@Controller
public class AlunoController {
	@RequestMapping("/aluno/form")
	public String form() {
		System.out.println("Chamou o form de aluno");
		return "aluno/form";
	}

	@PostMapping("/aluno")
	public String adicionar(Aluno aluno) {
		AlunoDAO alunodao = new AlunoDAO();
		alunodao.inserir(aluno);
		System.out.println("adicionou");
		return "redirect:aluno";
	}

	@GetMapping("/aluno")
	public ModelAndView listar() {
		System.out.println("chamou a listagem de aluno");
		AlunoDAO alunodao = new AlunoDAO();
		List<Aluno> listand = alunodao.getLista();
		ModelAndView model = new ModelAndView("aluno/lista");
		model.addObject("aluno", listand);
		return model;
	}
	@RequestMapping("/aluno/remover")
	public String remover(Aluno aluno) {
		System.out.println("Chamou a remoção");
		AlunoDAO alunoDao = new AlunoDAO();
		alunoDao.remover(aluno);
		System.out.println("removeu o aluno");
		return "redirect:../aluno";
}}
