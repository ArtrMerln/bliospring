package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.AlunoDAO;
import dao.EmprestimoDAO;
import dao.LivroDAO;
import models.Aluno;
import models.Emprestimo;
import models.Livro;

@Controller

public class EmprestimoController {
	
		@RequestMapping("/emprestimo/form")
		public ModelAndView form() {
			System.out.println("chamou o form de emprestimo");
			AlunoDAO alunoDao = new AlunoDAO();
			List<Aluno> listandAluno = alunoDao.getLista();

			LivroDAO livroDao = new LivroDAO();
			List<Livro> listandLivro = livroDao.getLista();

			ModelAndView model = new ModelAndView("emprestimo/form");

			model.addObject("aluno", listandAluno);
			model.addObject("livro", listandLivro);

			return model;
		}
	@PostMapping("/emprestimo")
	public String adicionar(Emprestimo emprestimo) {
		EmprestimoDAO emprestimodao = new EmprestimoDAO();
		emprestimodao.inserir(emprestimo);
		System.out.println("adicionou o emprestimo");
		return "redirect:emprestimo";
	}
//test
	
	@GetMapping("/emprestimo")
	public ModelAndView listar() {
		System.out.println("Chamou a listagem");
		EmprestimoDAO emprestimoDao = new EmprestimoDAO();
		List<Emprestimo> listand = emprestimoDao.getLista();
		ModelAndView model = new ModelAndView("emprestimo/lista");
		model.addObject("emprestimo", listand);
		return model;
	}
	
	@RequestMapping("/emprestimo/devolucion")
	public String devolucao(Emprestimo emprestimo) {
		System.out.println("Chamou o método devolução");
		EmprestimoDAO emprestimoDao = new EmprestimoDAO();
		System.out.println(emprestimo);
		emprestimoDao.devolv(emprestimo);
		return "redirect:emprestimo";

	}
	
	}
	

