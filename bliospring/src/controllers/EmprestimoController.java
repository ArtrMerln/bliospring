package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.EmprestimoDAO;
import models.Emprestimo;

@Controller

public class EmprestimoController {
	@RequestMapping("/emprestimo/form")
	public String form() {
		System.out.println("Chamou o form de emprestimo");
		return "emprestimo/form";
	}

	@PostMapping("/emprestimo")
	public String adicionar(Emprestimo emprestimo) {
		EmprestimoDAO emprestimodao = new EmprestimoDAO();
		emprestimodao.inserir(emprestimo);
		System.out.println("adicionou");
		return "redirect:emprestimo";
	}
//test
	@GetMapping("/emprestimo")
	public ModelAndView listar() {
		System.out.println("chamou a listagem de emprestimo");
		EmprestimoDAO emprestimodao = new EmprestimoDAO();
		List<Emprestimo> listand = emprestimodao.getLista();
		ModelAndView model = new ModelAndView("emprestimo/lista");
		model.addObject("emprestimo", listand);
		return model;
	}
	@RequestMapping("/emprestimo/remover")
	public String remover(Emprestimo emprestimo) {
		System.out.println("Chamou a remoção");
		EmprestimoDAO emprestimoDao = new EmprestimoDAO();
		emprestimoDao.devolucao(emprestimo.getAluno().getId(), emprestimo.getLivro().getId());
		System.out.println("removeu o emprestimo");
		return "redirect:../emprestimo";
}}
	

